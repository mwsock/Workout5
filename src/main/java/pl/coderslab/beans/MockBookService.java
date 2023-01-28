package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService {

    private List<Book> books = new ArrayList<>();

    private Book book;

    public Book getBook() {
        return book;
    }

    @Autowired
    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getAllBooks(){
        return this.books;
    }

    public Book getBookById(long id){
        Optional<Book> specificBook = this.books.stream()
                .filter(book1 -> book1.getId() == id)
                .findFirst();
        return specificBook.orElse(null);
    }

    public void addBook(Book book){
       Optional<Book> newBook = this.books.stream()
                .max(Comparator.comparing(Book::getId));
       book.setId(newBook.map(value -> value.getId() + 1L).orElse(1L));
       this.books.add(book);
    }

    public void editBook(Book book){
        this.books.removeIf(book1 -> book1.getId() == book.getId());
        this.books.add(book);
        this.books.sort(Comparator.comparing(Book::getId));
    }

    public void removeBook(long id){
        this.books.removeIf(book1 -> book1.getId() == id);
    }
}
