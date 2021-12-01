package com.bank.client.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("client")
public class ClientDao {

    @Id
    private String id;
    private String dni;
    private String name;
    private String lastName;
    private String ruc;
    private String businessName;
    private String type;

}
