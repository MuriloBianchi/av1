package com.prova.domains;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fly")
public class Fly implements Serializable{

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String flyNumeber;

    private String destiny;
    private LocalDate departurDate;
    private LocalDate arrivalDate;

    @ManyToOne
    @JoinColumn(name = "idaircraft")
    private Aircraft aircraft;

    public Fly(){

    }

    public Fly(UUID id, String flyNumeber, String destiny, LocalDate departurDate, LocalDate arrivalDate, Aircraft aircraft) {
        this.id = id;
        this.flyNumeber = flyNumeber;
        this.destiny = destiny;
        this.departurDate = departurDate;
        this.arrivalDate = arrivalDate;
        this.aircraft = aircraft;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFlyNumeber() {
        return flyNumeber;
    }

    public void setFlyNumeber(String flyNumeber) {
        this.flyNumeber = flyNumeber;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public LocalDate getDeparturDate() {
        return departurDate;
    }

    public void setDeparturDate(LocalDate departurDate) {
        this.departurDate = departurDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((flyNumeber == null) ? 0 : flyNumeber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fly other = (Fly) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (flyNumeber == null) {
            if (other.flyNumeber != null)
                return false;
        } else if (!flyNumeber.equals(other.flyNumeber))
            return false;
        return true;
    }

    
}
