package at.htlle;

import at.htlle.model.Document;
import at.htlle.state.*;


public class Main {
    public static void main(String[] args) {

        Document doc = new Document("Mein Dokument", new DraftState());

        doc.submit(doc);

        doc.approve(doc);

        doc.reject(doc);
    }
}
