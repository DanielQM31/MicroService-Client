package com.bank.client.infraestructure.repository;

import com.bank.client.infraestructure.model.dao.ClientDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IClientCrudRepository extends ReactiveCrudRepository<ClientDao, String> {
}
