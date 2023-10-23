package com.example.zadanie.controller;


import com.example.zadanie.entity.Client;
import com.example.zadanie.entity.Sms;
import com.example.zadanie.repo.SmsRepo;
import com.example.zadanie.service.ClientService;
import com.example.zadanie.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/findAll")
    List<Sms> getAllSms(){
        return smsService.getAllSms();
    }

    @PostMapping("/insert")
    public Sms insertSms(@RequestBody Sms sms){
        System.out.println(sms.getSender());
        Client sender = clientService.findClientById(sms.getSender().getId());
        Client recipient = clientService.findClientById(sms.getRecipient().getId());

        if(recipient.getIsServiceUp()){
            if (isPhishingSms(sms.getMessage())) {
                return null; // odrzuć wiadomość SMS, jeśli jest to próba phishingu
            }else{
                sms.setCheckedForPhishing(true);
            }
        }else{
            sms.setCheckedForPhishing(false);
        }

        sender.insertNewSentSms(sms);
        recipient.insertNewReceivedSms(sms);

        clientService.insertClient(sender);
        clientService.insertClient(recipient);

        // Save the Sms entity
        return smsService.insertSms(sms);
    }


    private boolean isPhishingSms(String message) {
        // W tym miejscu przeprowadź analizę adresu URL w wiadomości SMS
        String pattern = "\\\\b((?:https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:, .;]*[-a-zA-Z0-9+&@#/%=~_|])";
        Pattern pat = Pattern.compile(pattern);
        Matcher m = pat.matcher(message);
        if (m.find()) {
            try {
                URL url = new URL("https://cloud.google.com/web-risk/docs/reference/rest/v1eap1/TopLevel/evaluateUri?url=" + message);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                // Przetwarzanie odpowiedzi z serwisu zabezpieczeń

                // Zwróć true, jeśli URL jest uznawany za podejrzany

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}


