/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginandregistration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Mpendulo12
 */

public class Loginandregistration {
    //count the amount oof messages sent
   static int messageCount;
   //stores message information
    static List<String> messagesID = new ArrayList<>();
    static List<String> recipients = new ArrayList<>();
    static List<String> messages = new ArrayList<>();
    
    // Generates a random 10-digit message ID using random method
public static String generateMessageID() {
    //math.radom give us a number between 0.o and 1.0
    //we multiply it by a billion to get a number between  0 and 9999999999
    //L means it is a long number
    //Long converts the number into a whole number not a decimal
    
    long id = (long)(Math.random() * 1_000_000_0000L); // Random number
    //%d stand for decimal and then 010 means makes it 10 digits long
    return String.format("%010d", id); 
}

// Checks if the recipient number is valid (South African format)
public static boolean checkRecipientCell(String cell) {
    
   return cell.startsWith("+27") && cell.length() == 12;

    
}

// Makes sure the message isn't too long doesnt exceed 250 characters
public static boolean isValidMessage(String msg) {
   
    return msg != null && !msg.trim().isEmpty() && msg.length() <= 250;


    
}


// Creates a unique hash for each message using ID and message words.A hash is a unique code for the user
public static String createMessageHash(String messageID, String message) {
    //trim -removes any spaces.
    //split- breake the sentence into indvidual words
    String[] words = message.trim().split("\\s+");
    //gets the first and the last woord of the message
    String firstWord = words[0];
    String lastWord = words[words.length - 1];
   // Now we build the hash string:
///we take the first two digit oof the message Id using substring(0,2)
///We add a colon (:) for separation.
///We take the first digit of the ID using messageID.charAt(0).
///Then we add the first and last words of the message.
///Then we convert everything to uppercase so it looks nicer

    return (messageID.substring(0, 2) + ":" + messageID.charAt(0) + ":" + firstWord + lastWord).toUpperCase();
}


private static void sendMessageFlow() {
       String recipient = JOptionPane.showInputDialog("Enter recipient cell number (+27...)");

    // Validate recipient number
    if (!checkRecipientCell(recipient)) {
        
        JOptionPane.showMessageDialog(null,
                
            "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
        return;
    } else {
        JOptionPane.showMessageDialog(null, "Cell phone number successfully captured.");
    }

    String message = JOptionPane.showInputDialog("Enter your message (max 250 characters)");

    // Validate message length to be less then 250 characters
    if (!isValidMessage(message)) {
        int excess = message.length() - 250;
        JOptionPane.showMessageDialog(null,
            "Message exceeds 250 characters by " + excess + ", please reduce size.");
        return;
    } else {
        JOptionPane.showMessageDialog(null, "Message is ready to send.");
    }

// Generate ID and hash of the user
    String messageID = generateMessageID();
    String hash = createMessageHash(messageID, message);

    // Ask user what to do with the message
    String action = JOptionPane.showInputDialog("Choose:\n1) Send\n2) Disregard\n3) Store\n4) View stored messages");
    
    
    String details;
       details = """
                 Message Details:
                 sage ID: """ + messageID + "\n" +
               "Message Hash: " + hash + "\n" +
               "Recipient: " + recipient + "\n" +
               "Message: " + message;


       switch (action) {
           case "1" -> {
               recipients.add(recipient);
               messages.add(message);
               messagesID.add(messageID);
               messageCount++;
               JOptionPane.showMessageDialog(null, "Message successfully sent.\n\n" +details);
           }
           case "2" -> JOptionPane.showMessageDialog(null, "Press 0 to delete message..\n" +details);
           case "3" -> {
               recipients.add(recipient);
               messages.add(message);
               messagesID.add(messageID);
               messageCount++
                       ;
               storeMessage(messageID, hash, recipient, message); // ✅ This line stores the messag

               JOptionPane.showMessageDialog(null, "Message successfully stored.");
           }
           case "4" -> readStoredMessages();
           
           default -> JOptionPane.showMessageDialog(null, "Invalid option.");
       }


        
        
        
        }


static boolean isLoggedIn= false;
    // Stores user information
    static List<String> usernames = new ArrayList<>();
    static List<String> passwords = new ArrayList<>();
    static List<String> name = new ArrayList<>();

    public static void main(String[] args) {
       

  //JFrame is the main window      
        JFrame frame = new JFrame("Login & Registration");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
//JPanel is the layout
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205)); // pastel yellow
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels- texts or line of words
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JLabel phoneLabel = new JLabel("Phone (+27...):");
        JLabel nameLabel = new JLabel("Name:");
        JLabel messageLabel = new JLabel("");
        JLabel welcomeLabel = new JLabel("");
        welcomeLabel.setFont( new Font("Arial",Font.BOLD, 20));
        

