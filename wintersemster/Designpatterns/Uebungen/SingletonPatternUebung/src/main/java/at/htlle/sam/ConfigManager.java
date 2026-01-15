package at.htlle.sam;

public class ConfigManager {

    private static ConfigManager instance;


    private ConfigManager() {
    }

    public static ConfigManager getInstance() {
        if (instance == null)
            instance = new ConfigManager();
        return instance;
    }

    public void setValue(String key, String value) {
        System.out.println(key + " = " + value);
    }
}
