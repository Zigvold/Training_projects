package com.application.manager.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientProductRestClient restClientProductRestClient(@Value("${services.catalog.uri:http:localhost:8080}") String baseUri){
        return new RestClientProductRestClient(RestClient.builder()
                .baseUrl(baseUri)
                .build());
    }
}
