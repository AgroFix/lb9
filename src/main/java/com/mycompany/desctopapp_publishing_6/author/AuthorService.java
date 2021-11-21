package com.mycompany.desctopapp_publishing_6.author;

import com.mycompany.desctopapp_publishing_6.author.Author;
import com.mycompany.desctopapp_publishing_6.author.AuthorNotFoundExceptionn;
import com.mycompany.desctopapp_publishing_6.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired private AuthorRepository repo;

    public List<Author> listAll(){
        return (List<Author>) repo.findAll();

    }

    public void save(Author author) {

        repo.save(author);
    }
    public Author get(Integer id) throws AuthorNotFoundExceptionn {
        Optional<Author> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
    throw new AuthorNotFoundExceptionn("Could not find any authors with ID " + id);

    }
    public void delete(Integer id) throws AuthorNotFoundExceptionn {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new AuthorNotFoundExceptionn("Could not find any authors with ID " + id);
        }
        repo.deleteById(id);
    }
}
