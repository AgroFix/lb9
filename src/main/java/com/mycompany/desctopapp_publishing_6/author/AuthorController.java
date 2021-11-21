package com.mycompany.desctopapp_publishing_6.author;

import com.mycompany.desctopapp_publishing_6.author.Author;
import com.mycompany.desctopapp_publishing_6.author.AuthorNotFoundExceptionn;
import com.mycompany.desctopapp_publishing_6.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired private AuthorService service;

    @GetMapping("/authors")
    public String showAuthorList(Model model) {
     List<Author> listAuthors = service.listAll();
     model.addAttribute("listAuthors",listAuthors);
     return "authors";
    }
    @GetMapping("/authors/new")
    public String showNewForm(Model model){
    model.addAttribute("author",new Author());
    model.addAttribute("pageTitle","Add new Author");
    return "author_form";
    }

    @PostMapping("/authors/save")
    public String saveAuthor(Author author) {
        service.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){

        try {
            Author author = service.get(id);
           model.addAttribute("author",author);
           model.addAttribute("pageTitle","Edit Author (ID:"+ id+")");
           return "author_form";
        } catch (AuthorNotFoundExceptionn e) {
            return "redirect:/authors";
        }

    }
    @GetMapping("/authors/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Integer id ){

        try {
            service.delete(id);
        } catch (AuthorNotFoundExceptionn e) {

        }
        return "redirect:/authors";
    }
}
