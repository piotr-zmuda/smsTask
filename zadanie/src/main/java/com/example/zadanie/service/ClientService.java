package com.example.zadanie.service;

import com.example.zadanie.entity.Client;
import com.example.zadanie.entity.Product;

import java.util.List;

public interface ClientService {

    Client insertClient(Client client);

    List<Client> getAllClients();

    Client findClientById(Integer id);

    Client updateClient(Client client);

}
