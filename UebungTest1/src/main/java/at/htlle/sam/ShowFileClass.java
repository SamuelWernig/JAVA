package at.htlle.sam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.*;

public class ShowFileClass {

    private static final Logger LOG = LoggerFactory.getLogger( ShowFileClass.class );

    //Throws IOException ausnahmsweise um den Code übersichtlicher zu halten
    public static void main(String[] args) throws IOException {
        LOG.info("Application starting...");

        //zentraler Datentyp für den Pfad zu einer Datei oder einem Verzeichnis
        //Path speichert Struktur des Pfads -> siehe ShowPathClass.java
        //Files erledigt die Dateioperationen

        LOG.debug("------------------ Files Class ------------------");

        Path base = Path.of("data", "reports", "2025");
        Path file = base.resolve("summary.txt");

        LOG.debug("Setup");
        LOG.debug("base = {}", base.toAbsolutePath().normalize());
        LOG.debug("file = {}", file.toAbsolutePath().normalize());

        LOG.debug("------------------------------------------------");
        LOG.debug("Existence / Type checks");
        LOG.debug("exists(file)      = {}", Files.exists(file));
        LOG.debug("isRegularFile     = {}", Files.isRegularFile(file));
        LOG.debug("isDirectory(base) = {}", Files.isDirectory(base));

        LOG.debug("------------------------------------------------");
        LOG.debug("Create directories and WRITE (create/truncate)");
        Files.createDirectories(base);
        Files.writeString(
                file,
                "id;lastName;firstName\n1;Smith;Anna\n",
                CREATE, TRUNCATE_EXISTING //Standardwerte!!! müssen nicht angegeben werden!
                // CREATE -> erzeugt Datei, wenn sie nicht existiert
                // CREATE_NEW -> erzeugt Datei, wenn sie nicht existiert,
                //               FileAlreadyExistsException wenn sie existiert
                // TRUNCATE_EXISTING -> leert Datei, wenn sie existiert
                // APPEND -> Inhalte an Datei anhängen (nicht leeren)
        );
        LOG.debug("size(file) after write = {} bytes", Files.size(file));

        LOG.debug("------------------------------------------------");
        LOG.debug("READ (whole file)");
        String content = Files.readString(file);
        LOG.debug("content:\n{}", content);

        LOG.debug("------------------------------------------------");
        LOG.debug("APPEND lines");
        Files.write(
                file,
                List.of("2;Muster;Max"),
                APPEND
        );
        List<String> allLines = Files.readAllLines(file);
        LOG.debug("lineCount after append = {}", allLines.size());

        LOG.debug("------------------------------------------------");
        LOG.debug("Stream lines");
        try (Stream<String> lines = Files.lines(file)) {
            lines.forEach(l -> LOG.debug("line: {}", l));
        }

        LOG.debug("------------------------------------------------");
        LOG.debug("COPY and MOVE");
        Path copy = base.resolve("summary_copy.txt");
        Files.copy(file, copy, StandardCopyOption.REPLACE_EXISTING); //überschreibt Zieldatei
        // ohne StandardCopyOption Exception wenn das Ziel existiert
        LOG.debug("copied -> {}", copy.getFileName());

        Path archiveDir = base.resolve("archive");
        Files.createDirectories(archiveDir);
        Path moved = archiveDir.resolve("summary_moved.txt");
        Files.move(copy, moved, StandardCopyOption.REPLACE_EXISTING);
        LOG.debug("moved   -> {}", moved.getFileName());

        LOG.debug("------------------------------------------------");
        LOG.debug("Directory listing (Files.list)");
        try (Stream<Path> children = Files.list(base)) {
            children.forEach(child -> LOG.debug("child: {}", child.getFileName()));
        }

        LOG.debug("------------------------------------------------");
        LOG.debug("Attributes");
        LOG.debug("size(file)        = {}", Files.size(file));
        LOG.debug("lastModified(file)= {}", Files.getLastModifiedTime(file));
        LOG.debug("readable/writable/executable = {}/{}/{}",
                Files.isReadable(file), Files.isWritable(file), Files.isExecutable(file));
        LOG.debug("contentType(file) = {}", Files.probeContentType(file));

        LOG.debug("------------------------------------------------");
        LOG.debug("Temp files/directories");
        Path tmpDir = Files.createTempDirectory("files-demo-");
        Path tmp = Files.createTempFile(tmpDir, "demo-", ".txt");
        Files.writeString(tmp, "temporary\n", StandardCharsets.UTF_8, CREATE, TRUNCATE_EXISTING);
        LOG.debug("tmpDir = {}", tmpDir);
        LOG.debug("tmp    = {}", tmp);

        LOG.debug("------------------------------------------------");
        LOG.debug("Delete (optional cleanup)");
        Files.deleteIfExists(moved);
        Files.deleteIfExists(file);

        // Optional: delete base recursively
        // try (Stream<Path> walk = Files.walk(base)) {
        //     walk.sorted(Comparator.reverseOrder()).forEach(p -> {
        //         try { Files.deleteIfExists(p); } catch (IOException e) {
        //             LOG.warn("delete fail: {}", p, e);
        //         }
        //     });
        // }

        Files.deleteIfExists(tmp);
        Files.deleteIfExists(tmpDir);

        LOG.debug("---------------- End Files Class Demo -----------");

    }
}