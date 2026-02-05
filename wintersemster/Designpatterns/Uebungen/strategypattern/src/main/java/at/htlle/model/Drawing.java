package at.htlle.model;

import at.htlle.strategy.ExportStrategy;

public class Drawing {
    private String name;
    private ExportStrategy strategy;

    public Drawing(String name) {
        this.name = name;
    }

    public void setExportStrategy(ExportStrategy strategy) {
        // TODO: Strategie setzen
        this.strategy = strategy;
    }

    public void export() {
        // TODO: export aufrufen
        strategy.export(name);
    }

    public String getName() {
        return name;
    }
}
