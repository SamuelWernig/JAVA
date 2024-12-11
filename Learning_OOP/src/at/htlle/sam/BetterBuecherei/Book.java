package at.htlle.sam.BetterBuecherei;

public class Book {
    private String title;
    private String author;
    private String borrowed;

    public Book(String title, String author,String borrowed) {
        this.title = title;
        this.author = author;
        this.borrowed = borrowed;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;

    }
}
