package com.example.zadanie.service.impl;

import com.example.zadanie.entity.Client;
import com.example.zadanie.entity.Product;
import com.example.zadanie.repo.ClientRepo;
import com.example.zadanie.repo.ProductRepo;
import com.example.zadanie.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;

    @Override
    public Client insertClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client findClientById(Integer id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public Client updateClient(Client client) {
            if (client != null) {
                // Check if the client exists in the database
                Client existingClient = clientRepo.findById(client.getId()).orElse(null);
                if (existingClient != null) {
                    // Update the existing client with the new values
                    existingClient.setMobileNumber(client.getMobileNumber());
                    existingClient.setIsServiceUp(client.getIsServiceUp());
                    // Other attributes that need to be updated

                    // Save the updated client
                    return clientRepo.save(existingClient);
                } else {
                    return clientRepo.save(client);
                }
            }else{
                return null;
            }
        }
    }

