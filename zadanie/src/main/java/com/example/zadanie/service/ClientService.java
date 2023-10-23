package com.example.zadanie.service;

import com.example.zadanie.entity.Client;

import java.util.List;

public interface ClientService {

    Client insertClient(Client client);

    List<Client> getAllClients();

    Client findClientById(Integer id);

    Client updateClient(Client client);

}
