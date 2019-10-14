package com.narkevich.bsuirlab;

import java.text.DateFormat;

public class Patient {

    private String name;
    private DateFormat birthDate;
    private DateFormat admissionDate;
    private String illness;
    private Doctor doctor;

    public Patient(String name, DateFormat birthDate, DateFormat admissionDate,String illness, Doctor doctor) {
        this.name = name;
        this.birthDate = birthDate;
        this.admissionDate = admissionDate;
        this.illness = illness;
        this.doctor = doctor;
    }

    public void assignDoctor(Doctor doctor){
        this.doctor = doctor;
        doctor.addPatient(this);
    }
}
