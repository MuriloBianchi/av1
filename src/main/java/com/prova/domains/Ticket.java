package com.prova.domains;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.prova.domains.enums.TicketType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String ticketNumber;

    private Set<Integer> ticketType = new HashSet<>();
    private Float price;

    @ManyToOne
    @JoinColumn(name = "idfly")
    private Fly fly;

    public Ticket(){
        
    }

    public Ticket(UUID id, String ticketNumber, Set<Integer> ticketType, Float price, Fly fly) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.ticketType = ticketType;
        this.price = price;
        this.fly = fly;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Set<TicketType> getTicketType() {
        return ticketType.stream().map(x -> TicketType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addTicketType(TicketType ticketType) {
        this.ticketType.add(ticketType.getId());
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Fly getFly() {
        return fly;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ticketNumber == null) ? 0 : ticketNumber.hashCode());
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
        Ticket other = (Ticket) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ticketNumber == null) {
            if (other.ticketNumber != null)
                return false;
        } else if (!ticketNumber.equals(other.ticketNumber))
            return false;
        return true;
    }

    

    
}
