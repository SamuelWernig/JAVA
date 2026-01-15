package at.htlle;

import at.htlle.model.*;
import at.htlle.strategy.*;

public class Main {
    public static void main(String[] args) {
        Drawing drawing = new Drawing("HousePlan");

        // TODO: Strategie setzen und exportieren
        drawing.setExportStrategy(new ImageExport());
        drawing.export();
        drawing.setExportStrategy(new TextExport());
        drawing.export();
    }
}
