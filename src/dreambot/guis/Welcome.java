/*
 * Created by JFormDesigner on Wed Sep 18 21:13:35 AFT 2019
 */

package dreambot.guis;

import dreambot.data.Configuration;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * Copyright (C) <2019>  <Kye-T>
 * See dtohh.main.Main for GNU license.
 *
 * Example GUI
 */

public class Welcome extends JFrame {

    private Configuration config;

    public Welcome() {
        initComponents();
        pack();
        setVisible(true);
    }

    public void startScript() {
        config = new Configuration(
                camAngles.isSelected(),
                sleeps.isSelected(),
                exp.isSelected(),
                bones.isSelected(),
                meat.isSelected(),
                cowhide.isSelected(),
                cook.isSelected(),
                bank.isSelected(),
                heal.isSelected()
        );

        synchronized (this) {
            this.notifyAll();
        }

        setVisible(false);
    }

    public Configuration getConfig() {
        dispose();
        return config;
    }

    private void button1ActionPerformed(ActionEvent e) {
        startScript();
    }

    private void label2MouseClicked(MouseEvent e) {
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/Kye-T/DBE-Framework"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Foo
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        camAngles = new JCheckBox();
        sleeps = new JCheckBox();
        label9 = new JLabel();
        label10 = new JLabel();
        bones = new JCheckBox();
        label11 = new JLabel();
        label12 = new JLabel();
        meat = new JCheckBox();
        cowhide = new JCheckBox();
        bury = new JCheckBox();
        label13 = new JLabel();
        exp = new JCheckBox();
        label4 = new JLabel();
        cook = new JCheckBox();
        label14 = new JLabel();
        bank = new JCheckBox();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        label20 = new JLabel();
        heal = new JCheckBox();
        label21 = new JLabel();

        //======== this ========
        setTitle("Cow Fighter V1.1");
        setBackground(Color.black);
        Container contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Go Kill Some Cows");
        button1.setForeground(new Color(0, 135, 255));
        button1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- label1 ----
        label1.setText("Created using");
        label1.setFont(new Font("Segoe UI", Font.ITALIC, 10));

        //---- label2 ----
        label2.setText("DBE Wrapper");
        label2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
        label2.setForeground(new Color(0, 135, 255));
        label2.setToolTipText("Download Dreambot Easy Wrapper");
        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label2MouseClicked(e);
            }
        });

        //---- label3 ----
        label3.setText("Cow Fighter V1.1 - DtohhM8");
        label3.setFont(new Font("Segoe UI", Font.ITALIC, 10));

        //---- label5 ----
        label5.setText("Anti-Ban Configuration");
        label5.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label5.setForeground(new Color(0, 135, 255));

        //---- label6 ----
        label6.setText("Cow Fighter V1.1");
        label6.setForeground(new Color(0, 135, 255));
        label6.setFont(new Font("Segoe UI", Font.BOLD, 26));

        //---- label7 ----
        label7.setText("Change Camera Angles");

        //---- label8 ----
        label8.setText("Long/Short Sleeps");

        //---- label9 ----
        label9.setText("Looting Configuration");
        label9.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label9.setForeground(new Color(0, 135, 255));

        //---- label10 ----
        label10.setText("Bones");

        //---- label11 ----
        label11.setText("Meat");

        //---- label12 ----
        label12.setText("Cow Hide");

        //---- bury ----
        bury.setText("Bury");

        //---- label13 ----
        label13.setText("Check Experience");

        //---- label4 ----
        label4.setText("Cook Meat");

        //---- label14 ----
        label14.setText("Bank");

        //---- label15 ----
        label15.setText("Miscellaneous Configuration");
        label15.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label15.setForeground(new Color(0, 135, 255));

        //---- label16 ----
        label16.setText("(Requires players lighting fires)");
        label16.setForeground(new Color(204, 0, 0));

        //---- label17 ----
        label17.setText("(Requires bone looting on)");
        label17.setForeground(new Color(204, 0, 0));

        //---- label18 ----
        label18.setText("(Moves mouse off of screen)");
        label18.setForeground(new Color(204, 0, 0));

        //---- label19 ----
        label19.setText("(Will bank all if no fire can be found en-route)");
        label19.setForeground(new Color(204, 0, 0));

        //---- label20 ----
        label20.setText("Heal");

        //---- label21 ----
        label21.setText("(Will heal at 40% health)");
        label21.setForeground(new Color(204, 0, 0));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label7)
                                        .addComponent(label8)
                                        .addComponent(label13))
                                    .addGap(29, 29, 29)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(camAngles)
                                        .addComponent(exp)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(sleeps)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label18))))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label5)
                                        .addComponent(label9)
                                        .addComponent(label15)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(label4)
                                                .addComponent(label11)
                                                .addComponent(label10)
                                                .addComponent(label12)
                                                .addComponent(label14)
                                                .addComponent(label20))
                                            .addGap(94, 94, 94)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(meat)
                                                .addComponent(cowhide)
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addComponent(bones)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(bury)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(label17))
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(bank)
                                                        .addComponent(cook)
                                                        .addComponent(heal))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label16)
                                                        .addComponent(label19)
                                                        .addComponent(label21)))))))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(139, 139, 139)
                                    .addComponent(label6))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(136, 136, 136)
                                    .addComponent(button1)))
                            .addGap(0, 22, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(label6)
                    .addGap(18, 18, 18)
                    .addComponent(label5)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(camAngles))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label8)
                                .addComponent(sleeps)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(label18)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label13)
                        .addComponent(exp))
                    .addGap(18, 18, 18)
                    .addComponent(label9)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label10)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label11)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label12)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label15))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(bones)
                                        .addComponent(bury)
                                        .addComponent(label17, GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(meat)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cowhide)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(cook)
                                        .addComponent(label16))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(bank)
                                        .addComponent(label19)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label14)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label20)
                                .addComponent(heal)))
                        .addComponent(label21))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(label1)
                        .addComponent(label3))
                    .addGap(12, 12, 12))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Foo
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JCheckBox camAngles;
    private JCheckBox sleeps;
    private JLabel label9;
    private JLabel label10;
    private JCheckBox bones;
    private JLabel label11;
    private JLabel label12;
    private JCheckBox meat;
    private JCheckBox cowhide;
    private JCheckBox bury;
    private JLabel label13;
    private JCheckBox exp;
    private JLabel label4;
    private JCheckBox cook;
    private JLabel label14;
    private JCheckBox bank;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label20;
    private JCheckBox heal;
    private JLabel label21;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
