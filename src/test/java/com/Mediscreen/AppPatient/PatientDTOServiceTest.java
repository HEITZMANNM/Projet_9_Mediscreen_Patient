package com.Mediscreen.AppPatient;

import com.Mediscreen.AppPatient.model.Patient;
import com.Mediscreen.AppPatient.model.dto.PatientDTO;
import com.Mediscreen.AppPatient.service.PatientDTOService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientDTOServiceTest {

    @Autowired
    PatientDTOService patientDTOService;

    @Test
    public void testToConvertPatientToPatientDto(){

        Patient patient = new Patient();
        patient.setPhoneNumber("555555");
        patient.setId(0);
        patient.setBirthDate(new Date());
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");

        PatientDTO patientDTO = patientDTOService.convertPatientToPatientDto(patient);

        assertEquals(patientDTO.getFirstName(), "TestFirstName");
    }

    @Test
    public void testToConvertPatientDtoToPatient(){

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPhoneNumber("555555");
        patientDTO.setId(0);
        patientDTO.setBirthDate(new Date());
        patientDTO.setGender("M");
        patientDTO.setAddress("testAddress");
        patientDTO.setLastName("TestLastName");
        patientDTO.setFirstName("TestFirstName");

       Patient patient = patientDTOService.convertPatientDtoToPatient(patientDTO);

        assertEquals(patient.getAddress(), "testAddress");
    }

    @Test
    public void testToMapPatientsToPatientsDto(){

        List<Patient> patients = new ArrayList<>();

        Patient patient = new Patient();
        patient.setPhoneNumber("555555");
        patient.setId(0);
        patient.setBirthDate(new Date());
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");

        Patient patient2 = new Patient();
        patient2.setPhoneNumber("555777");
        patient2.setId(0);
        patient2.setBirthDate(new Date());
        patient2.setGender("F");
        patient2.setAddress("testAddress2");
        patient2.setLastName("TestLastName2");
        patient2.setFirstName("TestFirstName2");

        patients.add(patient);
        patients.add(patient2);

        List<PatientDTO> patientsDTO = patientDTOService.mapPatientsToPatientsDto(patients);

        assertEquals(patientsDTO.size(), 2);
        assertEquals(patientsDTO.get(0).getAddress(), "testAddress");

    }
}
