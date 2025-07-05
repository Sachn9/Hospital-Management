package com.Government.Hospital_Management_System.service;

import com.Government.Hospital_Management_System.model.Doctor;
import com.Government.Hospital_Management_System.model.Hospital;
import com.Government.Hospital_Management_System.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    HospitalService hospitalService;

    @Autowired
    DoctorRepository doctorRepository;

    /**
     *
     * This Particular method will receive same doctor object  which our api has received from the client.
     * * @param doctor
     */
    public Hospital doctorRegister(Doctor doctor){

        int id=doctorRepository.doctorDBSize()+1;
        doctorRepository.setId(id);
        Hospital hospital=hospitalService.getHospitalHavingMinimumDoctor();
        hospital.getDoctor().add(doctor);
        doctorRepository.registerDoctor(id,doctor);
        return hospital;
    }

    public List<Doctor> getAllDoctors(){
        HashMap<Integer,Doctor> map=doctorRepository.getAllDoctors();
        List<Doctor> doctors=new LinkedList<>();
        for(int key:map.keySet()){
            Doctor doctor=map.get(key);
            doctors.add(doctor);
        }
        return doctors;
    }


}
