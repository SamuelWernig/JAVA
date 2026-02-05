package at.htlle.state;

import at.htlle.model.Document;

public class RejectedState implements DocumentState {
    @Override
    public void submit(Document doc) {
        // TODO
        doc.setState(new SubmittedState());
        System.out.println("Wurde submitted");
    }

    @Override
    public void approve(Document doc) {
        // TODO
        System.out.println("konnte nicht approved werden");
    }

    @Override
    public void reject(Document doc) {
        // TODO
        System.out.println("konnte nicht rejected werden");
    }
}
