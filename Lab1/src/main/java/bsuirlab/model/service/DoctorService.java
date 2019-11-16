package main.java.bsuirlab.model.service;

import main.java.bsuirlab.model.bean.Doctor;


public class DoctorService implements Comparable<DoctorService>{

    private Doctor doctor;

    public DoctorService(String name, String birthDate, int departmentID, int ID){
        this.doctor = new Doctor();
        doctor.setName(name);
        doctor.setBirthDate(birthDate);
        doctor.setDepartmentID(departmentID);
        doctor.setID(ID);
    }

    public String getName(){
        return doctor.getName();
    }

    public int getDepartmentID(){
        return doctor.getDepartmentID();
    }

    public String getBirthDate(){
        return doctor.getBirthDate();
    }

    public int getID(){
        return doctor.getID();
    }

    public int compareTo(DoctorService doctor){
        return ((Integer) getID()).compareTo(doctor.getID());
    }
}
