package at.htlle.state;

import at.htlle.model.Document;

public class SubmittedState implements DocumentState {
    @Override
    public void submit(Document doc) {
        // TODO
        System.out.println("konnte nicht submitted werden");
    }

    @Override
    public void approve(Document doc) {
        // TODO
        doc.setState(new ApprovedState());
        System.out.println("wurde approved");
    }

    @Override
    public void reject(Document doc) {
        // TODO
        doc.setState(new RejectedState());
        System.out.println("wurde rejected");
    }
}
