package com.leonardo.tdd.repository;

import com.leonardo.tdd.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {
   public Client findByEmailAddress(String emailAddress);
}
