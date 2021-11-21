package com.mycompany.desctopapp_publishing_6.author;

import com.mycompany.desctopapp_publishing_6.user.User;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    public Long countById(Integer id);
}
