package com.Mediscreen.AppPatient.repository;

import com.Mediscreen.AppPatient.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Transactional
    void deletePatientByFirstNameAndLastName(String firstName, String lastName);

    Patient findPatientById(int id);

    Patient findPatientByFirstNameAndLastName(String firstName, String lastName);
}
