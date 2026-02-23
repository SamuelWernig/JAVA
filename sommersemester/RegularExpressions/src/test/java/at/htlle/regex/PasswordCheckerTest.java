package at.htlle.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordCheckerTest {

    @Test
    void acceptsSecurePasswords() {
        assertTrue(PasswordChecker.isSecurePassword("Password1"));
        assertTrue(PasswordChecker.isSecurePassword("HELLO1234"));
        assertTrue(PasswordChecker.isSecurePassword("A1aaaaaa"));
        assertTrue(PasswordChecker.isSecurePassword("XyZ12345"));
    }

    @Test
    void rejectsTooShortPasswords() {
        assertFalse(PasswordChecker.isSecurePassword("Abc123"));
        assertFalse(PasswordChecker.isSecurePassword("A1aaaaa"));
    }

    @Test
    void rejectsMissingUppercase() {
        assertFalse(PasswordChecker.isSecurePassword("password1"));
        assertFalse(PasswordChecker.isSecurePassword("aaaaaaa1"));
    }

    @Test
    void rejectsMissingNumber() {
        assertFalse(PasswordChecker.isSecurePassword("Password"));
        assertFalse(PasswordChecker.isSecurePassword("ABCDEFGH"));
    }

    @Test
    void rejectsNull() {
        assertFalse(PasswordChecker.isSecurePassword(null));
    }
}
