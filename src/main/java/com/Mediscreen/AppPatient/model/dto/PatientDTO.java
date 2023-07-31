package com.Mediscreen.AppPatient.model.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class PatientDTO {

    private int id;


    @NotBlank(message = "First Name is mandatory")
    private String firstName;


    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = "Birth date is mandatory")
    private Date birthDate;


    @NotBlank(message = "The Patient's gender is mandatory")
    private String gender;


    @NotBlank(message = "The Patient's address is mandatory")
    private String address;


    @NotBlank(message = "The Patient's phone number is mandatory")
    private String phoneNumber;

}
