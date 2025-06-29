package com.Government.Hospital_Management_System.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class Hospital {
    int id;
    String name;
    String address;
    String email;
    Long PhoneNumber;
    List<Doctor> doctors;
    List<Patient> patients;
}
