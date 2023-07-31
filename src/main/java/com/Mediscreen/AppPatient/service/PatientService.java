package com.Mediscreen.AppPatient.service;

import com.Mediscreen.AppPatient.model.Patient;
import com.Mediscreen.AppPatient.model.dto.PatientDTO;

import java.util.List;

public interface PatientService {

     List<PatientDTO> getAllPatient();

     PatientDTO getPatientByFirstNameAndLastName(String firstName, String lastName);

     void deletePatientByFirstNameAndLastName(String firstName, String lastName);

     void upDatePatient(PatientDTO patient);

     boolean saveNewPatient(PatientDTO patient);
}
