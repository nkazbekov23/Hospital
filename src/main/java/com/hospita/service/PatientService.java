package com.hospita.service;

import com.hospita.entity.Patient;
import com.hospita.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void save(Patient patient) {
        Patient patient1 = patientRepository.save(patient);
    }

    public List<Patient> getAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

}
