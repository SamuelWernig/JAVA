package at.htlle;

import at.htlle.facade.PrinterFacade;

public class Main {
    public static void main(String[] args) {
        PrinterFacade printer = new PrinterFacade();
        printer.printDocument("datei.txt");
    }
}
