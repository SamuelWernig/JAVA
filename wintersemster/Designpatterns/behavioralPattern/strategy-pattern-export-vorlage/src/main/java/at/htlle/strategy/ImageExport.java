package at.htlle.strategy;

public class ImageExport implements ExportStrategy {
    @Override
    public void export(String drawingName) {
        // TODO: Bildausgabe implementieren
        System.out.println("Zeichnung als PNG gespeichert: "+drawingName+".png");

    }
}
