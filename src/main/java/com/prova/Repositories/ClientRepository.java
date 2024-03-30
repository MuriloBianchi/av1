package com.prova.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID>{

}