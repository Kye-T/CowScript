package dreambot.libs;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

public class Walker extends Library {
    private Area area = new Area(
            new Tile(3253, 3255, 0),
            new Tile(3265, 3255, 0),
            new Tile(3265, 3296, 0),
            new Tile(3265, 3296, 0)
    );

    public static int oneSecond = 100;
    public static int oneMinute = oneSecond * 60;
    public static int oneHour = oneMinute * 60;

    private Tile t;

    public Walker setTile(Tile tile) {
        t = tile;
        return this;
    }


    public Tile getSetTile() {
        return t;
    }

    public void walk() {
        getProvider().getWalking().walk(t);
        getProvider().sleepUntil(() -> !getProvider().getLocalPlayer().isMoving(), oneHour);
    }

    public boolean isAtTile() {
        return getProvider().getLocalPlayer().getTile().equals(t);
    }

    public boolean isAtArea(Tile t) {
        return area.contains(t);
    }
    public boolean isAtArea(Area a, Tile t) {
        return a.contains(t);
    }

    public Tile getRandomTile() {
        return area.getRandomTile();
    }
}
