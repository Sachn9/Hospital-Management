package com.Government.Hospital_Management_System.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor {
    int  id;
    String name;
    String specialization;
    String degree;
    String email;
    Long PhoneNumber;


}
