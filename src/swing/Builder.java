/*
 * Created by JFormDesigner on Thu Feb 09 21:43:04 EET 2017
 */

package swing;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Vector;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author unknown
 */
public class Builder extends JFrame {

    public Builder() {
        initComponents();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setResizable(false);
    }

    private void getImageActionPerformed(ActionEvent e) {
        try {
            JOptionPane.showMessageDialog(null, "Loading image...");
            Work.setImage(new URL(textArea1.getText()));
            JOptionPane.showMessageDialog(null, "Picture uploaded!");

        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid URL or no internet connection!");
        }
    }

    private void viewImageActionPerformed(ActionEvent e) {
        if(Work.getImage()==null)
        {
            JOptionPane.showMessageDialog(null, "Please, upload an image!");
            return;
        }
        imageLabel.setIcon(new ImageIcon(Work.getImage()));
        imageLabel.updateUI();
    }

    private void exitMenuItemActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void getFileActionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        int reply = chooser.showOpenDialog(null);
        if(reply == JFileChooser.APPROVE_OPTION) Work.setImage(chooser.getSelectedFile());
    }

    private void saveImageMenuItemActionPerformed(ActionEvent e) {
        if(Work.getImage()==null)
        {
            JOptionPane.showMessageDialog(null, "Please, upload an image!");
            return;
        }
        JFileChooser chooser = new JFileChooser();
        int reply = chooser.showSaveDialog(null);
        if(reply == JFileChooser.APPROVE_OPTION) Work.saveImage(chooser.getSelectedFile(), "jpg");
        JOptionPane.showMessageDialog(null, "Image is ready for viewing!");
    }

    private void saveImageActionPerformed(ActionEvent e) {
        saveImageMenuItemActionPerformed(e);
    }

    private void aboutMenuItemActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "A program to search, view, and save the new image.\n\n It is necessary to upload a photo via the URL or select an available. In the \"Tab 2\", you can view the selected file or save it.");
    }

    Vector<String> selectItem = new Vector<>();
    int i = 0;

    private void addItemInListActionPerformed(ActionEvent e) {
        selectItem.add("A" + i);
        i++;
        list1.updateUI();
    }
    private void removeItemInListActionPerformed(ActionEvent e) {
        try{
            selectItem.remove(list1.getSelectedIndex());
            list1.updateUI();
        }catch (Exception j)
        {
            JOptionPane.showMessageDialog(null, "Enter item!");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aleksandr Sulyma
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem2 = new JMenuItem();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        label2 = compFactory.createLabel("text");
        button2 = new JButton();
        panel2 = new JPanel();
        button3 = new JButton();
        button4 = new JButton();
        scrollPane2 = new JScrollPane();
        panel3 = new JPanel();
        imageLabel = compFactory.createLabel("");
        panel4 = new JPanel();
        label1 = new JLabel();
        button7 = new JButton();
        button6 = new JButton();
        scrollPane3 = new JScrollPane();
        list1 = new JList(selectItem);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "10dlu, $lcgap, 113dlu, $lcgap, 158dlu, $lcgap, 11dlu",
            "29dlu, $lgap, 15dlu, $lgap, 106dlu, $lgap, 59dlu, $lgap, 7dlu"));

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- menuItem1 ----
                menuItem1.setText("Save Image");
                menuItem1.addActionListener(e -> saveImageMenuItemActionPerformed(e));
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Options");

                //---- menuItem3 ----
                menuItem3.setText("About");
                menuItem3.addActionListener(e -> aboutMenuItemActionPerformed(e));
                menu2.add(menuItem3);

                //---- menuItem2 ----
                menuItem2.setText("Exit");
                menuItem2.addActionListener(e -> exitMenuItemActionPerformed(e));
                menu2.add(menuItem2);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setPreferredSize(new Dimension(458, 254));

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel1.setLayout(new FormLayout(
                    "5dlu, $lcgap, 70dlu, $lcgap, 115dlu, $lcgap, 70dlu, $lcgap, 5dlu",
                    "40dlu, $lgap, 34dlu, $lgap, 71dlu"));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(textArea1);
                }
                panel1.add(scrollPane1, CC.xywh(3, 3, 5, 3));

                //---- button1 ----
                button1.setText("Get Image");
                button1.addActionListener(e -> getImageActionPerformed(e));
                panel1.add(button1, CC.xy(3, 1));

                //---- label2 ----
                label2.setText("Enter URL:");
                panel1.add(label2, CC.xy(5, 1, CC.CENTER, CC.DEFAULT));

                //---- button2 ----
                button2.setText("Get File");
                button2.addActionListener(e -> getFileActionPerformed(e));
                panel1.add(button2, CC.xy(7, 1));
            }
            tabbedPane1.addTab("Tab 1", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(new FormLayout(
                    "7dlu, $lcgap, 70dlu, $lcgap, 115dlu, $lcgap, 70dlu, $lcgap, 5dlu",
                    "44dlu, $lgap, 39dlu, $lgap, 67dlu, $lgap, default"));

                //---- button3 ----
                button3.setText("View");
                button3.addActionListener(e -> viewImageActionPerformed(e));
                panel2.add(button3, CC.xy(3, 1));

                //---- button4 ----
                button4.setText("Save Image");
                button4.addActionListener(e -> saveImageActionPerformed(e));
                panel2.add(button4, CC.xy(7, 1));

                //======== scrollPane2 ========
                {

                    //======== panel3 ========
                    {
                        panel3.setLayout(new BorderLayout());
                        panel3.add(imageLabel, BorderLayout.CENTER);
                    }
                    scrollPane2.setViewportView(panel3);
                }
                panel2.add(scrollPane2, CC.xywh(3, 3, 5, 3));
            }
            tabbedPane1.addTab("Tab 2", panel2);

            //======== panel4 ========
            {
                panel4.setLayout(new FormLayout(
                    "125dlu, $lcgap, 67dlu, $lcgap, 77dlu",
                    "30dlu, $lgap, 125dlu"));

                //---- label1 ----
                label1.setText("Example work JList:");
                panel4.add(label1, CC.xy(1, 1));

                //---- button7 ----
                button7.setText("Add Item");
                button7.addActionListener(e -> addItemInListActionPerformed(e));
                panel4.add(button7, CC.xy(3, 1));

                //---- button6 ----
                button6.setText("Remove Item");
                button6.addActionListener(e -> removeItemInListActionPerformed(e));
                panel4.add(button6, CC.xy(5, 1));

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(list1);
                }
                panel4.add(scrollPane3, CC.xy(1, 3));
            }
            tabbedPane1.addTab("Tab 3", panel4);
        }
        contentPane.add(tabbedPane1, CC.xywh(3, 3, 4, 5));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aleksandr Sulyma
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem2;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JLabel label2;
    private JButton button2;
    private JPanel panel2;
    private JButton button3;
    private JButton button4;
    private JScrollPane scrollPane2;
    private JPanel panel3;
    private JLabel imageLabel;
    private JPanel panel4;
    private JLabel label1;
    private JButton button7;
    private JButton button6;
    private JScrollPane scrollPane3;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
