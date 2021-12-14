package com.bank.client.infraestructure.repository;

import com.bank.client.application.model.ClientRepository;
import com.bank.client.domain.Client;
import com.bank.client.infraestructure.model.dao.ClientDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ClientCrudRepository implements ClientRepository {

    @Autowired
    IClientCrudRepository repository;

    @Override
    public Flux<Client> findAll() {
        return repository.findAll()
                .map(this::mapClientDaoToClient);
    }

    @Override
    public Mono<Client> findById(String id) {
        return repository.findById(id)
                .map(this::mapClientDaoToClient);
    }

    @Override
    public Mono<Client> save(Client client) {
        return repository.save(mapClientToClientDao(client))
                .map(this::mapClientDaoToClient);
    }

    @Override
    public Mono<Client> update(String id, Client client) {
        return repository.save(mapClientToClientDao(client))
                .map(this::mapClientDaoToClient);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    private Client mapClientDaoToClient(ClientDao clientDao){
        Client client = new Client();
        BeanUtils.copyProperties(clientDao, client);
        return client;
    }

    private ClientDao mapClientToClientDao(Client client){
        ClientDao clientDao = new ClientDao();
        BeanUtils.copyProperties(client, clientDao);
        return clientDao;
    }

}
