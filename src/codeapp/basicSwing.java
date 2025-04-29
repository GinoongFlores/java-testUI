/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeapp;

/**
 *
 * @author ginoongflores
 */

import javax.swing.*;
        
public class basicSwing {
    
    public static void main (String[] args) {
        
        
        System.out.println("Hello World");
        
        // Create the frame (window)
        JFrame frame = new JFrame("My First GUI");
        frame.setSize(600, 300);         // Set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app when window closes

        // Create a button
        JButton button = new JButton("Click Me!");

        // Add button to the frame
        frame.add(button);

        // Make the frame visible
        frame.setVisible(true);
    }
    
}
