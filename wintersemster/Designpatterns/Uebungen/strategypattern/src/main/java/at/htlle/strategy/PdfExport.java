package at.htlle.strategy;

public class PdfExport implements ExportStrategy {
    @Override
    public void export(String drawingName) {
        // TODO: PDF-Ausgabe implementieren
        System.out.println("Zeichnung als PDF erstellt: " + drawingName + ".pdf");
    }
}
