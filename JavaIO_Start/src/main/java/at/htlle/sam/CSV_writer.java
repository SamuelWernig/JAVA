package at.htlle.sam;

import java.io.FileWriter;
import java.io.PrintWriter;

public class CSV_writer {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("expensiv_products.csv"))){
            writer.println("id, name, price");
            writer.println("1, Steak, 15.00");
            writer.println("2, Lachs, 17.00");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
