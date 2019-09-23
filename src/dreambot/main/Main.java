package dreambot.main;

import dreambot.data.Cows;
import dreambot.guis.Tracker;
import dreambot.libs.Banking;
import dreambot.libs.Cooking;
import dreambot.libs.Fighting;
import dreambot.libs.Walker;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import sun.font.Script;

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
    private Fighting fighter;
    private Tracker gui;

    @Override
    public void onStart() {
        setProvider(new Loader(new Reference<>(this)));

        gui = new Tracker();
        fighter = getProvider().getLibInstance(Fighting.class);

        /* If player is not yet at location, walk there unless bank is full */
        if (!(walker = getProvider().getLibInstance(Walker.class)).isAtArea(getLocalPlayer().getTile())) {
            walker.setTile(getInventory().isFull() ? getProvider().getLibInstance(Banking.class).getBankLocation() : walker.getRandomTile());
            setScriptPosition(ScriptPosition.WALKING);
        }
    }

    @Override
    public int onLoop() {
        // Check for fire and inventory to be able to cook on
        checkForFire();
        // Check for all possible script positions
        switch (getPosition()) {
            case WALKING:
                gui.setCurrentTask("Walking to task...");
                if (!walker.isAtTile()) walker.walk();
                else {
                    // If we hit the area and the inventory is full,
                    // we know we was going to the bank
                    if(getInventory().isFull()) {
                        gui.setCurrentTask("Initiating banking...");
                        getProvider().getLibInstance(Banking.class).bank();
                    }

                    setScriptPosition(ScriptPosition.WAITING);
                }
                break;
            case WAITING:
                if(getInventory().isFull()) {
                    gui.setCurrentTask("Initiating banking...");
                    walker.setTile(getProvider().getLibInstance(Banking.class).getBankLocation());
                    setScriptPosition(ScriptPosition.WALKING);
                    return Calculations.random(100, 300);
                }
                // Double check the player is not already in combat
                if (getLocalPlayer().isInCombat()) {
                    gui.setCurrentTask("Switching to combat...");
                    setScriptPosition(ScriptPosition.IN_COMBAT);
                }
                // If NPC can be found in, and around the area, then lets attack it
                while (!getPosition().equals(ScriptPosition.IN_COMBAT)) {
                    gui.setCurrentTask("Searching for a cow...");
                    // Find a random cow ID
                    int npcId = Arrays.stream(Cows.getIds()).findAny().getAsInt();
                    // Look for NPC in area and attack it
                    getNpcs().all().stream().filter(npc -> !npc.isInCombat() && npc.getID() == npcId && npc.isOnScreen()).findAny().ifPresent(npc -> {
                        if (!fighter.setNpc(npc).attack()) {
                            // Someone beat us too it, lets move away to make it look less suspicious randomly
                            if (Calculations.random(0, 100) >= 50) {
                                gui.setCurrentTask("Initiating random walk cycle...");
                                walker.setTile(walker.getRandomTile());
                                setScriptPosition(ScriptPosition.WALKING);
                            }
                        }
                        // One was found, lets move to the combat script
                        else setScriptPosition(ScriptPosition.IN_COMBAT);
                    });
                }
            case IN_COMBAT:
                // Anti-Ban goes here
                gui.setCurrentTask("In combat with a Cow...");
                sleepUntil(() -> !getLocalPlayer().isInCombat(), Walker.oneMinute * Calculations.random(3, 5));

                // If no longer in combat and looting enabled, start looting
                if (!getLocalPlayer().isInCombat()) {
                    if (getConfiguration().isLootBones() || getConfiguration().isLootCowHide() || getConfiguration().isLootMeat()) {
                        setScriptPosition(ScriptPosition.LOOTING);
                    }
                }
                // Start Anti-Ban process via configuration

                break;
            case LOOTING:
                gui.setCurrentTask("Looting cow remains...");
                // Pick up all of the dropped items
                Arrays.stream(Cows.getGroundIds()).forEach(id -> {
                    if (
                            (Cows.isBones(id) && getConfiguration().isLootBones())
                                    || (Cows.isCowHide(id) && getConfiguration().isLootCowHide())
                                    || (Cows.isMeat(id) && getConfiguration().isLootMeat())
                    ) {
                        try {
                            getGroundItems().closest(x -> x.getID() == id).interact("Take");
                        } catch (Exception e) {
                            // Someone could of picked it up already, skip over the item
                        }
                    }
                });
                setScriptPosition(ScriptPosition.WAITING);
                break;
            case COOKING:
                // Re-check in case the fire has gone out
                checkForFire();
                if(!getPosition().equals(ScriptPosition.COOKING)) {
                    return Calculations.random(100, 300);
                }
                gui.setCurrentTask("Cooking Cow meat for food...");
                // Cook
                getProvider().getLibInstance(Cooking.class).setPreviousAction(getPosition()).cook();
                // If we have ran out of meat, then go back to cooking
                if(!getInventory().contains(Arrays.stream(Cows.getIds()).filter(id -> Cows.isMeat(id)).findFirst()))
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

    public void checkForFire() {
        // We are already on-route
        if(Cooking.getArea().contains(walker.getSetTile())) return;

        gui.setCurrentTask("Searching for local fires...");
        sleep(100, 300);

        if (getConfiguration().isCookMeat()
                && getInventory().contains(Arrays.stream(Cows.getIds()).filter(id -> Cows.isMeat(id)).findFirst())
                && getInventory().stream().filter(item -> item.getID() == Arrays.stream(Cows.getIds()).filter(id -> Cows.isMeat(id)).findFirst().getAsInt()).toArray().length >= Calculations.random(5, 12)
        ) {
            cookMeat();
            return;
        } else {
            if(getConfiguration().isCookMeat()
            && !getInventory().contains(x -> x.getID() == Cows.getCookedMeatId())
            && getInventory().contains(Arrays.stream(Cows.getIds()).filter(id -> Cows.isMeat(id)).findFirst())
            && getLocalPlayer().getHealthPercent() <= 40) {
                cookMeat();
                return;
            }
        }

        if(getPosition().equals(ScriptPosition.COOKING))
            setScriptPosition(ScriptPosition.WAITING);
    }

    private void cookMeat() {
        // Walk to the area if not there
        if(!walker.isAtArea(Cooking.getArea(), getLocalPlayer().getTile())) {
            gui.setCurrentTask("Walking to any local fire area...");
            walker.setTile(Cooking.getSearchTile());
            setScriptPosition(ScriptPosition.WALKING);
            return;
        }

        if (getGameObjects().closest(x -> x.getID() == Cooking.getFireId()) != null) {
            setScriptPosition(ScriptPosition.COOKING);
        }
    }

}
