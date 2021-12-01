package com.bank.client.domain;

import lombok.Data;

@Data
public class Client {

    private String id;
    private String dni;
    private String name;
    private String lastName;
    private String ruc;
    private String businessName;
    private String type;

}
