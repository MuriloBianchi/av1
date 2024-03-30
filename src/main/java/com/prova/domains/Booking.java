package com.prova.domains;

import java.sql.Date;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Set;

import com.prova.domains.enums.BookingState;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date bookingDate;

    private Set<Integer> bookingState = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

    public Booking() {
    }

    public Booking(UUID id, Date bookingDate, Set<Integer> bookingState, Client client) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.bookingState = bookingState;
        this.client = client;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Set<BookingState> getBookingState() {
        return bookingState.stream().map(x -> BookingState.toEnum(x)).collect(Collectors.toSet());
    }

    public void setBookingState(BookingState bookingState) {
        this.bookingState.add(bookingState.getId());
    }

    public User getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Booking other = (Booking) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}