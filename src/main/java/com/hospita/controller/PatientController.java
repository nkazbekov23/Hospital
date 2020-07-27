package com.hospita.controller;

import com.hospita.entity.Patient;
import com.hospita.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("patients", patientService.getAll());
        return "main";
    }

    //add new patient
    @RequestMapping(value = "/patient/submit", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.save(patient);

        return "redirect:/patient";
    }

    @GetMapping("/name")
    public String findByName(@PathVariable("name") String name, Model model) {
        model.addAttribute("patientss", patientService.findByName(name));

        return "redirect:/patient";
    }

    //delete
    @RequestMapping(value = "/delete/patient/{id}")
    public String delete(@PathVariable("id") Integer id) {
        patientService.delete(id);

        return "redirect:/";
    }

}
