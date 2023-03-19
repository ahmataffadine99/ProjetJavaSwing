package Dashboard;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Mar 18 22:32:38 CET 2023
 */



/**
 * @author ahmat
 */
public class DashboardAdmin extends JPanel {
    public DashboardAdmin() {
        initComponents();
        setLayout(new BorderLayout());
        add(label1, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        add(buttonPanel, BorderLayout.CENTER);
    }


    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - ahmat abdoulaye
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        label1 = new JLabel();

        //---- button1 ----
        button1.setText("Livres");
        button1.setBackground(new Color(0xcccc00));
        button1.setForeground(Color.black);
        button1.addActionListener(e -> button1(e));

        //---- button2 ----
        button2.setText("Exemplaires");
        button2.setForeground(Color.black);
        button2.setBackground(new Color(0xcccc00));

        //---- button3 ----
        button3.setText("Emprunteurs");
        button3.setForeground(Color.black);
        button3.setBackground(new Color(0xcccc00));

        //---- button4 ----
        button4.setText("Emprunts");
        button4.setForeground(Color.black);
        button4.setBackground(new Color(0xcccc00));

        //---- button5 ----
        button5.setText("Utilisateurs");
        button5.setForeground(Color.black);
        button5.setBackground(new Color(0x999900));

        //---- button6 ----
        button6.setText("Deconnexion");
        button6.setForeground(Color.black);
        button6.setBackground(new Color(0x999900));

        //---- label1 ----
        label1.setText("                                                    Tableau de bord");
        label1.setMaximumSize(new Dimension(95, 19));
        label1.setForeground(new Color(0x33ccff));
        label1.setBorder(UIManager.getBorder("InternalFrame.border"));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - ahmat abdoulaye
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
