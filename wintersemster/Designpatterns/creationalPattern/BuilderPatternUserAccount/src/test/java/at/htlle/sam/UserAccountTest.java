package at.htlle.sam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest {

    @Test
    void builderErzeugtVollenUserAccount() {
        UserAccount user1 = new UserAccount.Builder("starmen", "samuelwernig@gmail.com", "Passwort123" )
                .neueTelefonnummer("0660 8742312")
                .neueFirstname("Samuel")
                .neueLastname("Wernig")
                .neueRole("Admin")
                .neueActive(true)
                .build();

        assertEquals("starmen,Samuel,Wernig,Admin ", user1.toString());
    }

    @Test
    void builderSetztNurPflichtfelder() {
        UserAccount account = new UserAccount.Builder(
                "starmen",
                "samuelwernig@gmail.com",
                "Passwort123"
        ).build();

        assertEquals("starmen,null,null,null", account.toString());
    }
}
