package com.bank.client.application.impl;

import com.bank.client.application.ClientOperations;
import com.bank.client.application.model.ClientRepository;
import com.bank.client.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientOperationsImpl implements ClientOperations {

    private final ClientRepository repository;

    @Override
    public Flux<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Client> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Client> save(Client client) {
        return repository.save(client);
    }

    @Override
    public Mono<Client> update(String id, Client client) {
        return repository.update(id, client);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.delete(id);
    }
}
