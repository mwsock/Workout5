package pl.coderslab.beans;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class Book {

    private long id;
    private String ibanNumber;
    private String title;
    private String author;
    private String publisher;
    private String category;

    public String getIbanNumber() {
        return ibanNumber;
    }

    public void setIbanNumber(String ibanNumber) {
        this.ibanNumber = ibanNumber;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book() {
    }

    public Book(long id, String ibanNumber, String title, String author, String publisher, String category) {
        this.id = id;
        this.ibanNumber = ibanNumber;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }
    public Book(String ibanNumber, String title, String author, String publisher, String category) {
        this.ibanNumber = ibanNumber;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ibanNumber='" + ibanNumber + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
