package com.prova.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, UUID>{

}
