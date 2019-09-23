package dreambot.libs;

import dreambot.data.Cows;
import dreambot.main.ScriptPosition;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

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
            getProvider().getInventory().get(Arrays.stream(Cows.getIds()).filter(id -> Cows.isMeat(id)).findFirst().getAsInt())
                    .useOn(getProvider().getGameObjects().closest(x -> x.getID() == fireId));
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
