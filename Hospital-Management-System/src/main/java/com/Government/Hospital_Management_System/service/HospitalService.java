package com.Government.Hospital_Management_System.service;

import com.Government.Hospital_Management_System.model.Doctor;
import com.Government.Hospital_Management_System.model.Hospital;
import com.Government.Hospital_Management_System.repository.HospitalRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    public void setHospitalRepository(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    /**
     *
     * work this function id to save hospital object in the database
     *As it is service layer function inside this we will be calculating ID for the hospital
     * And then will be calling hospital repository to save hospital inside the database
     *
     * @param hospital
     */
    public void registerHospital(Hospital hospital){

        //ist step we need to calculate the ID for the hospital
        int id=hospitalRepository.getTotalHospital()+1;
        hospital.set(id);
        hospitalRepository.saveHospital(id,hospital);
    }

    public Hospital getHospitalById(int id){
        Hospital hospital=hospitalRepository.findByHospitalID(id);
        return hospital;
    }

    public List<Hospital> getAllHospitals(){
        HashMap<Integer,Hospital> map=hospitalRepository.getAllHospital();
        List<Hospital> hospitals=new ArrayList<>();
        for(int key:map.keySet()){
            Hospital hospital=map.get(key);
            hospitals.add(hospital);
        }
        return hospitals;
    }


    /**
     *
     * Below function will return the hospital which is having minimum value of the doctors.
     */

    public Hospital getHospitalHavingMinimumDoctor(){
        List<Hospital> hospitals=this.getAllHospitals();

        Hospital ans=null;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<hospitals.size();i++){
            Hospital hospital=hospitals.get(i);
            int size=hospital.getDoctors().size();
            if(size <min){
                min=size;
                ans=hospital;
            }
        }
        return ans;
    }

    public List<Doctor> getAllHospitalById(int hospitalId){
        Hospital hospital=this.getHospitalById(hospitalId);
        return hospital.getDoctors();
    }
}
