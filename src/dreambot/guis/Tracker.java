/*
 * Created by JFormDesigner on Mon Sep 23 08:16:58 AFT 2019
 */

package dreambot.guis;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Foo
 */
public class Tracker extends JFrame {
    public Tracker() {
        initComponents();
        pack();
        setVisible(true);
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
        label8 = new JLabel();
        label9 = new JLabel();

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
        label4.setText("0%");

        //---- label5 ----
        label5.setText("Username:");

        //---- label7 ----
        label7.setText("Foo");

        //---- label8 ----
        label8.setText("Attemtpts:");

        //---- label9 ----
        label9.setText("0");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(label6)
                            .addGap(87, 87, 87))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(18, 18, 18)
                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label8)
                            .addGap(18, 18, 18)
                            .addComponent(label9, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label6)
                    .addGap(9, 9, 9)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(label5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8)
                        .addComponent(label9))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(116, Short.MAX_VALUE))
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

    private int attempts = 1;

    public Tracker setCurrentTask(String task) {
        if(label2.getText().equalsIgnoreCase(task))
            label9.setText(String.valueOf(attempts++));
        else {
            label2.setText(task);
            attempts = 1;
            label9.setText(String.valueOf(attempts));
        }
        return this;
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
    private JLabel label8;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
