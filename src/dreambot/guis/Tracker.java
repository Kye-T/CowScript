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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(89, Short.MAX_VALUE)
                    .addComponent(label6)
                    .addGap(87, 87, 87))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label6)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(label2))
                    .addContainerGap(191, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public Tracker setCurrentTask(String task) {
        label2.setText(task);
        return this;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Foo
    private JLabel label6;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
