package com.Mediscreen.AppPatient.service.impl;

import com.Mediscreen.AppPatient.model.Patient;
import com.Mediscreen.AppPatient.model.dto.PatientDTO;
import com.Mediscreen.AppPatient.service.PatientDTOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PatientDTOServiceImpl implements PatientDTOService {

    /**
     * Convert a Patient object into a PatientDto object.
     *
     * @param patient - The Patient object to convert
     * @return A PatientDto object
     */
    @Override
    public PatientDTO convertPatientToPatientDto(Patient patient) {

        PatientDTO patientDto = new PatientDTO();

        try {


            patientDto.setId(patient.getId());
            patientDto.setFirstName(patient.getFirstName());
            patientDto.setLastName(patient.getLastName());
            patientDto.setGender(patient.getGender());
            patientDto.setAddress(patient.getAddress());
            patientDto.setBirthDate(patient.getBirthDate());
            patientDto.setPhoneNumber(patient.getPhoneNumber());

            log.info("The convertion of Patient to PatientDTO was done");
        }
        catch (Exception ex){
            log.error("Error to convert Patient to PatientDTO ");
        }
        return patientDto;
    }

    /**
     * Convert a PatientDto object into a Patient object.
     *
     * @param patientDto - The PatientDto object to convert
     * @return A Patient object
     */
    @Override
    public Patient convertPatientDtoToPatient(PatientDTO patientDto) {

        Patient patient = new Patient();
        try {
            patient.setId(patientDto.getId());
            patient.setFirstName(patientDto.getFirstName());
            patient.setLastName(patientDto.getLastName());
            patient.setGender(patientDto.getGender());
            patient.setBirthDate(patientDto.getBirthDate());
            patient.setAddress(patientDto.getAddress());
            patient.setPhoneNumber(patientDto.getPhoneNumber());
            log.info("The convertion of PatientDTO to Patient was done");
        }
        catch (Exception ex){
            log.error("Error to convert PatientDTO to Patient");
        }

        return patient;
    }

    /**
     * Maps a list of Patient objects into a list of PatientDto objects.
     *
     * @param patients - The list of Patient objects to map
     * @return A list of PatientDto objects
     */
    @Override
    public List<PatientDTO> mapPatientsToPatientsDto(List<Patient> patients) {

        List<PatientDTO> patientsDTO = new ArrayList<>();
        try {

            for (Patient patient : patients) {
                patientsDTO.add(convertPatientToPatientDto(patient));
            }
            log.info("The list of Patient was converted to a list of PatientDTO");
        }
        catch (Exception ex){
            log.error("Error to convert the list of Patient to a list of PatientDTO");
        }

        return patientsDTO;
    }
}
