package com.raulteles.projectBFF.controller;

import com.raulteles.projectBFF.application.dto.CustomerDTO;
import com.raulteles.projectBFF.application.service.BffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bff")
public class BffController {

    private final BffService bffService;
    public BffController(BffService bffService) {
        this.bffService = bffService;
    }

    @GetMapping("/cliente/{id}")
    public Mono<CustomerDTO> getCustomerById(@PathVariable Long id) {
         return bffService.getCustomerById(id);
    }

    @GetMapping("/cliente/name/{customerName}")
    public Mono<CustomerDTO> getCustomerByName(@PathVariable String customerName) {
        return bffService.getCustomerByName(customerName);
    }
}
