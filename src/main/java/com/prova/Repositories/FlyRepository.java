package com.prova.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Fly;

@Repository
public interface FlyRepository extends JpaRepository<Fly, UUID>{

}
