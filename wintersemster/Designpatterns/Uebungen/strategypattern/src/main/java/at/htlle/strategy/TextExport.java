package at.htlle.strategy;

public class TextExport implements ExportStrategy {
    @Override
    public void export(String drawingName) {
        // TODO: Textausgabe implementieren
        System.out.println("Zeichnung als Text exportiert: "  + drawingName + ".txt");
    }
}
