package at.htlle;

import at.htlle.model.Document;
import at.htlle.state.DraftState;

public class Main {
    public static void main(String[] args) {
        String content = "alkhsdfklhasödlfkjhakjldfhalk";
        Document doc = new Document(content, new DraftState());
        doc.submit(doc);
        System.out.println();
        doc.approve(doc);
        System.out.println();
        doc.reject(doc);

    }
}
