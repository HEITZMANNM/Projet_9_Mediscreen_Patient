package com.Mediscreen.AppPatient.service;

import com.Mediscreen.AppPatient.model.Patient;
import com.Mediscreen.AppPatient.model.dto.PatientDTO;

import java.util.List;

public interface PatientService {

     List<PatientDTO> getAllPatient();

     PatientDTO getPatientById(int id);

     void deletePatientByFirstNameAndLastName(String firstName, String lastName);

     boolean upDatePatient(PatientDTO patient);

     boolean saveNewPatient(PatientDTO patient);
}
