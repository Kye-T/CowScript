package dreambot.libs;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.wrappers.interactive.NPC;

public class Fighting extends Library {

    NPC interactingNpc;

    public Fighting setNpc(NPC npc) {
        interactingNpc = npc;
        return this;
    }

    public boolean attack() {
        interactingNpc.interact("Attack");
        getProvider().sleepUntil(() -> !getProvider().getLocalPlayer().isMoving() && getProvider().getLocalPlayer().isInCombat(), Walker.oneSecond * Calculations.random(5, 14));
        return getProvider().getLocalPlayer().isInCombat();
    }

}