package com.application.manager.controllers;

import com.application.manager.client.RestClientProductRestClient;
import com.application.manager.controllers.payload.NewProductPayload;
import com.application.manager.models.Product;
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

    private final RestClientProductRestClient client;

    @GetMapping("/index")
    public String getProductList(Model model){
        model.addAttribute("products", client.findAll());
        System.out.println(client.findAll());
        return "products/index";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "products/new";
    }
    @PostMapping("/new")
    public String create(@Valid @ModelAttribute("product") NewProductPayload payload, BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("payload", payload);
            model.addAttribute("errors", bindingResult.getAllErrors()
                    .stream().map(ObjectError::getDefaultMessage).toList());
            return "products/new";
        } else {
            client.createProduct(payload.title(), payload.details());
            return "redirect:index";
        }
    }
}
