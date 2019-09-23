/*
 * Created by JFormDesigner on Mon Sep 23 08:16:58 AFT 2019
 */

package dreambot.guis;

import dreambot.data.SkillTrack;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

import static java.util.Arrays.asList;

/**
 * @author Foo
 */
public class Tracker extends JFrame {
    private ArrayList<SkillTrack> skills;

    public Tracker() {
        initComponents();
        pack();
        setVisible(true);

        skills = new ArrayList<>(asList(
                new SkillTrack(label16, label17, label18, label19, Skill.ATTACK),
                new SkillTrack(label20, label21, label22, label23, Skill.STRENGTH),
                new SkillTrack(label24, label25, label26, label27, Skill.DEFENCE),
                new SkillTrack(label28, label29, label30, label31, Skill.HITPOINTS),
                new SkillTrack(label32, label33, label34, label35, Skill.COOKING),
                new SkillTrack(label36, label37, label38, label39, Skill.PRAYER)
        ));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Foo
        label6 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label7 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        label27 = new JLabel();
        label28 = new JLabel();
        label29 = new JLabel();
        label30 = new JLabel();
        label31 = new JLabel();
        label32 = new JLabel();
        label33 = new JLabel();
        label34 = new JLabel();
        label35 = new JLabel();
        label36 = new JLabel();
        label37 = new JLabel();
        label38 = new JLabel();
        label39 = new JLabel();

        //======== this ========
        setTitle("Cow Fighter V1.0");
        Container contentPane = getContentPane();

        //---- label6 ----
        label6.setText("Cow Fighter V1.1");
        label6.setForeground(new Color(0, 135, 255));
        label6.setFont(new Font("Segoe UI", Font.BOLD, 26));

        //---- label1 ----
        label1.setText("Task:");

        //---- label2 ----
        label2.setText("Waiting...");

        //---- label3 ----
        label3.setText("Health:");

        //---- label4 ----
        label4.setText("0/0%");

        //---- label5 ----
        label5.setText("Username:");

        //---- label7 ----
        label7.setText("Foo");

        //---- label9 ----
        label9.setText("XP Status");
        label9.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label9.setForeground(new Color(0, 135, 255));

        //---- label10 ----
        label10.setText("Attack");

        //---- label11 ----
        label11.setText("Strength");

        //---- label12 ----
        label12.setText("Defence");

        //---- label13 ----
        label13.setText("Hit Points");

        //---- label14 ----
        label14.setText("Cooking");

        //---- label15 ----
        label15.setText("Prayer");

        //---- label16 ----
        label16.setText("0/h");

        //---- label17 ----
        label17.setText("0 (+0)");

        //---- label18 ----
        label18.setText("+0");

        //---- label19 ----
        label19.setText("0");

        //---- label20 ----
        label20.setText("0/h");

        //---- label21 ----
        label21.setText("0 (+0)");

        //---- label22 ----
        label22.setText("+0");

        //---- label23 ----
        label23.setText("0");

        //---- label24 ----
        label24.setText("0/h");

        //---- label25 ----
        label25.setText("0 (+0)");

        //---- label26 ----
        label26.setText("+0");

        //---- label27 ----
        label27.setText("0");

        //---- label28 ----
        label28.setText("0/h");

        //---- label29 ----
        label29.setText("0 (+0)");

        //---- label30 ----
        label30.setText("+0");

        //---- label31 ----
        label31.setText("0");

        //---- label32 ----
        label32.setText("0/h");

        //---- label33 ----
        label33.setText("0 (+0)");

        //---- label34 ----
        label34.setText("+0");

        //---- label35 ----
        label35.setText("0");

        //---- label36 ----
        label36.setText("0/h");

        //---- label37 ----
        label37.setText("0 (+0)");

        //---- label38 ----
        label38.setText("+0");

        //---- label39 ----
        label39.setText("0");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label10)
                                .addComponent(label5))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label3)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label12)
                                        .addComponent(label11)
                                        .addComponent(label13)
                                        .addComponent(label14)
                                        .addComponent(label15))))
                            .addGap(0, 219, Short.MAX_VALUE))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(label6))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(109, 109, 109)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label20)
                                            .addGap(18, 18, 18)
                                            .addComponent(label21)
                                            .addGap(18, 18, 18)
                                            .addComponent(label22)
                                            .addGap(18, 18, 18)
                                            .addComponent(label23))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label16)
                                            .addGap(18, 18, 18)
                                            .addComponent(label17)
                                            .addGap(18, 18, 18)
                                            .addComponent(label18)
                                            .addGap(18, 18, 18)
                                            .addComponent(label19))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label32)
                                            .addGap(18, 18, 18)
                                            .addComponent(label33)
                                            .addGap(18, 18, 18)
                                            .addComponent(label34)
                                            .addGap(18, 18, 18)
                                            .addComponent(label35))
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label24)
                                                .addGap(18, 18, 18)
                                                .addComponent(label25)
                                                .addGap(18, 18, 18)
                                                .addComponent(label26)
                                                .addGap(18, 18, 18)
                                                .addComponent(label27))
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label28)
                                                .addGap(18, 18, 18)
                                                .addComponent(label29)
                                                .addGap(18, 18, 18)
                                                .addComponent(label30)
                                                .addGap(18, 18, 18)
                                                .addComponent(label31)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label36)
                                            .addGap(18, 18, 18)
                                            .addComponent(label37)
                                            .addGap(18, 18, 18)
                                            .addComponent(label38)
                                            .addGap(18, 18, 18)
                                            .addComponent(label39))))
                                .addComponent(label9))))
                    .addGap(0, 47, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label6)
                    .addGap(9, 9, 9)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(label7))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addComponent(label9)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label10)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label11)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label12)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label13)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label14)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label15)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label16)
                                        .addComponent(label17)
                                        .addComponent(label18)
                                        .addComponent(label19))
                                    .addGap(28, 28, 28))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup()
                                    .addComponent(label20)
                                    .addComponent(label21)
                                    .addComponent(label22)
                                    .addComponent(label23)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label24)
                                .addComponent(label25)
                                .addComponent(label26)
                                .addComponent(label27))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label28)
                                .addComponent(label29)
                                .addComponent(label30)
                                .addComponent(label31))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label32)
                                .addComponent(label33)
                                .addComponent(label34)
                                .addComponent(label35))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label36)
                                .addComponent(label37)
                                .addComponent(label38)
                                .addComponent(label39))))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public Tracker setUsername(String u) {
        label7.setText(u);
        return this;
    }

    public Tracker setHealth(String h) {
        label4.setText(h);
        return this;
    }

    public Tracker setCurrentTask(String task) {
        label2.setText(task);
        return this;
    }

    public void updateXp(SkillTracker st) {
        skills.forEach(x -> {
            x.setXpPerHour(st.getGainedExperiencePerHour(x.getSkillType()));
            x.setLevelsGained(st.getStartLevel(x.getSkillType()), st.getGainedLevels(x.getSkillType()));
            x.setXpGained((int) st.getGainedExperience(x.getSkillType()));
            x.setXpTillLevel(st.getStartExperience(x.getSkillType()));
        });

        updateGuiXP();
    }

    private void updateGuiXP() {
        skills.forEach(x -> {
            switch(x.getSkillType()) {
                case ATTACK:
                    label16 = x.getXpPerHour();
                    label17 = x.getLevelsGained();
                    label18 = x.getXpPerHour();
                    label19 = x.getXpTillLevel();
                    break;
                case STRENGTH:
                    label20 = x.getXpPerHour();
                    label21 = x.getLevelsGained();
                    label22 = x.getXpPerHour();
                    label23 = x.getXpTillLevel();
                    break;
                case DEFENCE:
                    label24 = x.getXpPerHour();
                    label25 = x.getLevelsGained();
                    label26 = x.getXpPerHour();
                    label27 = x.getXpTillLevel();
                    break;
                case HITPOINTS:
                    label28 = x.getXpPerHour();
                    label29 = x.getLevelsGained();
                    label30 = x.getXpPerHour();
                    label31 = x.getXpTillLevel();
                    break;
                case COOKING:
                    label32 = x.getXpPerHour();
                    label33 = x.getLevelsGained();
                    label34 = x.getXpPerHour();
                    label35 = x.getXpTillLevel();
                    break;
                case PRAYER:
                    label36 = x.getXpPerHour();
                    label37 = x.getLevelsGained();
                    label38 = x.getXpPerHour();
                    label39 = x.getXpTillLevel();
                    break;
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Foo
    private JLabel label6;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label7;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private JLabel label27;
    private JLabel label28;
    private JLabel label29;
    private JLabel label30;
    private JLabel label31;
    private JLabel label32;
    private JLabel label33;
    private JLabel label34;
    private JLabel label35;
    private JLabel label36;
    private JLabel label37;
    private JLabel label38;
    private JLabel label39;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
