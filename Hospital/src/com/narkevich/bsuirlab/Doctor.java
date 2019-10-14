package com.narkevich.bsuirlab;

import java.text.DateFormat;
import java.util.List;

public class Doctor {

    private String name;
    private DateFormat birthDate;
    private String position;
    private List<Patient> patients;

    public Doctor(String name, DateFormat birthDate, String position) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}
