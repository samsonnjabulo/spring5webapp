package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping(path = "/authors")
    public ModelAndView getAuthors(){
        ModelAndView model = new ModelAndView();
        model.addObject("authors",authorRepository.findAll());
        model.setViewName("authors/list");
        return model;
    }
}
