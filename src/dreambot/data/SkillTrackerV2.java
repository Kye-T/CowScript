package dreambot.data;

import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;

public class SkillTrackerV2 {
    SkillTracker t;

    public SkillTrackerV2(SkillTracker t) {
        this.t = t;
    }

    public SkillTracker getTracker() { return t; }

    public int getXpTillNextLevel(Skill s, Skills ss) {
        return ss.getExperienceToLevel(s);
    }
}
