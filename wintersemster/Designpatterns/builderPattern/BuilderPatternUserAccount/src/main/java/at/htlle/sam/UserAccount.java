package at.htlle.sam;

public class UserAccount {
    private String benutzername;
    private String benutzerEmail;
    private String benutzerPasswort;
    private String telefonnummer;
    private String firstname;
    private String lastname;
    private String role;
    private boolean active;

    private UserAccount(Builder builder) {
        this.benutzername = builder.benutzername;
        this.benutzerEmail = builder.benutzerEmail;
        this.benutzerPasswort = builder.benutzerPasswort;
        this.telefonnummer = builder.telefonnummer;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.role = builder.role;
        this.active = builder.active;
    }
    @Override
    public String toString() {
        return benutzername + ',' + firstname + ',' + lastname + ',' + role;
    }


    public static class Builder {
        private String benutzername;
        private String benutzerEmail;
        private String benutzerPasswort;
        private String telefonnummer;
        private String firstname;
        private String lastname;
        private String role;
        private boolean active;

        public Builder(String benutzername, String benutzerEmail, String benutzerPasswort) {
            this.benutzername = benutzername;
            this.benutzerEmail = benutzerEmail;
            this.benutzerPasswort = benutzerPasswort;
        }

        public Builder neueTelefonnummer(String telefonnummer) {
            this.telefonnummer = telefonnummer;
            return this;
        }
        public Builder neueFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }
        public Builder neueLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }
        public Builder neueRole(String role) {
            this.role = role;
            return this;
        }
        public Builder neueActive(boolean active) {
            this.active = active;
            return this;
        }
        public UserAccount build() {
            return new UserAccount(this);
        }

    }


}
