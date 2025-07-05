package com.Government.Hospital_Management_System.controllers;

import com.Government.Hospital_Management_System.model.Doctor;
import com.Government.Hospital_Management_System.model.Hospital;
import com.Government.Hospital_Management_System.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/register")
    public Hospital doctorRegister(@RequestBody Doctor doctor){
        return doctorService.doctorRegister(doctor);
    }

    @GetMapping("get/all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
}
