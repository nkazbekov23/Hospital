package com.hospita.controller;

import com.hospita.entity.Patient;
import com.hospita.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("patients", patientService.getAll());
        return "main";
    }

    @RequestMapping(value = "/patient")
    public String patient(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient";
    }

    @RequestMapping(value = "/patient/submit", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.save(patient);

        return "redirect:/patient";
    }

}
