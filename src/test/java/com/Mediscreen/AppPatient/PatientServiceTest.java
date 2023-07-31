package com.Mediscreen.AppPatient;

import com.Mediscreen.AppPatient.model.Patient;
import com.Mediscreen.AppPatient.model.dto.PatientDTO;
import com.Mediscreen.AppPatient.repository.PatientRepository;
import com.Mediscreen.AppPatient.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @MockBean
    PatientRepository patientRepository;

    @BeforeEach
    public void setUp(){

        List<Patient> listOfallPatients = new ArrayList<>();

        Patient patient = new Patient();
        patient.setPhoneNumber("555555");
        patient.setId(0);
        patient.setBirthDate(new Date());
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");
        Patient patient2 = new Patient();
        patient2.setPhoneNumber("444555");
        patient2.setId(1);
        patient2.setBirthDate(new Date());
        patient2.setGender("F");
        patient2.setAddress("testAddress2");
        patient2.setLastName("TestLastName2");
        patient2.setFirstName("TestFirstName2");

        listOfallPatients.add(patient);
        listOfallPatients.add(patient2);

        when(patientRepository.findAll()).thenReturn(listOfallPatients);
        when(patientRepository.findPatientByFirstNameAndLastName(anyString(), anyString())).thenReturn(patient);
    }

    @Test
    public void testToGetAllPatients(){

        List<PatientDTO> listOfAllPatient = patientService.getAllPatient();

        assertEquals(listOfAllPatient.size(), 2);
        assertEquals(listOfAllPatient.get(0).getFirstName(), "TestFirstName");

    }

    @Test
    public void testToGetPatientByFirstNameAndLastName(){

        PatientDTO patient = patientService.getPatientByFirstNameAndLastName("test", "test");

        assertEquals(patient.getFirstName(), "TestFirstName");
        assertEquals(patient.getAddress(), "testAddress");


    }


}
