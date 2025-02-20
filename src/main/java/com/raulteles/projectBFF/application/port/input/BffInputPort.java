package com.raulteles.projectBFF.application.port.input;

import com.raulteles.projectBFF.application.dto.CustomerDTO;
import reactor.core.publisher.Mono;

public interface BffInputPort {

    Mono<CustomerDTO> getCustomerById(Long id);
    Mono<CustomerDTO> getCustomerByName(String name);
}
