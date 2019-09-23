package dreambot.data;

import org.dreambot.api.methods.skills.Skill;

import javax.swing.*;

public class SkillTrack {
    private JLabel xpPerHour;
    private JLabel levelsGained;
    private JLabel xpGained;
    private JLabel xpTillLevel;
    private Skill skillType;

    public SkillTrack(JLabel xpPerHour, JLabel levelsGained, JLabel xpGained, JLabel xpTillLevel, Skill skillType) {
        this.xpPerHour = xpPerHour;
        this.levelsGained = levelsGained;
        this.xpGained = xpGained;
        this.xpTillLevel = xpTillLevel;
        this.skillType = skillType;
    }

    public JLabel getXpPerHour() {
        return xpPerHour;
    }

    public JLabel getLevelsGained() {
        return levelsGained;
    }

    public JLabel getXpGained() {
        return xpGained;
    }

    public JLabel getXpTillLevel() {
        return xpTillLevel;
    }

    public Skill getSkillType() {
        return skillType;
    }

    public SkillTrack setXpPerHour(int xp) {
        this.xpPerHour.setText(String.valueOf(xp));
        return this;
    }

    public SkillTrack setLevelsGained(int currentLvl, int lvls) {
        this.levelsGained.setText(currentLvl + " (" + lvls + ")");
        return this;
    }

    public SkillTrack setXpGained(int xp) {
        this.xpGained.setText(String.valueOf(xp));
        return this;
    }

    public SkillTrack setXpTillLevel(int xp) {
        this.xpTillLevel.setText(String.valueOf(xp));
        return this;
    }
}
