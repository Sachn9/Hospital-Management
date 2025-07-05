package com.Government.Hospital_Management_System.repository;

import com.Government.Hospital_Management_System.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DoctorRepository {

    @Autowired
    HashMap<Integer, Doctor> doctorDB;

    public void registerDoctor(int id,Doctor doctor){
        doctorDB.put(id,doctor);
    }

    public Doctor getById(int id){
        return doctorDB.get(id);
    }

    public int doctorDBSize(){
        int size=doctorDB.size();
        return size;
    }

    public HashMap<Integer,Doctor> getAllDoctors(){
        return doctorDB;
    }
}
