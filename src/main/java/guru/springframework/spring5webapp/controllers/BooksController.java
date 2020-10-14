package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BooksController {

    private final BookRepository bookRepository;

    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(path = "/books")
    public ModelAndView getBooks() {
      /* model.addAttribute("books", bookRepository.findAll());
             return "books/list"*/
        ModelAndView model = new ModelAndView();
        model.addObject("books", bookRepository.findAll());
        model.setViewName("books/list");
        return  model;
    }
}
