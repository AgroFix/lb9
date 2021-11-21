package com.mycompany.desctopapp_publishing_6.book;

import com.mycompany.desctopapp_publishing_6.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Long countById(Integer id);
}
