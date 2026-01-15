package at.htlle.facade;

import at.htlle.subsystem.FileLoader;
import at.htlle.subsystem.Formatter;
import at.htlle.subsystem.PrinterEngine;

public class PrinterFacade {
    private final FileLoader fileLoader = new FileLoader();
    private final Formatter formatter = new Formatter();
    private final PrinterEngine printerEngine = new PrinterEngine();

    public void printDocument(String path) {
        // TODO: Datei laden, formatieren, Drucker initialisieren und drucken
        fileLoader.load(path);
        formatter.format(path);
        printerEngine.initialize();
        printerEngine.print(path);

    }
}
