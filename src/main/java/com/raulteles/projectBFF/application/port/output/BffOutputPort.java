package com.raulteles.projectBFF.application.port.output;

import com.raulteles.projectBFF.application.dto.CustomerDTO;
import reactor.core.publisher.Mono;

public interface BffOutputPort {

    Mono<CustomerDTO> getCustomerById(Long id);
    Mono<CustomerDTO> getCustomerByName(String name);
}
