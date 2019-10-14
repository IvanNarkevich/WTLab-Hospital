package com.narkevich.bsuirlab;

import java.util.List;

public class Hospital {
    private static Hospital ourInstance;
    private String country;
    private String city;
    private String name;
    private String address;
    private List<Department> departments;

    public static Hospital getInstance(String country, String city, String name, String address) {
        if (ourInstance == null) {
            ourInstance = new Hospital(country, city, name, address);
        }
        return ourInstance;
    }

    private Hospital(String country, String city, String name, String address) {
        this.country = country;
        this.city = city;
        this.name = name;
        this.address = address;
    }

    public void addDepartment() {

    }

}
