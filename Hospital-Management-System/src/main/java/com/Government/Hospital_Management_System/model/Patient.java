package com.Government.Hospital_Management_System.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
    int id;
    String name;
    String gender;
    int age;
    String disease;
}
