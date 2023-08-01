package com.Mediscreen.AppPatient.integration;

import com.Mediscreen.AppPatient.model.Patient;
import com.Mediscreen.AppPatient.model.dto.PatientDTO;
import com.Mediscreen.AppPatient.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class PatientServiceIT {

    @Autowired
    PatientService patientService;

    @Test
    public void testToSavedNewPatient(){

        PatientDTO patient = new PatientDTO();
        patient.setPhoneNumber("555555");
        patient.setBirthDate(new Date());
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");

        patientService.saveNewPatient(patient);

        PatientDTO patientDTOExpected = patientService.getPatientByFirstNameAndLastName("TestFirstName", "TestLastName");

        assertEquals(patient.getFirstName(), patientDTOExpected.getFirstName());
        assertEquals(patient.getAddress(), patientDTOExpected.getAddress());

        //for cleaning the database
        patientService.deletePatientByFirstNameAndLastName("TestFirstName", "TestLastName");

    }

    @Test
    public void testToDeletePatient(){

        PatientDTO patient = new PatientDTO();
        patient.setPhoneNumber("555555");
        patient.setBirthDate(new Date());
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");

        patientService.saveNewPatient(patient);

        patientService.deletePatientByFirstNameAndLastName("TestFirstName", "TestLastName");

        PatientDTO patientDTOExpected = patientService.getPatientByFirstNameAndLastName("TestFirstName", "TestLastName");

        assertNull(patientDTOExpected.getFirstName());

    }
}
