package com.raulteles.projectBFF.application.service;

import com.raulteles.projectBFF.application.dto.CustomerDTO;
import com.raulteles.projectBFF.application.port.input.BffInputPort;
import com.raulteles.projectBFF.application.port.output.BffOutputPort;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BffService implements BffInputPort {

    private final BffOutputPort bffOutputPort;

    public BffService(BffOutputPort bffOutputPort) {
        this.bffOutputPort = bffOutputPort;
    }


    public Mono<CustomerDTO> getCustomerById(Long id) {
        return bffOutputPort.getCustomerById(id);
    }


    public Mono<CustomerDTO> getCustomerByName(String name) {
        return bffOutputPort.getCustomerByName(name);
    }
}
