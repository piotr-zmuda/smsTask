package com.example.zadanie.service.impl;

import com.example.zadanie.entity.Client;
import com.example.zadanie.entity.Sms;
import com.example.zadanie.repo.SmsRepo;
import com.example.zadanie.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    SmsRepo smsRepo;
    @Override
    public Sms insertSms(Sms sms) {
        return smsRepo.save(sms);
    }

    @Override
    public List<Sms> getAllSms() {
        return smsRepo.findAll();
    }

    @Override
    public List<Sms> findReceivedSmsByClient(Client client) {
        return smsRepo.findReceivedSmsByRecipient(client);
    }

    @Override
    public List<Sms> findSentSmsByClient(Client client) {
        return smsRepo.findReceivedSmsBySender(client);
    }


}
