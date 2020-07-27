package com.hospita.service;

import com.hospita.entity.Patient;
import com.hospita.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    public void delete(Integer id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> findByName(String name) {
        return patientRepository.findByLastName(name);
    }

}
