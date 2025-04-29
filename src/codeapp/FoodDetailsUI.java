package codeapp; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodDetailsUI extends JFrame {
    // Swing components
    private JTextField foodField;
    private JTextField caloriesField;
    private JButton submitButton;

    public FoodDetailsUI() {
        // 1. Frame setup
        super("Food Logger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // center on screen

        // 2. Build form panel
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 3. Add labels and text fields
        panel.add(new JLabel("Food Name:"));              // row 1, col 1
        foodField = new JTextField();                     // row 1, col 2
        panel.add(foodField);

        panel.add(new JLabel("Calories:"));               // row 2, col 1
        caloriesField = new JTextField();                 // row 2, col 2
        panel.add(caloriesField);

        // 4. Add a Submit button
        panel.add(new JLabel());                          // empty cell
        submitButton = new JButton("Submit");             // row 3, col 2
        panel.add(submitButton);

        // 5. Wire up the button click
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String food = foodField.getText().trim();
                String cals = caloriesField.getText().trim();

                // Basic validation
                if (food.isEmpty() || cals.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        FoodDetailsUI.this,
                        "Please enter both food name and calories.",
                        "Input Error",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                // Show the details in a pop-up
                JOptionPane.showMessageDialog(
                    FoodDetailsUI.this,
                    "You logged:\n" +
                    "• Food: " + food + "\n" +
                    "• Calories: " + cals,
                    "Food Details",
                    JOptionPane.INFORMATION_MESSAGE
                );

                // Optionally clear fields for next entry
                foodField.setText("");
                caloriesField.setText("");
                foodField.requestFocus();
            }
        });

        // 6. Add panel to frame
        setContentPane(panel);
    }

    public static void main(String[] args) {
        // Launch on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new FoodDetailsUI().setVisible(true);
        });
    }
}
