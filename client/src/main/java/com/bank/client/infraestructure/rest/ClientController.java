package com.bank.client.infraestructure.rest;

import com.bank.client.application.ClientOperations;
import com.bank.client.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientOperations clientOperations;

    @GetMapping
    public Flux<Client> get(){
        return clientOperations.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Client> getId(@PathVariable String id){
        return clientOperations.findById(id);
    }

    @PostMapping("/add")
    public Mono<Client> post(@RequestBody Client client){
        return clientOperations.save(client);
    }

    @PutMapping("/{id}")
    public Mono<Client> put(@PathVariable String id, @RequestBody Client client){
        return clientOperations.update(id, client);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return clientOperations.delete(id);
    }

}
