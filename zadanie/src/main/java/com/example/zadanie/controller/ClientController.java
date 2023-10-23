package com.example.zadanie.controller;


import com.example.zadanie.entity.Client;
import com.example.zadanie.entity.Product;
import com.example.zadanie.service.ClientService;
import com.example.zadanie.service.ProductService;
import com.example.zadanie.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private SmsService smsService;

    @GetMapping("/findAll")
    List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("/updateServiceStatus/{clientId}")
    public Client setServiceUp(@PathVariable Integer clientId, @RequestBody String status){
        Client client = clientService.findClientById(clientId);

        if (status.trim().equals("START")) {
            client.setIsServiceUp(true);
        } else if (status.trim().equals("STOP")) {
            client.setIsServiceUp(false);
        }

        return clientService.insertClient(client);
    }

    @PostMapping("/insert")
    public Client insertClient(@RequestBody Client client){
        return clientService.insertClient(client);
    }

    @GetMapping("/findAllWithSms")
    public List<Client> findAllClientsWithSms() {
        List<Client> clients = clientService.getAllClients(); // Assuming you have a service method to fetch all clients
        for (Client client : clients) {
            // Fetch associated SMS data for each client
            client.setReceivedSms(smsService.findReceivedSmsByClient(client));
            client.setSentSms(smsService.findSentSmsByClient(client));
        }
        return clients;
    }
}
