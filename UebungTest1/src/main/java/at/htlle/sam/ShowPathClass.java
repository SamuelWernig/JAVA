package at.htlle.sam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class ShowPathClass {

    private static final Logger LOG = LoggerFactory.getLogger( ShowPathClass.class );

    public static void main( String[] args ) {
        LOG.info("Application starting...");

        //zentraler Datentyp für den Pfad zu einer Datei oder einem Verzeichnis
        //Path speichert Struktur des Pfads
        //Files erledigt die Dateioperationen -> siehe ShowFilesClass.java

        LOG.debug("------------------ Path Class ------------------");

        //Aufteilung in base und Dateien um flexibler zu sein und mehrere Dateien in
        //einem Verzeichnis anzusprechen:
        Path base = Path.of("data");
        Path students = base.resolve("Student.csv");

        Path p1 = Path.of("data", "Student.csv");  // relativ
        Path p2 = Path.of("C:\\data\\log.txt");           // absolut (Windows)
        Path p3 = Path.of("data/./sub/../Student.csv");   // enthält . und ..

        //Relative Pfade beziehen sich auf System.getProperty("user.dir")
        //Projekt-Seed Verzeichnis
        LOG.info("user.dir = "+System.getProperty("user.dir"));

        LOG.debug("------------------------------------------------");
        //Path Methoden:
        Path p = Path.of(".");
        LOG.debug("Path outputs with .");
        LOG.debug("fileName = {}", p.getFileName());
        LOG.debug("parent   = {}", p.getParent());
        LOG.debug("root     = {}", p.getRoot());

        LOG.debug("------------------------------------------------");
        p = Path.of(".").toAbsolutePath().normalize();
        LOG.debug("Path outputs with . and absolute path normalized");
        LOG.debug("fileName = {}", p.getFileName());
        LOG.debug("parent   = {}", p.getParent());       // jetzt nicht null
        LOG.debug("root     = {}", p.getRoot());         // "/" oder "C:\"

        LOG.debug("------------------------------------------------");
        p = Path.of("data", "reports", "2025", "summary.txt");
        LOG.debug("Path outputs with data/reports/2025/summary.txt");
        LOG.debug("fileName = {}", p.getFileName());
        LOG.debug("parent   = {}", p.getParent());       // jetzt nicht null
        LOG.debug("root     = {}", p.getRoot());         // "/" oder "C:\"

        LOG.debug("------------------------------------------------");
        p = Path.of("data", "reports", "2025", "summary.txt").toAbsolutePath().normalize();
        LOG.debug("Path outputs with data/reports/2025/summary.txt");
        LOG.debug("fileName = {}", p.getFileName());
        LOG.debug("parent   = {}", p.getParent());       // jetzt nicht null
        LOG.debug("root     = {}", p.getRoot());

        LOG.debug("------------------------------------------------");
        LOG.debug("------------------ Normalize -------------------");
        //why normalize()?
        //Path.of("data/reports/2025/summary.txt").toAbsolutePath();
        p = Path.of("data", "reports", "2024", "..", "2025", "summary.txt").toAbsolutePath();
        LOG.debug("Path outputs with data/reports/2024/../2025/summary.txt and absolute path");
        LOG.debug("fileName = {}", p.getFileName());
        LOG.debug("parent   = {}", p.getParent());
        LOG.debug("root     = {}", p.getRoot());

        LOG.debug("------------------------------------------------");
        p = Path.of("data", "reports", "2024", "..", "2025", "summary.txt").toAbsolutePath().normalize();
        LOG.debug("Path outputs with data/reports/2024/../2025/summary.txt and absolute path normalized");
        LOG.debug("fileName = {}", p.getFileName());
        LOG.debug("parent   = {}", p.getParent());
        LOG.debug("root     = {}", p.getRoot());
        LOG.debug("------------------------------------------------");

        LOG.info("Application finished.");

    }
}