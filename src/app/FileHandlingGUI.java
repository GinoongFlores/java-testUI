/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author ginoongflores
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileHandlingGUI extends JFrame {
    // GUI components
    private JTextField nameField, activityField;
    private JButton saveButton;

    public FileHandlingGUI() {
        // Window settings
        setTitle("Activity Logger");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));  // 4 rows, 1 column

        // Add components
        add(new JLabel("Enter your name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Enter your activity:"));
        activityField = new JTextField();
        add(activityField);

        saveButton = new JButton("Save to File");
        add(saveButton);

        // Button action
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        setVisible(true);
    }

    // Method to write input to a text file
    private void saveToFile() {
        String name = nameField.getText();
        String activity = activityField.getText();

        // Validate input
        if (name.isEmpty() || activity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("activity_log.txt", true))) {
            writer.write("Name: " + name + ", Activity: " + activity);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Activity saved!");
            // Clear fields
            nameField.setText("");
            activityField.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new FileHandlingGUI();
    }
}
