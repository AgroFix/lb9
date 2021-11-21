package com.mycompany.desctopapp_publishing_6.book;

import com.mycompany.desctopapp_publishing_6.book.Book;
import com.mycompany.desctopapp_publishing_6.book.BookNotFoundExceptionn;
import com.mycompany.desctopapp_publishing_6.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired private BookRepository repo;

    public List<Book> listAll(){
        return (List<Book>) repo.findAll();

    }

    public void save(Book book) {

        repo.save(book);
    }
    public Book get(Integer id) throws BookNotFoundExceptionn {
        Optional<Book> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
    throw new BookNotFoundExceptionn("Could not find any books with ID " + id);

    }
    public void delete(Integer id) throws BookNotFoundExceptionn {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new BookNotFoundExceptionn("Could not find any books with ID " + id);
        }
        repo.deleteById(id);
    }
}
