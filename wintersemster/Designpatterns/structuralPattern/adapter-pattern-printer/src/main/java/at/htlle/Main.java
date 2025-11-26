package at.htlle;

import at.htlle.adapter.FileWriterAdapter;
import at.htlle.adapter.Printer;
import at.htlle.legacy.FileWriterLegacy;
// import at.htlle.adapter.FileWriterAdapter;
// import at.htlle.legacy.FileWriterLegacy;

public class Main {
    public static void main(String[] args) {
        FileWriterLegacy fw = new FileWriterLegacy();
        FileWriterAdapter fwAdapter = new FileWriterAdapter(fw);

        // TODO: Erzeugen Sie eine Instanz von FileWriterLegacy
        // TODO: Erzeugen Sie eine Instanz von FileWriterAdapter
        // TODO: Verwenden Sie die Methode print()

        Printer printer = fwAdapter; // ersetzen
        printer.print("Hallo, Adapter!");
    }
}