        // Fields- boxes where user types their username,Name and password
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField phoneField = new JTextField();
        JTextField nameField = new JTextField();

        // Buttons
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

        // Pastel styling
        Color pastelBlue = new Color(204, 229, 255);
        Color pastelPink = new Color(255, 204, 229);
        usernameField.setBackground(pastelBlue);
        passwordField.setBackground(pastelBlue);
        phoneField.setBackground(pastelBlue);
        nameField.setBackground(pastelBlue);
        registerButton.setBackground(pastelPink);
        loginButton.setBackground(pastelPink);
        registerButton.setForeground(Color.BLACK);
        loginButton.setForeground(Color.BLACK);
        messageLabel.setForeground(Color.DARK_GRAY);
        welcomeLabel.setForeground(Color.pink);

        // Add components
        gbc.gridx = 0; gbc.gridy = 0; panel.add(userLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(usernameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(passLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(passwordField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(phoneLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(phoneField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panel.add(registerButton, gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(loginButton, gbc);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; panel.add(messageLabel, gbc);
        gbc.gridx= 0; gbc.gridy = 6;panel.add(welcomeLabel, gbc);

        frame.add(panel);
        frame.setVisible(true);

        // Register button and what happenns when you click it,AddActionListener allow us to add a function to the butto
        registerButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String phone = phoneField.getText();
            String Name = nameField.getText();
            if (!username.contains("_") || username.length() > 5) {
                messageLabel.setText("Username is not formatted correctly.");
            } else if (!isValidPassword(password)) {
                messageLabel.setText("Password does not meet requirements.");
            } else if (!phone.matches("\\+27[6-8][0-9]{8}")) {
                messageLabel.setText("Cellphone number incorrectly formatted.");
            } else {
                usernames.add(username);
                passwords.add(password);
                name.add(Name);
                messageLabel.setText("✅ Registration complete!");
            }
        });

        // Login button and wht happens when you click it
        
        loginButton.addActionListener((ActionEvent e) -> {
            //check if user name and password match the stored information
            
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean found = false;
//
for (int i = 0; i < usernames.size(); i++) {
    if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
        messageLabel.setText("Welcome " + username + ", " + name.get(i) + ", it is great to see you again!");
        welcomeLabel.setText("WELCOME TO QUICKCHAT");
        
        isLoggedIn = true;
        if (isLoggedIn) {
            
            
            // Ask how many messages the user wants to send
            String input = JOptionPane.showInputDialog("How many messages do you want to send?");
            
            //parseInt converts a string into an integer
            int totalMessages = Integer.parseInt(input);
            
            int sentMessages = 0;
            
            while (true) {
                // Show menu
                
                String menu = "Choose an option: /1. Send Message  /2. Show Recently Sent Messagesn /3. Quit";
                String choice = JOptionPane.showInputDialog(menu);
                
                if (!choice.equals("1")) if (choice.equals("2")) {
                    //the sending messages button
                    
                    
                    JOptionPane.showMessageDialog(null, "Coming Soon.");
                    
                } else if (choice.equals("3")) {
                    //the quit button section
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1, 2, or 3.");
                } else {
                    //count amount of messagess
                    
                    if (sentMessages < totalMessages) {
                        
                        //the method on how the message will flow or be sent
                        
                        sendMessageFlow();
                        
                        //increment
                        
                        sentMessages++;
                    } else {
                        JOptionPane.showMessageDialog(null, "You've reached your message limit.");
                    }
                }
            }
        }
        found = true;
        break;
    }
}

if (!found) {
    messageLabel.setText("Username or password is incorrect.");
}       });
    }

    // Validation method to check -Password must be 8+ chars, 1 capital, 1 number, 1 special char
    public static boolean isValidPassword(String password) {
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    // This method reads and displays each message from the storedMessagess.json file
    
public static void readStoredMessages() {
    try (BufferedReader reader = new BufferedReader(new FileReader("storedMessagess.json"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            JOptionPane.showMessageDialog(null, "Stored Message:\n" + line);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error reading stored messages: " + e.getMessage());
    }
}

    private static void storeMessage(String messageID, String hash, String recipient, String message) {
    String json = "{\n" +
                  "  \"messageID\": \"" + messageID + "\",\n" +
                  "  \"hash\": \"" + hash + "\",\n" +
                  "  \"recipient\": \"" + recipient + "\",\n" +
                  "  \"message\": \"" + message + "\"\n" +
                  "}";

    try (FileWriter file = new FileWriter("storedMessagess.json", true)) {
        file.write(json + "\n");
        System.out.println("Message written to storedMessagess.json");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error storing message: " + e.getMessage());
    }
} 

        }
        
        
        



    
    
    
    
    
    


    
    

