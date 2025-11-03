package at.htlle.sam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.*;

public class DebuggerUebung {

    private final static Logger logger = LoggerFactory.getLogger( DebuggerUebung.class );

    public static void main(String[] args) {
        logger.trace("Feinste Debug-Infos");
        logger.debug("Debug-Informationen");
        logger.info("Start des Programms");
        logger.warn("Achtung, Datei nicht gefunden");
        logger.error("Fehler beim Lesen der Datei");

        String datei = "personen.csv";
        int zeilen = 42;

        logger.info("Die Datei {} wurde erfolgreich eingelesen. ({} Zeilen)", datei, zeilen);

        /*try {
            Files.readAllLines(Paths.get("nicht_da.csv"));
        } catch (IOException e) {
            logger.error("Fehler beim Lesen der Datei", e);
        }*/






    }
}
