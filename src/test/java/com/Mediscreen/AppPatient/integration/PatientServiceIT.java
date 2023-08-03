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
        patientService.delete(patientDTOExpected.getId());

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

        PatientDTO patientDTO = patientService.getPatientByFirstNameAndLastName("TestFirstName", "TestLastName");

        patientService.delete(patientDTO.getId());

        PatientDTO patientDTOExpected = patientService.getPatientByFirstNameAndLastName("TestFirstName", "TestLastName");

        assertNull(patientDTOExpected.getFirstName());

    }

    @Test
    public void testToUpDatePatient(){

        PatientDTO patient = new PatientDTO();
        patient.setPhoneNumber("555555");
        patient.setBirthDate(new Date());
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");

        patientService.saveNewPatient(patient);

        PatientDTO patientDTOExpected = patientService.getPatientByFirstNameAndLastName("TestFirstName", "TestLastName");

        patientDTOExpected.setPhoneNumber("77777777");

        patientService.upDatePatient(patientDTOExpected);

        PatientDTO patientDTOExpectedAfterUpdate = patientService.getPatientByFirstNameAndLastName("TestFirstName", "TestLastName");


        assertEquals(patientDTOExpectedAfterUpdate.getPhoneNumber(), patientDTOExpected.getPhoneNumber());

        //for cleaning the database
        patientService.delete(patientDTOExpectedAfterUpdate.getId());

    }
}
