package com.Government.Hospital_Management_System.controllers;

import com.Government.Hospital_Management_System.model.Doctor;
import com.Government.Hospital_Management_System.model.Hospital;
import com.Government.Hospital_Management_System.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hospital")
@Slf4j
public class HospitalControllers {

    private static final Logger log = LoggerFactory.getLogger(HospitalControllers.class);

    @Autowired
    HospitalService hospitalService;

    /**
     *This function will get triggered when endpoint http://localhost:8080/api/v1/hospital/register
     * will get triggered
     * we will be  passing the hospital object which have recevied from the client can be frontend or postman
     *
     * @param hospital
     */
    //http://localhost:8080/api/v1/hospital/register
    @PostMapping("/register")
    public void registerHospital(@RequestBody Hospital hospital){
        log.info("Got hospital model object from the client : " + hospital);
        log.info("Calling  hospital service");
        hospitalService.registerHospital(hospital);
    }


    /**
     *
     * This function will run When url type http://localhost:8080/ap1/v1/hospital/get/1 is getting called
     * and this function will  internally call service to get hospital object which is mapped to this id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Hospital getHospitalById(@PathVariable int id){
        return hospitalService.getHospitalById(id);
    }

    @GetMapping("/get/all")
    public List<Hospital> getAllHospitals(){
        return hospitalService.getAllHospitals();
    }

    @GetMapping("/doctors/{hospitalId}")
    public List<Doctor> getAllDoctorsHospitalById(@PathVariable int hospitalId){
        return hospitalService.getAllHospitalById(hospitalId);
    }
}
