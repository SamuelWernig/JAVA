package at.htlle.state;

import at.htlle.model.Document;

public class ApprovedState implements DocumentState {
    @Override
    public void submit(Document doc) {
        System.out.println("bereits genehmigt");
    }

    @Override
    public void approve(Document doc) {
        // TODO
        System.out.println("bereits genehmigt");
    }

    @Override
    public void reject(Document doc) {
        // TODO
        System.out.println("bereits genehmigt");
    }
}
