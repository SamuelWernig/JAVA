package at.htlle.state;

import at.htlle.model.Document;

public class DraftState implements DocumentState {
    @Override
    public void submit(Document doc) {
        // TODO
        doc.setState(new SubmittedState());
    }

    @Override
    public void approve(Document doc) {
        // TODO
        System.out.println("Draft: Genehmigen nicht erlaubt.");
    }

    @Override
    public void reject(Document doc) {
        // TODO
        System.out.println("Draft: Ablehnen nicht erlaubt.");
    }
}
