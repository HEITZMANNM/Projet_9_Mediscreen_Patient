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
    public ResponseEntity getAllPatients()
    {
        List<PatientDTO> list = patientService.getAllPatient();
        if(list.size()!= 0)
        {
            return new ResponseEntity<>(patientService.getAllPatient(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/patient/identity")
    public ResponseEntity getPatientById(@RequestParam(name = "id") int id)
    {
       PatientDTO patientDTO= patientService.getPatientById(id);
        if( patientDTO.getId() !=0 && patientDTO.getFirstName() != null && !"".equals(patientDTO.getFirstName()))
        {
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);
        }
       else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/patient/add")
    public ResponseEntity<HttpStatus> addPatient(@RequestBody PatientDTO patientDto) {

        if(patientService.saveNewPatient(patientDto))
        {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/patient/delete")
    public ResponseEntity deletePatient(@RequestParam(name = "id")int id)
    {
        PatientDTO patientDTO = patientService.getPatientById(id);
        if(patientDTO != null)
        {
            patientService.delete(id);
           return new ResponseEntity<>(HttpStatus.OK);
    }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

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
