package com.narkevich.bsuirlab.model.service;

import com.narkevich.bsuirlab.model.bean.Hospital;

import java.util.ArrayList;
import java.util.List;

public class HospitalService {
    private static HospitalService hospitalInstance = new HospitalService();

    private Hospital hospital;

    public static HospitalService getHospital() {
        return hospitalInstance;
    }

    private HospitalService() {
        hospital = new Hospital();
    }

    public String getName(){
        return hospital.getName();
    }

    public ArrayList<DepartmentService> getDepartments(){
        return hospital.getDepartments();
    }

    public void setInfo(String country, String city, String address, String name){
        hospital.setCountry(country);
        hospital.setCity(city);
        hospital.setAddress(address);
        hospital.setName(name);
    }

    public ArrayList<DoctorService> getDoctors() {
        return hospital.getDoctors();
    }

    public ArrayList<NurseService> getNurses(){
        return hospital.getNurses();
    }

    public ArrayList<PatientService> getPatients(){
        return hospital.getPatients();
    }

    public void setDepartments(ArrayList<DepartmentService> list){
        hospital.setDepartments(list);
    }

    public void setNurses(ArrayList<NurseService> list){
        hospital.setNurses(list);
    }

    public void setDoctors(ArrayList<DoctorService> list){
        hospital.setDoctors(list);
    }

    public void setPatients(ArrayList<PatientService> list){
        hospital.setPatients(list);
    }

    public boolean validateDepartmentID(int ID){
        ArrayList<DepartmentService> departments = hospital.getDepartments();
        for (DepartmentService d: departments){
            if (d.getID() == ID){
                return true;
            }
        }
        return false;
    }

    public boolean validateDoctorID(int ID){
        ArrayList<DoctorService> doctors = hospital.getDoctors();
        for (DoctorService d: doctors){
            if (d.getDepartmentID() == ID){
                return true;
            }
        }
        return false;
    }

    public boolean validatePatientID(int ID){
        ArrayList<PatientService> patients = hospital.getPatients();
        for (PatientService p: patients){
            if (p.getID() == ID){
                return true;
            }
        }
        return false;
    }

    public int getNewDepartmentID(){
        return hospital.getNewDepartmentID();
    }

    public int getNewDoctorID(){
        return hospital.getNewDoctorID();
    }

    public int getNewNurseID(){
        return hospital.getNewNurseID();
    }

    public int getNewPatientID(){
        return hospital.getNewPatientID();
    }
}
