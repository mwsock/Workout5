package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.beans.Book;
import pl.coderslab.beans.MockBookService;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private MockBookService mockBookService;

    public MockBookService getMockBookService() {
        return mockBookService;
    }

    @Autowired
    public void setMockBookService(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }


    @GetMapping
    public List<Book> getAllBooks() {
        return mockBookService.getAllBooks();
    }

    @GetMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return mockBookService.getBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
//        Book newBook = new Book(
//                input.get("isbn"),
//                input.get("title"),
//                input.get("author"),
//                input.get("publisher"),
//                input.get("type")
//        );
        mockBookService.addBook(book);
    }

    @PutMapping
    //public void editBook(@RequestBody Map<String, String> input) {
    public void editBook(@RequestBody Book book) {
//        Book editedBook = new Book(
//                Long.parseLong(input.get("id")),
//                input.get("isbn"),
//                input.get("title"),
//                input.get("author"),
//                input.get("publisher"),
//                input.get("type")
//        );
        mockBookService.editBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        mockBookService.removeBook(id);
    }
}
