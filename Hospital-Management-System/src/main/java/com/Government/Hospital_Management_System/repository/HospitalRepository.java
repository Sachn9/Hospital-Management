package com.Government.Hospital_Management_System.repository;

import com.Government.Hospital_Management_System.model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HospitalRepository {
    @Autowired
    HashMap<Integer, Hospital> hospitalDB;

    public void saveHospital(int id,Hospital hospital){
        hospitalDB.put(id,hospital);
    }

    public Hospital findByHospitalID(int id){
        return hospitalDB.get(id);
    }

    public int getTotalHospital(){
        int size=hospitalDB.size();
        return size;
    }

    public HashMap<Integer,Hospital> getAllHospital(){

        return hospitalDB;
    }

}
