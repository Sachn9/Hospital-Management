package com.Government.Hospital_Management_System.repository;

import com.Government.Hospital_Management_System.model.Hospital;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HospitalRepository {

    HashMap<Integer, Hospital> hospitalDB;
    public HospitalRepository(){
        this.hospitalDB=new HashMap<>();
    }

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
