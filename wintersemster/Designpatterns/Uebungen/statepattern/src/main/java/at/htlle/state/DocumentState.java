package at.htlle.state;

import at.htlle.model.Document;

public interface DocumentState {
    void submit(Document doc);
    void approve(Document doc);
    void reject(Document doc);
}
