package com.narkevich.bsuirlab;

import java.util.List;

public class Department {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Department(String name){
        this.name = name;
    }

    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }
}
