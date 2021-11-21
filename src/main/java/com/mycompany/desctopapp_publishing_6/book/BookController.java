package com.mycompany.desctopapp_publishing_6.book;

import com.mycompany.desctopapp_publishing_6.book.Book;
import com.mycompany.desctopapp_publishing_6.book.BookNotFoundExceptionn;
import com.mycompany.desctopapp_publishing_6.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired private BookService service;

    @GetMapping("/books")
    public String showBookList(Model model) {
     List<Book> listBooks = service.listAll();
     model.addAttribute("listBooks",listBooks);
     return "books";
    }
    @GetMapping("/books/new")
    public String showNewForm(Model model){
    model.addAttribute("book",new Book());
    model.addAttribute("pageTitle","Add new Book");
    return "book_form";
    }

    @PostMapping("/books/save")
    public String saveBook(Book book) {
        service.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){

        try {
            Book book = service.get(id);
           model.addAttribute("book",book);
           model.addAttribute("pageTitle","Edit Book (ID:"+ id+")");
           return "book_form";
        } catch (BookNotFoundExceptionn e) {
            return "redirect:/books";
        }

    }
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id ){

        try {
            service.delete(id);
        } catch (BookNotFoundExceptionn e) {

        }
        return "redirect:/books";
    }
}
