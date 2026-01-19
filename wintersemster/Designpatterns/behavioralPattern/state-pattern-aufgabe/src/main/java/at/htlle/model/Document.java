package at.htlle.model;

import at.htlle.state.DocumentState;

public class Document implements DocumentState{
    String content;
    DocumentState state;

    public Document(String content, DocumentState state) {
        this.content = content;
        this.state = state;
    }


    @Override
    public void submit(Document doc) {
        state.submit(doc);
    }

    @Override
    public void approve(Document doc) {
        state.approve(doc);
    }

    @Override
    public void reject(Document doc) {
        state.reject(doc);
    }

    public void setState(DocumentState state) {
        this.state = state;
    }
}
