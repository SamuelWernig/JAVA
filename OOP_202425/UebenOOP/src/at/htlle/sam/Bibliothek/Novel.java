package at.htlle.sam.Bibliothek;

public class Novel extends Item {
    private String genre;

    public Novel(String title, String author, int year, String genre) {
        super(title, author, year);
        this.genre = genre;
    }

    @Override
    public String getDescription() {

        String text ="Titel: " + this.getTitle()+"\nAuthor: " + this.getAuthor() + "\nYear: " + this.getYear()+ "\nGenre: " + this.getGenre();

        return text;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
