package com.raulteles.projectBFF.adapter.output;

import com.raulteles.projectBFF.application.dto.CustomerDTO;
import com.raulteles.projectBFF.application.port.output.BffOutputPort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CustomerApiClient implements BffOutputPort {

    private final WebClient webClient;

    public CustomerApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<CustomerDTO> getCustomerById(Long id) {
        return webClient.get()
                .uri("/cliente/{id}", id)
                .retrieve()
                .bodyToMono(CustomerDTO.class);
    }

    @Override
    public Mono<CustomerDTO> getCustomerByName(String name) {
        return webClient.get()
                .uri("/cliente/name/{customerName}", name)
                .retrieve()
                .bodyToMono(CustomerDTO.class);
    }

}
