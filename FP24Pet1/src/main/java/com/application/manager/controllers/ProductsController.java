package com.application.manager.controllers;

import com.application.manager.models.Product;
import com.application.manager.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/index")
    public String getProductList(Model model){
        model.addAttribute("products", productService.findAll());
        System.out.println(productService.findAll());
        return "products/index";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "products/new";
    }
    @PostMapping("/new")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("payload", product);
            model.addAttribute("errors", bindingResult.getAllErrors()
                    .stream().map(ObjectError::getDefaultMessage).toList());
            return "products/new";
        } else {
            productService.save(product);
            return "redirect:index";
        }
    }
}
