package dreambot.data;

import org.dreambot.api.Client;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;

public class SkillTrackerV2 extends SkillTracker {
    public SkillTrackerV2(Client client) {
        super(client);
    }

    public int getXpTillNextLevel(Skill s, Skills ss) {
        return ss.getExperienceToLevel(s);
    }
}
