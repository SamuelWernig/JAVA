package at.htlle.sam;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;

public class Ueben2 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("daten.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter write = new BufferedWriter(new FileWriter("ausgabe.txt"))){
            write.write("Hallo");
            write.newLine();
            write.write("Das ist Zeile 2");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        try (BufferedReader br = new BufferedReader(new FileReader("personen.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                System.out.println("Person "+parts[0]+" heißt "+parts[1]+" und ist "+parts[2]+" Jahre alt.");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println();
        //Kurz
        List<String> personen = Files.lines(Paths.get("personen.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(parts -> "id: "+parts[0]+" Name: "+parts[1]+" Alter: "+parts[2])
                    .toList();
        System.out.println(personen);
        System.out.println();
        //Path
        Path path = Paths.get("personen.csv");
        System.out.println(path);
        System.out.println();
        //Absolute Path
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println();
        //Parent from path
        Path parent = absolutePath.getParent();
        System.out.println(parent);
        System.out.println();
        //Normalized Path
        Path pathWithDots = Paths.get("data/../backup/./test.txt");
        System.out.println(pathWithDots);
        Path normalizedPath = pathWithDots.normalize();
        System.out.println(normalizedPath);
        System.out.println();
        //resolve verwenden (hängt was an pfad)
        Path resolvedPath = parent.resolve("Test.txt");
        System.out.println(resolvedPath);
        System.out.println();
        //Stellen entfernen
        Path p = Paths.get("C:/Users/Sam/Documents/Java/data.txt");
        System.out.println(p.subpath(0, 3));
        System.out.println();


        //Oder besser mit try-with-resources
        try (Stream<String> lines = Files.lines(path)){
            List<String> personen2 = lines
                    .skip(1)
                    .map(n -> n.split(";"))
                    .map(parts -> "id: "+parts[0]+" Name: "+parts[1]+" Alter: "+parts[2])
                    .toList();
            System.out.println(personen2);
        }catch (IOException e){
            e.printStackTrace();
        }

        //Datei anfügen
        Files.write(Paths.get("daten.txt"),
                List.of("NEUE ZEILE"),
                APPEND,
                CREATE);
        //Datei neuschreiben
        Files.write(Paths.get("daten.txt"),
                List.of("Zeile 1", "Zeile 2"));
        System.out.println();
        System.out.println(Files.exists(Paths.get("daten.txt")));
        System.out.println();

        Path newPath = Paths.get("C:\\Users\\samue\\Desktop\\JAVA_PROJECTS\\JAVA\\UebungTest1\\daten.txt");
        System.out.println(newPath);
        Files.write(newPath, List.of("Zeile 1", "Zeile 2", "Zeile3"));
        try(Stream<String> lines = Files.lines(newPath)){
            List<String> dataStringList = lines
                    .skip(1)
                    .filter(line -> line.equals("Zeile 2"))
                    .toList();
            System.out.println(dataStringList);
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        // Lambda-Ausdruck für Addition
        Rechner add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.berechne(5, 3));
        // Lambda-Ausdruck für Dividieren
        Rechner div = (a, b) -> a / b;
        System.out.println("5 / 3 = " + div.berechne(5, 3));
        // Lambda-Ausdruck für Multiplikation
        Rechner mul = (a, b) -> a * b;
        System.out.println("5 * 3 = " + mul.berechne(5, 3));
        // Lambda-Ausdruck für Subtraktion
        Rechner sub = (a, b) -> a - b;
        System.out.println("5 - 3 = " + sub.berechne(5, 3));

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("ausgabe.txt"))){
            bw.write("Zeile 1");
            bw.newLine();
            bw.write("Zeile 2");
            bw.newLine();
            bw.write("Zeile 3");
            bw.newLine();
            bw.write("Zeile 4");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
