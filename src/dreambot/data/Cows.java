package dreambot.data;

public class Cows {

    private final static int bones = 526;

    public static int getBones() {
        return bones;
    }

    public static int getMeat() {
        return meat;
    }

    public static int getCowHide() {
        return cowHide;
    }

    private final static int meat = 2132;
    private final static int cowHide = 1739;

    private final static int cookedMeat = 2142;
    private final static int burntMeat = 2146;

    public static int getCookedMeatId() {
        return cookedMeat;
    }

    public static int getBurntMeatId() {
        return burntMeat;
    }

    private final static int[] ids = new int[] {
            2793, 2790, 2791, 2792
    };

    private final static int[] groundIds = new int[] {
        526, 1739, 2132
    };

    public static int[] getIds() {
        return ids;
    }
    public static int[] getGroundIds() { return groundIds; }

    public static boolean isBones(int id) {
        return id == bones;
    }

    public static boolean isMeat(int id) {
        return id == meat;
    }

    public static boolean isCowHide(int id) {
        return id == cowHide;
    }

}
