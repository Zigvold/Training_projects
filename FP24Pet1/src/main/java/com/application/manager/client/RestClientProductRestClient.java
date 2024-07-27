package com.application.manager.client;

import com.application.manager.controllers.payload.NewProductPayload;
import com.application.manager.controllers.payload.UpdateProductPayload;
import com.application.manager.models.Product;
import com.application.manager.util.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
public class RestClientProductRestClient implements ProductRestClient{

    private final RestClient restClient;

    private static final ParameterizedTypeReference<List<Product>> PRODUCT_TYPE_REFERENCE =
            new ParameterizedTypeReference<List<Product>>() {};
    @Override
    public List<Product> findAll() {
        return this.restClient
                .get()
                .uri("/catalogue-api/products")
                .retrieve()
                .body(PRODUCT_TYPE_REFERENCE);
    }

    @Override
    public Product createProduct(String title, String details) {
        try {
            return this.restClient
                    .post()
                    .uri("/catalogue-api/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new NewProductPayload(title, details))
                    .retrieve()
                    .body(Product.class);
        } catch (HttpClientErrorException.BadRequest exception){
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>)problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public Optional<Product> findProduct(int productId) {
        try {
            return Optional.ofNullable(this.restClient
                    .get()
                    .uri("/catalogue-api/products/{productId}", productId)
                    .retrieve()
                    .body(Product.class));
        } catch (HttpClientErrorException.BadRequest exception){
            return Optional.empty();
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try {
            this.restClient
                    .delete()
                    .uri("/catalogue-api/products/{productId}", productId)
                    .retrieve()
                    .toBodilessEntity();
        } catch (HttpClientErrorException.NotFound exception) {
            throw new NoSuchElementException(exception);
        }
    }

    @Override
    public void updateProduct(int productId, String title, String details) {
        try {
            this.restClient
                    .patch()
                    .uri("/catalogue-api/products/{productId}", productId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new UpdateProductPayload(title, details))
                    .retrieve()
                    .toBodilessEntity();
        } catch (HttpClientErrorException.BadRequest exception){
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>)problemDetail.getProperties().get("errors"));
        }

    }
}
