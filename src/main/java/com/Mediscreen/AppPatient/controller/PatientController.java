package com.Mediscreen.AppPatient.controller;

import com.Mediscreen.AppPatient.model.dto.PatientDTO;
import com.Mediscreen.AppPatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patient/all")
    public List<PatientDTO> getAllPatients()
    {
        return patientService.getAllPatient();
    }

    @GetMapping("/patient/identity")
    public PatientDTO getPatientByFirstNameAndLastName(@RequestParam(name = "id") int id)
    {
        return patientService.getPatientById(id);
    }

    @PostMapping("/patient/add")
    public ResponseEntity<HttpStatus> addPatient(@RequestBody PatientDTO patientDto) {

        if(patientService.saveNewPatient(patientDto))
        {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/patient/delete")
    public void deletePatient(@RequestParam(name = "id")int id)
    {
        patientService.delete(id);
    }

    @PostMapping("/patient/upDate")
    public ResponseEntity<HttpStatus> upDatePatient(@RequestBody PatientDTO patientDto) {

        if(patientService.upDatePatient(patientDto))
        {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
