package com.Mediscreen.AppPatient.model;

import com.Mediscreen.AppPatient.model.dto.PatientDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PatientDTOModelTest {

    @Test
    public void testHashCode()
    {
        PatientDTO patient = new PatientDTO();
        patient.setPhoneNumber("555555");
        patient.setBirthDate(new Date());
        patient.setId(1);
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");

        assertNotNull(patient.hashCode());
    }

    @Test
    public void testEquals()
    {
        PatientDTO patient = new PatientDTO();
        patient.setPhoneNumber("555555");
        patient.setBirthDate(new Date());
        patient.setId(1);
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");

        PatientDTO patient2 = new PatientDTO();
        patient2.setPhoneNumber("555555");
        patient2.setBirthDate(new Date());
        patient2.setId(1);
        patient2.setGender("M");
        patient2.setAddress("testAddress");
        patient2.setLastName("TestLastName");
        patient2.setFirstName("TestFirstName");

        PatientDTO patient3 = new PatientDTO();
        patient3.setPhoneNumber("777777");
        patient3.setBirthDate(new Date());
        patient3.setId(1);
        patient3.setGender("M");
        patient3.setAddress("testAddress");
        patient3.setLastName("TestLastName");
        patient3.setFirstName("TestFirstName");


        assertTrue(patient.equals(patient));

        assertTrue(patient.equals(patient2));

        patient2 = null;

        assertFalse(patient.equals(patient2));

        assertFalse((new Patient().equals(patient)));

        assertFalse(patient.equals(patient3));

        patient3.setPhoneNumber("555555");

        patient3.setAddress("testAddress3");

        assertFalse(patient.equals(patient3));
    }

    @Test
    public void testToString()
    {
        PatientDTO patient = new PatientDTO();
        patient.setPhoneNumber("555555");
        patient.setBirthDate(new Date());
        patient.setId(1);
        patient.setGender("M");
        patient.setAddress("testAddress");
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");

        assertNotNull(patient.toString());
    }
}
