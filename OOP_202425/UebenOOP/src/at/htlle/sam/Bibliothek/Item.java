package at.htlle.sam.Bibliothek;

import java.io.Serializable;
import java.util.Objects;

public abstract class Item implements Comparable<Item> {
    private String title;
    private String author;
    private int year;

    public Item(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public abstract String getDescription();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return this.getTitle() == item.getTitle() && this.getAuthor() == item.getAuthor() && this.getYear() == item.getYear();

    }
    @Override
    public int hashCode() {
        return Objects.hash(title,author,year);
    }
    @Override
    public int compareTo(Item o) {
        return this.title.compareTo(o.getTitle());
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
