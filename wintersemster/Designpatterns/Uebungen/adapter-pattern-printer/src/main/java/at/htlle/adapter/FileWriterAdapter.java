package at.htlle.adapter;

import at.htlle.legacy.FileWriterLegacy;

public class FileWriterAdapter implements Printer {
    private FileWriterLegacy adaptee;

    public FileWriterAdapter(FileWriterLegacy adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void print(String message) {
        String path = "c:\\Users\\samue\\Desktop\\";
        adaptee.writeToFile(message, path);
    }
    // TODO: Referenz auf FileWriterLegacy
    // TODO: Konstruktor und Implementierung der Methode print(String message)
}
