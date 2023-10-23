package com.example.zadanie.repo;

import com.example.zadanie.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Integer> {
}
