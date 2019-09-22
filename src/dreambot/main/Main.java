package dreambot.main;

import dreambot.data.Cows;
import dreambot.libs.Banking;
import dreambot.libs.Cooking;
import dreambot.libs.Fighting;
import dreambot.libs.Walker;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

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

    @Override
    public void onStart() {
        setProvider(new Loader(new Reference<>(this)));

        fighter = getHelper().getLibrary(Fighting.class);

        /* If player is not yet at location, walk there unless bank is full */
        if (!(walker = getHelper().getLibrary(Walker.class)).isAtArea(getLocalPlayer().getTile())) {
            walker.setTile(getInventory().isFull() ? getHelper().getLibrary(Banking.class).getBankLocation() : walker.getRandomTile());
            setScriptPosition(ScriptPosition.WALKING);
        }
    }

    @Override
    public int onLoop() {
        // Check for fire and inventory to be able to cook on
        if (checkForFire())
            // If we did, keep cooking until done
            return Calculations.random(100, 300);
        // Check for all possible script positions
        switch (getPosition()) {
            case WALKING:
                if (!walker.isAtTile()) walker.walk();
                else {
                    // If we hit the area and the inventory is full,
                    // we know we was going to the bank
                    if(getInventory().isFull())
                        getHelper().getLibrary(Banking.class).bank();

                    setScriptPosition(ScriptPosition.WAITING);
                }
                break;
            case WAITING:
                if(getInventory().isFull()) {
                    walker.setTile(getHelper().getLibrary(Banking.class).getBankLocation());
                    setScriptPosition(ScriptPosition.WALKING);
                    return Calculations.random(100, 300);
                }
                // Double check the player is not already in combat
                if (getLocalPlayer().isInCombat())
                    setScriptPosition(ScriptPosition.IN_COMBAT);
                // If NPC can be found in, and around the area, then lets attack it
                while (!getPosition().equals(ScriptPosition.IN_COMBAT)) {
                    // Find a random cow ID
                    int npcId = Arrays.stream(Cows.getIds()).findAny().getAsInt();
                    // Look for NPC in area and attack it
                    getNpcs().all().stream().filter(npc -> !npc.isInCombat() && npc.getID() == npcId && npc.isOnScreen()).findAny().ifPresent(npc -> {
                        if (!fighter.setNpc(npc).attack()) {
                            // Someone beat us too it, lets move away to make it look less suspicious randomly
                            if (Calculations.random(0, 100) >= 50) {
                                walker.setTile(walker.getRandomTile());
                                setScriptPosition(ScriptPosition.WALKING);
                            }
                        }
                        // One was found, lets move to the combat script
                        else setScriptPosition(ScriptPosition.IN_COMBAT);
                    });
                }
            case IN_COMBAT:
                // If no longer in combat and looting enabled, start looting
                if (!getLocalPlayer().isInCombat()) {
                    if (getConfiguration().isLootBones() || getConfiguration().isLootCowHide() || getConfiguration().isLootMeat()) {
                        setScriptPosition(ScriptPosition.LOOTING);
                    }
                }
                // Start Anti-Ban process via configuration

                break;
            case LOOTING:
                // Pick up all of the dropped items
                Arrays.stream(Cows.getGroundIds()).forEach(id -> {
                    if (
                            (Cows.isBones(id) && getConfiguration().isLootBones())
                                    || (Cows.isCowHide(id) && getConfiguration().isLootCowHide())
                                    || (Cows.isMeat(id) && getConfiguration().isLootMeat())
                    ) {
                        try {
                            getGroundItems().closest(x -> x.getID() == id).interact("Pick Up");
                        } catch (Exception e) {
                            // Someone could of picked it up already, skip over the item
                        }
                    }
                });
                setScriptPosition(ScriptPosition.WAITING);
                break;
        }

        // Return short delay
        return Calculations.random(100, 300);
    }

    @Override
    public void onExit() {

    }

    public boolean checkForFire() {
        if (getConfiguration().isCookMeat() && getInventory().contains(Arrays.stream(Cows.getIds()).filter(id -> Cows.isMeat(id)).findFirst())) {
            if (getGameObjects().closest(x -> x.getID() == Cooking.getFireId()) != null) {
                return getHelper().getLibrary(Cooking.class).setPreviousAction(getPosition()).cook();
            }
        }
        return false;
    }

}
