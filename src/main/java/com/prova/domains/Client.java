package com.prova.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.prova.domains.enums.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends User{

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();

    public Client(UUID id, String firstName, String lastName, String cpf, Set<UserType> userTypes) {
        super(id, firstName, lastName, cpf, userTypes);
        addUserTypes(UserType.ADMIN);
    }

    public Client(List<Booking> bookings) {
        super();
        addUserTypes(UserType.ADMIN);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

}