package com.shelly0.dmxduo.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by vogeslu on 03.10.17.
 */
public class UserInterface {

    public JFrame jFrame;
    public JTable jTable;

    public JTextField textFieldTitle;
    public JFormattedTextField textFieldCount;
    public JTextField textFieldManufacturerID;
    public JTextField textFieldNotes;

    public void createWindow() {
        jFrame = new JFrame();
        jFrame.setSize(800,700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle("Items");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setResizable(false);

        Object[] columnNames =  {
                "ID", "Bezeichnung", "Anzahl", "Manufakturkennung","Bemerkungen"
        };

        DefaultTableModel model = new DefaultTableModel();
        jTable = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Bezeichnung");
        model.addColumn("Anzahl");
        model.addColumn("Manufakturkennung");
        model.addColumn("Bemerkungen");

        jTable.setBorder(null);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(5,5,790,600);
        jFrame.add(jScrollPane);

        {
            JLabel jLabel = new JLabel("Bezeichnung");

            jLabel.setBounds(10, 615, 200, 30);
            jLabel.setVisible(true);
            jFrame.add(jLabel);
            jLabel.repaint();
        }
        {
            JLabel jLabel = new JLabel("Anzahl");

            jLabel.setBounds(215, 615, 75, 30);
            jLabel.setVisible(true);
            jFrame.add(jLabel);
            jLabel.repaint();
        }
        {
            JLabel jLabel = new JLabel("Manufakturkennung");

            jLabel.setBounds(295, 615, 200, 30);
            jLabel.setVisible(true);
            jFrame.add(jLabel);
            jLabel.repaint();
        }
        {
            JLabel jLabel = new JLabel("Bemerkungen");

            jLabel.setBounds(500, 615, 200, 30);
            jLabel.setVisible(true);
            jFrame.add(jLabel);
            jLabel.repaint();
        }
        {
            JButton jButton = new JButton("Eintragen");

            jButton.setBounds(700, 640, 90, 30);
            jButton.setVisible(true);
            jFrame.add(jButton);
            jButton.repaint();
        }

        {
            textFieldTitle = new JTextField();

            textFieldTitle.setBounds(5, 640, 200, 30);
            textFieldTitle.setVisible(true);
            jFrame.add(textFieldTitle);
            textFieldTitle.repaint();
        }
        {
            NumberFormat format = NumberFormat.getInstance();
            NumberFormatter formatter = new NumberFormatter(format);
            formatter.setValueClass(Integer.class);
            formatter.setMinimum(0);
            formatter.setMaximum(Integer.MAX_VALUE);
            textFieldCount = new JFormattedTextField(formatter);

            textFieldCount.setBounds(210, 640, 75, 30);
            textFieldCount.setVisible(true);
            jFrame.add(textFieldCount);
            textFieldCount.repaint();
        }
        {
            textFieldManufacturerID = new JTextField();

            textFieldManufacturerID.setBounds(290, 640, 200, 30);
            textFieldManufacturerID.setVisible(true);
            jFrame.add(textFieldManufacturerID);
            textFieldManufacturerID.repaint();
        }
        {
            textFieldNotes = new JTextField();

            textFieldNotes.setBounds(495, 640, 200, 30);
            textFieldNotes.setVisible(true);
            jFrame.add(textFieldNotes);
            textFieldNotes.repaint();
        }
        {
            JButton jButton = new JButton("Eintragen");

            jButton.setBounds(700, 640, 90, 30);

            jFrame.add(jButton);
        }
    }
}
