package com.Mediscreen.AppPatient.service.impl;

import com.Mediscreen.AppPatient.model.Patient;
import com.Mediscreen.AppPatient.model.dto.PatientDTO;
import com.Mediscreen.AppPatient.repository.PatientRepository;
import com.Mediscreen.AppPatient.service.PatientDTOService;
import com.Mediscreen.AppPatient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientDTOService patientDTOService;

    @Override
    public List<PatientDTO> getAllPatient() {

        List<Patient> listOfAllPatients = new ArrayList<>();
        try{
            Iterable<Patient> iterable = patientRepository.findAll();

            for (Patient patient : iterable){
                listOfAllPatients.add(patient);
            }
            log.info("The list of all patient was fetch");
        }
        catch (Exception ex){
            log.error("Error to fetch patients list");
        }
        List<PatientDTO> listOfAllPatientsDTO = patientDTOService.mapPatientsToPatientsDto(listOfAllPatients);
        return listOfAllPatientsDTO;
    }

    @Override
    public PatientDTO getPatientByFirstNameAndLastName(String firstName, String lastName) {

        Patient patient = new Patient();

        try{

            patient = patientRepository.findPatientByFirstNameAndLastName(firstName, lastName);
            log.info("The patient was find");
        }
        catch (Exception ex){
            log.error("Error to find patient");
        }
        PatientDTO patientDTO = patientDTOService.convertPatientToPatientDto(patient);
        return patientDTO;
    }

    @Override
    public void deletePatientByFirstNameAndLastName(String firstName, String lastName) {

        try{

            patientRepository.deleteByFirstNameAndLastName(firstName, lastName);
            log.info("The patient was deleted");
        }
        catch (Exception ex){
            log.error("Error to delete patient");
        }

    }

    @Override
    public void upDatePatient(PatientDTO patient) {

        try{

            Patient patientExisting =  patientRepository.findPatientByFirstNameAndLastName(patient.getFirstName(), patient.getLastName());
            patientExisting.setAddress(patient.getAddress());
            patientExisting.setPhoneNumber(patient.getPhoneNumber());
            patientExisting.setLastName(patient.getLastName());

            patientRepository.save(patientExisting);
            log.info("The patient was updated");
        }
        catch (Exception ex){
            log.error("Error to update patient");
        }

    }

    @Override
    public boolean saveNewPatient(PatientDTO patientDto) {

        boolean answer = false;
        try{
            Patient patient = patientDTOService.convertPatientDtoToPatient(patientDto);
            patientRepository.save(patient);
            answer = true;
            log.info("The patient was saved");
        }
        catch (Exception ex){
            log.error("Error to save the new patient");
        }
        return answer;
    }


}
