package at.htlle.state;

import at.htlle.model.Document;

public class RejectedState implements DocumentState {
    @Override
    public void submit(Document doc) {
        // TODO
        doc.setState(new SubmittedState());
    }

    @Override
    public void approve(Document doc) {
        // TODO
        System.out.println("Rejected: Genehmigen nicht erlaubt.");

    }

    @Override
    public void reject(Document doc) {
        // TODO
        System.out.println("Rejected: Dokument ist bereits abgelehnt.");
    }
}
