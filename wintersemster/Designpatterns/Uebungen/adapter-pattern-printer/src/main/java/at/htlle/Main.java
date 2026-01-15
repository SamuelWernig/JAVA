package at.htlle;

import at.htlle.adapter.FileWriterAdapter;
import at.htlle.adapter.Printer;
import at.htlle.legacy.FileWriterLegacy;
// import at.htlle.adapter.FileWriterAdapter;
// import at.htlle.legacy.FileWriterLegacy;

public class Main {
    public static void main(String[] args) {
        // TODO: Erzeugen Sie eine Instanz von FileWriterLegacy
        // TODO: Erzeugen Sie eine Instanz von FileWriterAdapter
        // TODO: Verwenden Sie die Methode print()
        FileWriterLegacy fwl = new FileWriterLegacy();
        Printer printer = new FileWriterAdapter(fwl); // ersetzen
        printer.print("Hallo, Adapter!");
    }
}
