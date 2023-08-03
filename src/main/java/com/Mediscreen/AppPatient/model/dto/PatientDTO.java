package com.Mediscreen.AppPatient.model.dto;

import com.Mediscreen.AppPatient.model.Patient;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDTO that = (PatientDTO) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)
                && Objects.equals(birthDate, that.birthDate) && Objects.equals(gender, that.gender) && Objects.equals(address, that.address)
                && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, gender, address, phoneNumber);
    }

}
