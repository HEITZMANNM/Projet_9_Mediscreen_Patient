package com.Mediscreen.AppPatient.controller;

import com.Mediscreen.AppPatient.model.Patient;
import com.Mediscreen.AppPatient.model.dto.PatientDTO;
import com.Mediscreen.AppPatient.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

    @Autowired
    PatientService patientService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
        PatientDTO patient = new PatientDTO();
        patient.setPhoneNumber("555555");
        patient.setBirthDate(new Date());
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");

        patientService.saveNewPatient(patient);
    }

    @AfterEach
    public void cleanDB(){

        patientService.deletePatientByFirstNameAndLastName("TestFirstName", "TestLastName");
    }


    @Test
    public void testToGetAllPatients() throws Exception {

        this.mockMvc.perform(get("/patient/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
    }

    @Test
    public void testToGetPatientById() throws Exception {

        PatientDTO patientDTO = new PatientDTO();

        List<PatientDTO> listOfAllPatients = patientService.getAllPatient();

        for(PatientDTO patientDTO1 : listOfAllPatients)
        {
            if(patientDTO1.getFirstName().equals("TestFirstName")){

                patientDTO = patientDTO1;
            }
        }

        this.mockMvc.perform(get("/patient/identity").param("id", String.valueOf(patientDTO.getId())))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("TestFirstName"));
    }

    @Test
    public void testToDeletePatientByFirstNameAndLastName() throws Exception {

        this.mockMvc.perform(delete("/patient/delete").param("firstName", "TestFirstName").param( "lastName", "TestLastName"))
                .andExpect(status().isOk());
    }

    @Test
    public void testToDSaveNewPatient() throws Exception {

        PatientDTO patient = new PatientDTO();
        patient.setPhoneNumber("555444");
        patient.setBirthDate(new Date());
        patient.setGender("F");
        patient.setAddress("testAddress2");
        patient.setLastName("TestLastName2");
        patient.setFirstName("TestFirstName2");

        this.mockMvc.perform(post("/patient/add").content(asJsonString(patient))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());


        patientService.deletePatientByFirstNameAndLastName("TestLastName2", "TestFirstName2");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

