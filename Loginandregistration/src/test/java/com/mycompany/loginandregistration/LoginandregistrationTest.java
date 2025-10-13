/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.loginandregistration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class LoginandregistrationTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsValidPassword_Valid() {
        String password = "Abc123!x";
        boolean isValid = Loginandregistration.isValidPassword(password);
        assertTrue(isValid);
    }

    @Test
    public void testIsValidPassword_Invalid() {
        String password = "abc";
        boolean isValid = Loginandregistration.isValidPassword(password);
        assertFalse(isValid);
    }

    @Test
    public void testUsernameFormat_Valid() {
        String username = "mp_01";
        boolean isValid = username.contains("_") && username.length() <= 5;
        assertTrue(isValid);
    }

    @Test
    public void testUsernameFormat_Invalid() {
        String username = "mp01";
        boolean isValid = username.contains("_") && username.length() <= 5;
        assertFalse(isValid);
    }

    @Test
    public void testPhoneFormat_Valid() {
        String phone = "+27812345678";
        assertTrue(phone.matches("\\+27[6-8][0-9]{8}"));
    }

    @Test
    public void testPhoneFormat_Invalid() {
        String phone = "0821234567";
        assertFalse(phone.matches("\\+27[6-8][0-9]{8}"));
    }

    /**
     * Test of generateMessageID method, of class Loginandregistration.
     */
    @Test
    public void testGenerateMessageID() {
    System.out.println("Testing generateMessageID...");
    // Call the method under test
    String id = Loginandregistration.generateMessageID();


    // The ID should not be null
    assertNotNull(id, "Message ID should not be null");

    // The ID should only contain digits
    assertTrue(id.matches("\\d+"), "Message ID should only contain digits");

    // The ID should be exactly 10 digits long
    assertEquals(10, id.length(), "Message ID should be 10 digits long");




    }

    /**
     * Test of checkRecipientCell method, of class Loginandregistration.
     * A valid cell number must start with '+' and contain digits.(+27)
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        // Valid number
    assertTrue(Loginandregistration.checkRecipientCell("+27821234567"));

    // Missing international code
    assertFalse(Loginandregistration.checkRecipientCell("0821234567"));

    // Empty string
    assertFalse(Loginandregistration.checkRecipientCell(""));


    }

    /**
     * Test of isValidMessage method, of class Loginandregistration.
     */
    @Test
    public void testIsValidMessage() {
        // Case 1: A normal valid message
    assertTrue(Loginandregistration.isValidMessage("Hello, this is a valid message."));

    // Case 2: A very short message like "hi" should still be valid
    assertTrue(Loginandregistration.isValidMessage("hi"));

    // Case 3: Empty message should be invalid
    assertFalse(Loginandregistration.isValidMessage(""));

    // Case 4: Too long message (251 characters) should be invalid
    String longMessage = "a".repeat(251);
    assertFalse(Loginandregistration.isValidMessage(longMessage));


    }

    /**
     * Test of createMessageHash method, of class Loginandregistration.
     * This test ensures the hash is generated and not empty.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
       String hash = Loginandregistration.createMessageHash("12345", "Hello");

    // The hash should not be null
    assertNotNull(hash);

    // The hash should not be empty
    assertFalse(hash.isEmpty());

    // Optional: check that it contains some expected structure (e.g., digits or colons)
    assertTrue(hash.length() > 0);

    }

    /**
     * Test of main method, of class Loginandregistration.
     * This test just checks that the program runs without crashing.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
         try {
        Loginandregistration.main(args);
    } catch (Exception e) {
        fail("Main method threw an exception: " + e.getMessage());
    }


    }

    /**
     * Test of isValidPassword method, of class Loginandregistration.
     * This test checks different password scenarios to ensure the validation rules work.
     */


 
    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
       // Case 1: A valid password (meets all rules: length, uppercase, number, special char)
    assertTrue(Loginandregistration.isValidPassword("Abcdef1!"));

    // Case 2: Too short (should fail)
    assertFalse(Loginandregistration.isValidPassword("Ab1!"));

    // Case 3: Missing number (should fail)
    assertFalse(Loginandregistration.isValidPassword("Abcdefgh!"));

   


    }
    /**
 * Test of readStoredMessages method, of class Loginandregistration.
 * This test ensures that the stored messages file can be read without errors.
 *  - It should not throw an exception
 *  - It should contain at least one line if messages were stored
 */
  @Test
  public void testReadStoredMessages() {
      System.out.println("Testing readStoredMessages...");

       try (BufferedReader reader = new BufferedReader(new FileReader("storedMessagess.json"))) {
        String line = reader.readLine();

        // If you have stored at least one message, the file should not be empty
        assertNotNull("Stored messages file should contain at least one message", line);

    } catch (IOException e) {
        fail("Could not read stored messages: " + e.getMessage());
    }
}



    }

