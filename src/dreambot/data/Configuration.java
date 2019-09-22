package dreambot.data;

public class Configuration {
    private boolean changeCameraAngles;
    private boolean takeSleeps;
    private boolean checkXp;
    private boolean lootBones;
    private boolean lootMeat;
    private boolean lootCowHide;
    private boolean cookMeat;
    private boolean bank;
    private boolean heal;

    public Configuration(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f, boolean g, boolean h, boolean i) {
        changeCameraAngles = a;
        takeSleeps = b;
        checkXp = c;
        lootBones = d;
        lootMeat = e;
        lootCowHide = f;
        cookMeat = g;
        bank = h;
        heal = i;
    }

    public boolean isHeal() {
        return heal;
    }

    public boolean isChangeCameraAngles() {
        return changeCameraAngles;
    }

    public boolean isTakeSleeps() {
        return takeSleeps;
    }

    public boolean isCheckXp() {
        return checkXp;
    }

    public boolean isLootBones() {
        return lootBones;
    }

    public boolean isLootMeat() {
        return lootMeat;
    }

    public boolean isLootCowHide() {
        return lootCowHide;
    }

    public boolean isCookMeat() {
        return cookMeat;
    }

    public boolean isBank() {
        return bank;
    }
}