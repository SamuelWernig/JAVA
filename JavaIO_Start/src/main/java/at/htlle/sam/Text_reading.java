package at.htlle.sam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Aufgabe 1
public class Text_reading {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Textdatei\\massage.txt"))){
        String line;
        int zeilenanzahl = 0;
        while ((line = reader.readLine()) != null){
            zeilenanzahl++;
            System.out.println(zeilenanzahl + ": " +line);
        }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
