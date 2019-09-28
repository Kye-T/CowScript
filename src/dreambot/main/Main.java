package dreambot.main;

import dreambot.data.Cows;
import dreambot.data.SkillTrackerV2;
import dreambot.guis.Tracker;
import dreambot.libs.Banking;
import dreambot.libs.Cooking;
import dreambot.libs.Fighting;
import dreambot.libs.Walker;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.wrappers.items.GroundItem;

import java.util.Arrays;

/**
 *
 *     Copyright (C) <2019>  <Kye-T>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

@ScriptManifest(
        author = "Dtohh",
        name = "Cow Fighter",
        description = "Fights cows at Lumbridge East, banks, cooks and burys bones. Anti-ban.",
        version = 1.1,
        category = Category.COMBAT
)

public class Main extends Provider{
    private Walker walker;
    private Tracker gui;

    @Override
    public void onStart() {
        setProvider(new Loader(new Reference<>(this)));

        gui = new Tracker().setUsername(getLocalPlayer().getName()).setHealth(getCombat().getHealthPercent() + "/" + getLocalPlayer().getHealthPercent() + "%");

        setScriptPosition(ScriptPosition.WAITING);

        /* If player is not yet at location, walk there unless bank is full */
        if (!(walker = getProvider().getLibInstance(Walker.class)).isAtArea(getLocalPlayer().getTile())) {
            walker.setTile(getInventory().isFull() && getConfiguration().isBank() ? getProvider().getLibInstance(Banking.class).getBankLocation() : walker.getRandomTile());
            areaWalkingTo = getInventory().isFull() && getConfiguration().isBank() ? getProvider().getLibInstance(Banking.class).getBankLocation().getArea(3) : walker.getRandomTile().getArea(3);
            setScriptPosition(ScriptPosition.WALKING);
        }

        getSkillTracker().start();
    }

    private Area areaWalkingTo;

    @Override
    public int onLoop() {
        // Looks like the walker instance doesn't get updated with current API
        walker = getProvider().getLibInstance(Walker.class);

        // TODO("If Inventory is full, lets bury em all"


        // Update GUI with SkillTracker
                gui.updateXp(new SkillTrackerV2(getSkillTracker()), getSkills());

        // Check for fire and inventory to be able to cook on
        searchForFire();
        // Update health in GUI
        gui.setHealth(getCombat().getHealthPercent() + "/" + getLocalPlayer().getHealthPercent() + "%");
        // Check for all possible script positions
        switch (getPosition()) {
            case WALKING:
                gui.setCurrentTask("Walking to " + walker.getSetTile().getX() + ", " + walker.getSetTile().getY() + "...");
                if (!walker.getSetTile().getArea(5).contains(getLocalPlayer().getTile()) || !walker.isAtTile()) {

                    if(getWalking().getRunEnergy() >= 20)
                        getWalking().toggleRun();

                    walker.walk();
                    break;
                } else {
                    // If we hit the area and the inventory is full,
                    // we know we was going to the bank
                    if(getInventory().isFull() && getConfiguration().isBank()) {
                        gui.setCurrentTask("Initiating banking...");
                        getProvider().getLibInstance(Banking.class).bank();
                        break;
                    }

                    setScriptPosition(ScriptPosition.WAITING);
                }
                break;
            case WAITING:
                // Check if we should bank
                if(getInventory().isFull() && getConfiguration().isBank()) {
                    gui.setCurrentTask("Initiating banking...");
                    walker.setTile(getProvider().getLibInstance(Banking.class).getBankLocation());
                    setScriptPosition(ScriptPosition.WALKING);
                    break;
                }

                // Double check the player is not already in combat
                if (getLocalPlayer().isInCombat()) {
                    setScriptPosition(ScriptPosition.IN_COMBAT);
                    break;
                }

                // Find a Cow
                NPC cow;
                gui.setCurrentTask("Searching for a Cow...");
                if((cow = getNpcs().closest(x -> !x.isInCombat() && x.getID() == Arrays.stream(Cows.getIds()).findAny().getAsInt())) != null) {
                    cow.interact("Attack");
                    setScriptPosition(ScriptPosition.IN_COMBAT);
                    break;
                }
                else if((cow = getNpcs().closest(x -> !x.isInCombat() && x.getName().equalsIgnoreCase("Cow"))) != null) {
                    cow.interact("Attack");
                    setScriptPosition(ScriptPosition.IN_COMBAT);
                    break;
                }

                gui.setCurrentTask("Could not find a Cow...");
                sleep(200, 300);
                // Walk back to the training area
                areaWalkingTo = walker.getRandomTile().getArea(3);
                walker.setTile(walker.getRandomTile());
                setScriptPosition(ScriptPosition.WALKING);
                break;
            case IN_COMBAT:
                gui.setCurrentTask("In combat with a Cow...");
                sleepUntil(() -> !getLocalPlayer().isInCombat() || getCombat().getHealthPercent() <= 40, Walker.oneSecond * Calculations.random(3, 7));

                heal();

                if(getLocalPlayer().isInCombat()) sleepUntil(() -> !getLocalPlayer().isInCombat(), Walker.oneSecond * Calculations.random(15, 30));

                // If no longer in combat and looting enabled, start looting
                if (!getLocalPlayer().isInCombat()) {
                    if (getConfiguration().isLootBones() || getConfiguration().isLootCowHide() || getConfiguration().isLootMeat()) {
                        setScriptPosition(ScriptPosition.LOOTING);
                    }
                }
                // Start Anti-Ban process via configuration
                // If not done, continue cycle

                break;
            case LOOTING:
                if(getInventory().isFull()) {
                    setScriptPosition(ScriptPosition.WAITING);
                    break;
                }
                gui.setCurrentTask("Looting cow remains...");
                // Pick up all of the dropped items
                Arrays.stream(Cows.getGroundIds()).forEach(id -> {
                    if (
                            (Cows.isBones(id) && getConfiguration().isLootBones())
                                    || (Cows.isCowHide(id) && getConfiguration().isLootCowHide())
                                    || (Cows.isMeat(id) && getConfiguration().isLootMeat())
                    ) {
                        try {
                            GroundItem item;
                            (item = getGroundItems().closest(x -> x.getID() == id)).interact("Take");
                            sleepUntil(() -> !getLocalPlayer().isMoving() && getInventory().contains(item), Walker.oneSecond * Calculations.random(5, 13));
                        } catch (Exception e) {
                            // Someone could of picked it up already, skip over the item
                        }
                    }
                });
                setScriptPosition(ScriptPosition.WAITING);
                break;
            case COOKING:
                // Re-check in case the fire has gone out
                searchForFire();
                if(!getPosition().equals(ScriptPosition.COOKING)) {
                    return Calculations.random(100, 300);
                }
                gui.setCurrentTask("Cooking Cow meat for food...");
                // Cook
                getProvider().getLibInstance(Cooking.class).setPreviousAction(getPosition()).cook();
                // If we have ran out of meat, then go back to cooking
                if(!getInventory().contains(x -> x.getID() == Cows.getMeat()))
                    setScriptPosition(ScriptPosition.WAITING);
                break;
        }

        // Return short delay
        return Calculations.random(100, 300);
    }

    @Override
    public void onExit() {
        gui.setVisible(false);
        gui.dispose();
    }

    public void searchForFire() {
        // We are already on route or cooking is disabled
        if(Cooking.getArea().contains(walker.getSetTile()) || !getConfiguration().isCookMeat()) return;

        // We already have food we can use
        if (getInventory().contains(x -> x.getID() == Cows.getCookedMeatId())) return;

        if(getCombat().getHealthPercent() <= 40 && getInventory().contains(x -> x.getID() == Cows.getMeat())) {
            gui.setCurrentTask("Searching for local fires...");
            cookMeat();
            return;
        }

        // Randomly search for fires if health isn't too low
        if(getInventory().contains(x -> x.getID() == Cows.getMeat()))  {
            if(getInventory().get(x -> x.getID() == Cows.getMeat()).getAmount() >= Calculations.random(3, 10)) {
                gui.setCurrentTask("Searching for local fires...");
                cookMeat();
                return;
            }
        }

        // If all else fails, we can just revert back to waiting
        if(getPosition().equals(ScriptPosition.COOKING))
            setScriptPosition(ScriptPosition.WAITING);
    }

    private void cookMeat() {
        // Walk to the area if not there
        if(!walker.isAtArea(Cooking.getArea(), getLocalPlayer().getTile())) {
            gui.setCurrentTask("Walking to any local fire area...");
            walker.setTile(Cooking.getSearchTile());
            areaWalkingTo = Cooking.getSearchTile().getArea(3);
            setScriptPosition(ScriptPosition.WALKING);
            return;
        }

        if (getGameObjects().closest(x -> x.getID() == Cooking.getFireId()) != null) {
            setScriptPosition(ScriptPosition.COOKING);
        } else {
            if(getConfiguration().isDoCheckBank()) {
                // TODO("Check the bank for food")
                if(!getPosition().equals(ScriptPosition.WALKING) && !walker.isAtArea(getProvider().getLibInstance(Banking.class).getBankLocation().getArea(3), getLocalPlayer().getTile())) {
                    walker.setTile(getProvider().getLibInstance(Banking.class).getBankLocation());
                    areaWalkingTo = getProvider().getLibInstance(Banking.class).getBankLocation().getArea(3);
                    setScriptPosition(ScriptPosition.WALKING);
                } else {
                    getProvider().getLibInstance(Banking.class).bankOut(); // Need to add new method for getting food
                }
            }
            else if(getConfiguration().isDoMakeFire()) {
                // TODO("Check inv has items")
                // TODO("Chop some trees and make a fire")
            }
        }
    }

    private void heal() {
        // If healing is enabled and player drops below 40 health
        // Heal until health is above 60-100 or/and food has ran out
        if(getConfiguration().isHeal() && getCombat().getHealthPercent() <= 40 && getInventory().contains(x -> x.getID() == Cows.getCookedMeatId())) {
            while(getInventory().contains(x -> x.getID() == Cows.getCookedMeatId()) && getCombat().getHealthPercent() <= Calculations.random(60, 100)) {
                getInventory().get(x -> x.getID() == Cows.getCookedMeatId()).interact("Eat");
                sleep(Calculations.random(300, 500), Calculations.random(600, 900));
            }
        }
    }

}
