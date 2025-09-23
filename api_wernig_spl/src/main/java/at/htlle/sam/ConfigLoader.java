package at.htlle.sam;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;

    public ConfigLoader() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("test.properties")) {
            if (input == null) {
                throw new IOException("Property file not found");
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Fehler beim Laden der Konfigurationsdatei: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        ConfigLoader config = new ConfigLoader();

        // Beispiele für den Zugriff auf Eigenschaften
        System.out.println("Datenbank-URL: " + config.getProperty("database.url"));
        System.out.println("Benutzername: " + config.getProperty("database.user"));
        System.out.println("API-Key: " + config.getProperty("API_KEY"));
    }
}