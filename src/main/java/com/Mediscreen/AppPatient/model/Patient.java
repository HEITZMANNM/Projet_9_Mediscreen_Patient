package com.Mediscreen.AppPatient.model;

import lombok.Data;
import lombok.NonNull;



import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "birth_date")
    @NonNull
    private Date birthDate;

    @Column(name = "gender")
    @NonNull
    private String gender;

    @Column(name = "address")
    @NonNull
    private String address;

    @Column(name = "phone_number")
    @NonNull
    private String phoneNumber;


    public Patient() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient that = (Patient) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)
                && Objects.equals(birthDate, that.birthDate) && Objects.equals(gender, that.gender) && Objects.equals(address, that.address)
                && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, gender, address, phoneNumber);
    }
}
