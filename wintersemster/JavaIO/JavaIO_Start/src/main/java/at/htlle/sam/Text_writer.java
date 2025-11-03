package at.htlle.sam;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Text_writer {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            writer.println("Hello");
            writer.println("World");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
