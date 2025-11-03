package at.htlle.sam;

import java.io.*;

public class Aufgabe2 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            // Writer für copy.txt
            writer = new PrintWriter(new FileWriter("copy.txt"));
            // Reader für message.txt
            reader = new BufferedReader(new FileReader("message.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String upperLine = line.toUpperCase(); // in Großbuchstaben umwandeln
                writer.println(upperLine);             // in copy.txt schreiben
                System.out.println(upperLine);         // zusätzlich auf Konsole ausgeben
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
