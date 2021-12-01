package com.bank.client.infraestructure.repository;

import com.bank.client.application.model.ClientRepository;
import com.bank.client.domain.Client;
import com.bank.client.infraestructure.model.dao.ClientDao;
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
        client.setId(clientDao.getId());
        client.setDni(clientDao.getDni());
        client.setName(clientDao.getName());
        client.setLastName(clientDao.getLastName());
        client.setRuc(clientDao.getRuc());
        client.setBusinessName(clientDao.getBusinessName());
        client.setType(clientDao.getType());
        return client;
    }

    private ClientDao mapClientToClientDao(Client client){
        ClientDao clientDao = new ClientDao();
        clientDao.setId(client.getId());
        clientDao.setDni(client.getDni());
        clientDao.setName(client.getName());
        clientDao.setLastName(client.getLastName());
        clientDao.setRuc(client.getRuc());
        clientDao.setBusinessName(client.getBusinessName());
        clientDao.setType(client.getType());
        return clientDao;
    }

}
