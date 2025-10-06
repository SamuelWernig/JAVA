package at.htlle.sam;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Ueben2 {
    public static void main(String[] args){
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



    }
}
