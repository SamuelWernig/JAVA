package at.htlle.adapter;

import at.htlle.legacy.FileWriterLegacy;

public class FileWriterAdapter implements Printer {

    FileWriterLegacy fileWriter;
    String path;

    public FileWriterAdapter(FileWriterLegacy fileWriter, String path) {
        this.fileWriter = fileWriter;
        this.path = path;
    }

    @Override
    public void print(String message) {
        fileWriter.writeToFile(message, path);
    }
    // TODO: Referenz auf FileWriterLegacy
    // TODO: Konstruktor und Implementierung der Methode print(String message)
}
