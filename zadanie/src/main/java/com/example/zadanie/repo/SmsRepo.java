package com.example.zadanie.repo;

import com.example.zadanie.entity.Client;
import com.example.zadanie.entity.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SmsRepo extends JpaRepository<Sms, Integer> {
    @Query("SELECT s FROM Sms s WHERE s.recipient = :client")
    List<Sms> findReceivedSmsByRecipient(@Param("client") Client client);

    @Query("SELECT s FROM Sms s WHERE s.sender = :client")
    List<Sms> findReceivedSmsBySender(@Param("client") Client client);
}
