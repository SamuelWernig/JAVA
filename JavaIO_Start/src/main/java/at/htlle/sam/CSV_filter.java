package at.htlle.sam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

//Aufagbe 3
public class CSV_filter {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("CSVdatei\\products.csv"));
             PrintWriter writer = new PrintWriter(new FileWriter("CSVdatei\\filtered.csv"))){

            String line;
            reader.readLine(); //skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                if (price > 10) {
                    System.out.println(name + ": " + price);
                    writer.println(name + ": " + price);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
