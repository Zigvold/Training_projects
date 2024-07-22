package com.application.manager.controllers;

import com.application.manager.models.Product;
import com.application.manager.services.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final MessageSource messageSource;

    @ModelAttribute("product")
    public Product product(@PathVariable("id") int id){
        return productService.findById(id).orElseThrow(() ->
                new NoSuchElementException("catalogue.errors.product.not_found"));
    }

    @GetMapping("{id}")
    public String show(){
        return "products/show";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@ModelAttribute("product") Product product){
        productService.delete(product.getId());
        return "redirect:/products/index";
    }

    @GetMapping("{id}/edit")
    public String edit(){
        return "products/edit";
    }

    @PatchMapping("/{id}")
    public String patch(@PathVariable("id") int id, @ModelAttribute("product") Product updatedProduct){
        productService.update(updatedProduct);
        return "redirect:" + id;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(NoSuchElementException exception, Model model,
                                               HttpServletResponse response, Locale locale){
        response.setStatus(HttpStatus.NOT_FOUND.value());
        model.addAttribute("error", messageSource.getMessage(exception.getMessage(), new Object[0],
                exception.getMessage(), locale));
        return "errors/404";
    }
}
