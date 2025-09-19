/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.loginandregistration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginandregistrationTest {

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
}
