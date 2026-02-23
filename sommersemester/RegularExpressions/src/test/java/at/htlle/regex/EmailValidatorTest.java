package at.htlle.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    @Test
    void acceptsValidEmails() {
        assertTrue(EmailValidator.isValidEmail("test@example.com"));
        assertTrue(EmailValidator.isValidEmail("john.doe@mail.at"));
        assertTrue(EmailValidator.isValidEmail("user_123@test-domain.org"));
        assertTrue(EmailValidator.isValidEmail("a+b@test.co"));
    }

    @Test
    void rejectsInvalidEmails() {
        assertFalse(EmailValidator.isValidEmail("test@"));
        assertFalse(EmailValidator.isValidEmail("@example.com"));
        assertFalse(EmailValidator.isValidEmail("test@example"));
        assertFalse(EmailValidator.isValidEmail("test@@example.com"));
        assertFalse(EmailValidator.isValidEmail("test example@test.com"));
    }

    @Test
    void rejectsNull() {
        assertFalse(EmailValidator.isValidEmail(null));
    }
}
