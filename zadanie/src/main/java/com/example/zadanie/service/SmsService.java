package com.example.zadanie.service;

import com.example.zadanie.entity.Client;
import com.example.zadanie.entity.Sms;

import java.util.List;

public interface SmsService {

    Sms insertSms(Sms sms);

    List<Sms> getAllSms();

    List<Sms> findReceivedSmsByClient(Client client);

    List<Sms> findSentSmsByClient(Client client);
}
