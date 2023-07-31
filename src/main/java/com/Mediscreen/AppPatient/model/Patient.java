package com.Mediscreen.AppPatient.model;

import lombok.Data;
import lombok.NonNull;



import javax.persistence.*;
import java.util.Date;

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
}
