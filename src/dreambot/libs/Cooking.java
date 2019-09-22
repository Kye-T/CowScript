package dreambot.libs;

import dreambot.data.Cows;
import dreambot.main.ScriptPosition;
import org.dreambot.api.methods.Calculations;

import java.util.Arrays;

public class Cooking extends Library {

    private final static int fireId = 26185;

    private ScriptPosition pa;

    public Cooking setPreviousAction(ScriptPosition pa) {
        this.pa = pa;
        return this;
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
