package dreambot.libs;

import dreambot.data.Cows;
import dreambot.main.ScriptPosition;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.GameObject;

import java.util.Arrays;

public class Cooking extends Library {

    private final static int fireId = 26185;

    private final static Area searchArea = new Area(
            new Tile(3257, 3230, 0),
            new Tile(3250, 3230, 0),
            new Tile(3250, 3251, 0),
            new Tile(3257, 3249, 0)
    );

    private ScriptPosition pa;

    public Cooking setPreviousAction(ScriptPosition pa) {
        this.pa = pa;
        return this;
    }

    public static Area getArea() {
        return searchArea;
    }

    public static Tile getSearchTile() {
        return searchArea.getRandomTile();
    }

    public boolean cook() {
        try {
            GameObject fire = getProvider().getGameObjects().closest(x -> x.getID() == fireId);

            if(fire != null) {
                getProvider().getWalking().walkOnScreen(fire.getTile());
                getProvider().sleepUntil(() -> !getProvider().getLocalPlayer().isMoving(), Walker.oneSecond * Calculations.random(4, 9));
            }

            try {
                getProvider().getInventory().get(Cows.getMeat())
                        .useOn(getProvider().getGameObjects().closest(x -> x.getID() == fireId));
            } catch (Exception e) {
                // Fire could of tarnished
            }

            getProvider().sleepUntil(() -> !getProvider().getLocalPlayer().isAnimating(), Walker.oneSecond * Calculations.random(8, 19));
            getProvider().setScriptPosition(pa);
            return true;
        } catch (Exception e) {
            // Fire may have died out, lets go back to searching for fires
            // Or doing the previous action if non left
            getProvider().setScriptPosition(pa);
            return false;
        }
    }

    public static int getFireId() {
        return fireId;
    }

    public ScriptPosition getPreviousAction() {
        return pa;
    }
}
