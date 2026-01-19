package at.htlle.state;

import at.htlle.model.Document;

public class SubmittedState implements DocumentState {
    @Override
    public void submit(Document doc) {
        // TODO
    }

    @Override
    public void approve(Document doc) {
        // TODO
        doc.setState(new ApprovedState());
    }

    @Override
    public void reject(Document doc) {
        // TODO
        doc.setState(new RejectedState());
    }
}
