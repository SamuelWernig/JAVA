package at.htlle.subsystem;

public class FileLoader {
    public String load(String path) {
        System.out.println("Lade Datei: " + path);
        return "Inhalt von " + path;
    }
}
