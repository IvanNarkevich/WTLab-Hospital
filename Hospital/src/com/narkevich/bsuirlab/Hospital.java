package com.narkevich.bsuirlab;

public class Hospital {
    private static Hospital ourInstance;
    private String country;
    private String city;
    private String name;

    public static Hospital getInstance(String country, String city, String name) {
        if (ourInstance == null) {
            ourInstance = new Hospital(country, city, name);
        }
        return ourInstance;
    }

    private Hospital(String country, String city, String name) {
        this.country = country;
        this.city = city;
        this.name = name;
    }

    public void addDoctor(Doctor doctor) {

    }

    public void addPatient(Patient patient) {

    }
}
