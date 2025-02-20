package com.raulteles.projectBFF.application.service;

import com.raulteles.projectBFF.application.dto.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BffService {

    private final WebClient webClient;

    public BffService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<CustomerDTO> getCustomerById(Long id) {
        return webClient.get()
                .uri("/cliente/{id}", id)
                .retrieve()
                .bodyToMono(CustomerDTO.class);
    }

    public Mono<CustomerDTO> getCustomerByName(String name) {
        return webClient.get()
                .uri("/cliente/name/{customerName}", name)
                .retrieve()
                .bodyToMono(CustomerDTO.class);
    }
}
