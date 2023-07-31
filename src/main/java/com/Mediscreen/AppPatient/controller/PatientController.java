package com.Mediscreen.AppPatient.controller;

import com.Mediscreen.AppPatient.model.dto.PatientDTO;
import com.Mediscreen.AppPatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patient/all")
//    @CrossOrigin(origins = "http://localhost:4200")
    public List<PatientDTO> getAllPatients()
    {
        return patientService.getAllPatient();
    }

    @GetMapping("/patient/identity")
//    @CrossOrigin(origins = "http://localhost:4200")
    public PatientDTO getPatientByFirstNameAndLastName(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName)
    {
        return patientService.getPatientByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping("/patient/add")
    //    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<HttpStatus> addPatient(@RequestBody PatientDTO patientDto) {

        if(patientService.saveNewPatient(patientDto))
        {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/patient/delete")
//    @CrossOrigin(origins = "http://localhost:4200")
    public void deletePatient(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName)
    {
        patientService.deletePatientByFirstNameAndLastName(firstName, lastName);
    }
}
