package at.htlle.model;

import at.htlle.state.*;

public class Document implements DocumentState{
    private String content;
    private DocumentState state;

    public Document(String content, DocumentState state) {
        this.content = content;
        this.state = new DraftState();
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

    public void setState(DocumentState state){
        this.state = state;
    }

}
