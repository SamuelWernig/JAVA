package at.htlle.sam.Buecherei_OOP;

public class Book {
    private String book;
    private boolean isAvailable; {}

    public Book(String book, boolean isAvailable) {
        this.book = book;
        this.isAvailable = isAvailable;
    }


    public String getBook() {
        return book;
    }
    public void setBook(String book) {
        this.book = book;
    }

    public boolean getAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
