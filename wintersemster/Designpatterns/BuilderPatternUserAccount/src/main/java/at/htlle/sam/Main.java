package at.htlle.sam;

public class Main {
    public static void main(String[] args) {
        UserAccount user1 = new UserAccount.Builder("starman", "samuelwernig@gmail.com", "Passwort123" )
                .neueTelefonnummer("0660 8742312")
                .neueFirstname("Samuel")
                .neueLastname("Wernig")
                .neueRole("Admin")
                .neueActive(true)
                .build();

        System.out.println(user1);

    }
}
