package com.Mediscreen.AppPatient.repository;

import com.Mediscreen.AppPatient.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    void deleteByFirstNameAndLastName(String firstName, String lastName);

    Patient findPatientById(int id);
}
