package com.raulteles.projectBFF.adapter.input;

import com.raulteles.projectBFF.application.dto.CustomerDTO;
import com.raulteles.projectBFF.application.port.input.BffInputPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bff")
public class BffController {

    private final BffInputPort bffInputPort;

    public BffController(BffInputPort bffInputPort) {
        this.bffInputPort = bffInputPort;
    }


    @GetMapping("/cliente/{id}")
    public Mono<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return bffInputPort.getCustomerById(id);
    }

    @GetMapping("/cliente/name/{customerName}")
    public Mono<CustomerDTO> getCustomerByName(@PathVariable String customerName) {
        return bffInputPort.getCustomerByName(customerName);
    }
}
