package org.example.interface_markers;

import java.util.List;

public class Book {
    private String name;
    private String author;
    private List<Integer> prices;


    public Book(String name, String author, List<Integer> prices ) {
        this.name = name;
        this.author = author;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public List<Integer> getPrices() { return prices; }

    public void setPrices(List<Integer> prices) { this.prices = prices; }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", prices=" + prices +
                '}';
    }
}
