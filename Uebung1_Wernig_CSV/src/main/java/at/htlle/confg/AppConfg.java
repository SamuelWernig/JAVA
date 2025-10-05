package at.htlle.confg;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public record AppConfg(Path dataDir) {
    public static AppConfg load() {
        Properties props = new Properties();
        try (InputStream in = AppConfg.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (in != null) props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read application.properties", e);
        }
        String dir = System.getProperty("data.dir",
                props.getProperty("data.dir", "./data"));
        return new AppConfg(Path.of(dir));
    }
}