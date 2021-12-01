package com.bank.client.application.model;

import com.bank.client.domain.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientRepository {

    public Flux<Client> findAll();
    public Mono<Client> findById(String id);
    public Mono<Client> save(Client client);
    public Mono<Client> update(String id, Client client);
    public Mono<Void> delete(String id);

}
