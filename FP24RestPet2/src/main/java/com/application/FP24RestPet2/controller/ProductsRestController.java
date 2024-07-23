package com.application.FP24RestPet2.controller;

import com.application.FP24RestPet2.controller.payload.NewProductPayload;
import com.application.FP24RestPet2.entity.Product;
import com.application.FP24RestPet2.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue-api/products")
public class ProductsRestController {

    private final ProductService productService;

    @GetMapping()
    public List<Product> findProducts(){
        return this.productService.findAll();
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@Valid @RequestBody NewProductPayload newProductPayload,
                                                 BindingResult bindingResult,
                                                 UriComponentsBuilder uriComponentsBuilder)
            throws BindException{
        if (bindingResult.hasErrors()){
            if (bindingResult instanceof BindException exception) throw exception;
            else throw new BindException(bindingResult);
        }else {
            Product product = this.productService.save(productService.createProduct(newProductPayload));
            return ResponseEntity
                    .created(uriComponentsBuilder
                            .replacePath("/catalogue-api/products/{id}")
                            .build(Map.of(("id"), product.getId())))
                    .body(product);
        }
    }
}
