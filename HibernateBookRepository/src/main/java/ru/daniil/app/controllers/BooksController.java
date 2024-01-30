package ru.daniil.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.daniil.app.models.Book;
import ru.daniil.app.models.Person;
import ru.daniil.app.services.BooksService;
import ru.daniil.app.services.PeopleService;
import ru.daniil.app.util.BookValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;
    private final PeopleService peopleService;
    private final BookValidator bookValidator;

    @Autowired
    public BooksController(BooksService booksService, PeopleService peopleService, BookValidator bookValidator) {
        this.booksService = booksService;
        this.peopleService = peopleService;
        this.bookValidator = bookValidator;
    }

    @GetMapping
    public String index(@RequestParam(required = false, value = "paging") boolean paging,
                        @RequestParam(required = false, value = "books_per_page") int booksPerPage,
                        @RequestParam(required = false, value = "sort_by_year") boolean sortByYear,
                        @RequestParam(required = false, value = "page", defaultValue = "0") int page,
                        Model model){
        model.addAttribute("books" ,booksService.findAll(paging, booksPerPage, page, sortByYear));
        model.addAttribute("paging", paging);
        model.addAttribute("books_per_page", booksPerPage);
        model.addAttribute("sort_by_year", sortByYear);
        model.addAttribute("page", page);
        return "/books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model){
        Book book = booksService.findOne(id);
        model.addAttribute("book", book);
        model.addAttribute("person", book.getOwner());
        model.addAttribute("hollowPerson", new Person());
        model.addAttribute("people", peopleService.findAll());
        return "/books/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id,
                       Model model){
        model.addAttribute("book", booksService.findOne(id));
        return "/books/edit";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "/books/new";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "/books/edit";
        booksService.update(id, book);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id,
                         @ModelAttribute("Hollow person") Person hollowPeron){
        peopleService.assignBook(hollowPeron.getId(), id);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/remove")
    public String remove(@PathVariable("id") int id){
        booksService.removeOwner(id);
        return "redirect:/books/" + id;
    }


    @PostMapping("/new")
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult){
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors())
            return "/books/new";
        booksService.save(book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        booksService.delete(id);
        return "redirect:/books";
    }
}
