package at.htlle.adapter;

import at.htlle.legacy.FileWriterLegacy;

public class FileWriterAdapter implements Printer {
    // TODO: Referenz auf FileWriterLegacy
    // TODO: Konstruktor und Implementierung der Methode print(String message)
    private final FileWriterLegacy adaptee;

    public FileWriterAdapter(FileWriterLegacy adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void print(String message) {
        String path = "C:/Users/samue/Desktop/JAVA_PROJECTS/JAVA/wintersemster/Designpatterns/adapter-pattern-printer";
        adaptee.writeToFile(message, path);

    }
}
