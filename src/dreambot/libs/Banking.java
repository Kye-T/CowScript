package dreambot.libs;

import dreambot.data.Cows;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Tile;

public class Banking extends Library {
    public Tile getBankLocation() {
        return getProvider().getBank().getClosestBankLocation().getCenter();
    }

    public void bank() {
        getProvider().getBank().open();
        getProvider().sleepUntil(() -> getProvider().getBank().isOpen(), Walker.oneMinute);
        getProvider().getBank().depositAllItems();
        getProvider().getBank().close();
        getProvider().sleepUntil(() -> !getProvider().getBank().isOpen(), Walker.oneSecond * Calculations.random(5, 17));
    }

    public void bankOut() {
        getProvider().getBank().open();
        getProvider().sleepUntil(() -> getProvider().getBank().isOpen(), Walker.oneMinute);
        getProvider().getBank().depositAllItems();
        getProvider().getBank().withdrawAll(Cows.getCookedMeatId());
        getProvider().getBank().close();
        getProvider().sleepUntil(() -> !getProvider().getBank().isOpen(), Walker.oneSecond * Calculations.random(5, 17));
    }
}
