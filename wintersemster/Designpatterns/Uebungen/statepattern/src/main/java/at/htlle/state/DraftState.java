package at.htlle.state;

import at.htlle.model.Document;

public class DraftState implements DocumentState {
    @Override
    public void submit(Document doc) {
        doc.setState(new SubmittedState());
        System.out.println("Wurde submitted");
    }

    @Override
    public void approve(Document doc) {
        // TODO
        System.out.println("Konnte nicht genehmigt werden");
    }

    @Override
    public void reject(Document doc) {
        // TODO
        System.out.println("Konnte nicht rejected werden");
    }
}
