package at.htlle.sam.Buecherei_OOP;

public class Reader {
    private String name;
    private int booksOwned;

    public Reader(String name, int booksOwned) {
        this.name = name;
        this.booksOwned = booksOwned;
    }



    public String getNames(){
        return name;
    }

    public void setNames(String name){
        this.name = name;
    }

    public int getBooksOwned() {
        return booksOwned;
    }

    public void setBooksOwned(int booksOwned) {
        this.booksOwned = booksOwned;
    }
}
