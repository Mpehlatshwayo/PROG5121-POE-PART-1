/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginandregistration;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Mpendulo12
 */
public class Loginandregistration {
   

    // Store users in a list (no arrays)
    static List<String> usernames = new ArrayList<>();
    static List<String> passwords = new ArrayList<>();
    static List<String> lastNames = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login & Registration");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205)); // pastel yellow
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JLabel phoneLabel = new JLabel("Phone (+27...):");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel messageLabel = new JLabel("");

        // Fields
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField phoneField = new JTextField();
        JTextField lastNameField = new JTextField();

        // Buttons
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

        // Pastel styling
        Color pastelBlue = new Color(204, 229, 255);
        Color pastelPink = new Color(255, 204, 229);
        usernameField.setBackground(pastelBlue);
        passwordField.setBackground(pastelBlue);
        phoneField.setBackground(pastelBlue);
        lastNameField.setBackground(pastelBlue);
        registerButton.setBackground(pastelPink);
        loginButton.setBackground(pastelPink);
        registerButton.setForeground(Color.BLACK);
        loginButton.setForeground(Color.BLACK);
        messageLabel.setForeground(Color.DARK_GRAY);

        // Add components
        gbc.gridx = 0; gbc.gridy = 0; panel.add(userLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(usernameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(passLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(passwordField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(phoneLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(phoneField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(lastNameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(lastNameField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panel.add(registerButton, gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(loginButton, gbc);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; panel.add(messageLabel, gbc);

        frame.add(panel);
        frame.setVisible(true);

        // Register logic
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String phone = phoneField.getText();
            String lastName = lastNameField.getText();

            if (!username.contains("_") || username.length() > 5) {
                messageLabel.setText("false - Username is not formatted correctly.");
            } else if (!isValidPassword(password)) {
                messageLabel.setText("false - Password does not meet requirements.");
            } else if (!phone.matches("\\+27[6-8][0-9]{8}")) {
                messageLabel.setText("false - Cellphone number incorrectly formatted.");
            } else {
                usernames.add(username);
                passwords.add(password);
                lastNames.add(lastName);
                messageLabel.setText("✅ Registration complete!");
            }
        });

        // Login logic
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean found = false;

            for (int i = 0; i < usernames.size(); i++) {
                if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
                    messageLabel.setText("true - Welcome " + username + ", " + lastNames.get(i) + ", it is great to see you again!");
                    found = true;
                    break;
                }
            }

            if (!found) {
                messageLabel.setText("false - Username or password is incorrect.");
            }
        });
    }

    // Password must be 8+ chars, 1 capital, 1 number, 1 special char
    public static boolean isValidPassword(String password) {
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }
}

    
    

