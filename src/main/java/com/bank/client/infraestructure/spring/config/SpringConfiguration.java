package com.bank.client.infraestructure.spring.config;

import com.bank.client.application.model.ClientRepository;
import com.bank.client.infraestructure.repository.ClientCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public ClientRepository repository(){
        return new ClientCrudRepository();
    }

}
