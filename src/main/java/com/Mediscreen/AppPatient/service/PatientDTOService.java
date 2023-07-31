package com.Mediscreen.AppPatient.service;

import com.Mediscreen.AppPatient.model.Patient;
import com.Mediscreen.AppPatient.model.dto.PatientDTO;

import java.util.List;

public interface PatientDTOService {
    PatientDTO convertPatientToPatientDto(Patient patient);

    Patient convertPatientDtoToPatient(PatientDTO patientDto);

    List<PatientDTO> mapPatientsToPatientsDto(List<Patient> patients);
}
