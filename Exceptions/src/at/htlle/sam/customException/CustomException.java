package at.htlle.sam.customException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CustomException {
    public static void main(String[] args){
        try{
            readFile();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readFile() throws IOException{
        String fileName = "/Users/pankaj/source.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            //process the line
            System.out.println(line);
        }
    }
}
