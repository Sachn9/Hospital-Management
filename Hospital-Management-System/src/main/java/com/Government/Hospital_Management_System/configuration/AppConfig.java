package com.Government.Hospital_Management_System.configuration;

import com.Government.Hospital_Management_System.model.Doctor;
import com.Government.Hospital_Management_System.model.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;


@Configuration
public class AppConfig {
    @Bean
    public HashMap<Integer, Hospital> hospitalDB() {
        return new HashMap<>();
    }

    @Bean
    public HashMap<Integer, Doctor> doctorDB(){
        return new HashMap<>();
    }
}
