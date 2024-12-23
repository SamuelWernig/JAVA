package at.htlle.sam.Bibliothek;

public class NonFiction extends Item {
    private String topic;

    public NonFiction(String title, String author, int year, String topic) {
        super(title, author, year);

    }

    @Override
    public String getDescription() {
        String text ="Titel: " + this.getTitle()+"\nAuthor: " + this.getAuthor() + "\nYear: " + this.getYear() + "\nTopic: " + this.getTopic();

        return text;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
