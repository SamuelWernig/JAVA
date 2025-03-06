package at.htlle.sam.BetterBuecherei;

public class Reader {

    private String name;
    private Integer borrowedBooks;

    public Reader(String name, Integer borrowedBooks) {
        this.name = name;
        this.borrowedBooks = borrowedBooks;

    }


    public Integer getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Integer borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
