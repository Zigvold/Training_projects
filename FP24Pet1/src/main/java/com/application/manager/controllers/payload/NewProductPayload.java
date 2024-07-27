package com.application.manager.controllers.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewProductPayload(
    @NotNull
    @Size(min = 3, max = 50, message = "{catalogue.products.create.errors.title_size_is_invalid}")
    String title,
    @Size(max = 10, message = "{catalogue.products.create.errors.details_size_is_invalid}")
    String details){
}
