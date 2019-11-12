package com.narkevich.bsuirlab.model.bean;

import com.narkevich.bsuirlab.model.service.DepartmentService;
import com.narkevich.bsuirlab.model.service.DoctorService;
import com.narkevich.bsuirlab.model.service.NurseService;
import com.narkevich.bsuirlab.model.service.PatientService;

import java.util.ArrayList;
import java.util.Collections;

public class Hospital implements java.io.Serializable {

    /**
     * Table number
     */
    private String country;
    private String city;
    private String address;
    private String name;
    private ArrayList<DepartmentService> departments;
    private ArrayList<DoctorService> doctors;
    private ArrayList<NurseService> nurses;
    private ArrayList<PatientService> patients;

    /**
     * Constructor that defines
     * table number as 0
     */
    public Hospital(){
        name = "Hospital";
        city = "City";
        country = "Country";
        address = "Address";
        departments = new ArrayList<DepartmentService>();
        doctors = new ArrayList<DoctorService>();
        patients = new ArrayList<PatientService>();
        nurses = new ArrayList<NurseService>();
    }

    /**
     * Get table number
     * @return Hospital name
     */
    public String getName() {
        return name;
    }

    /**
     * Set table number
     * @param name Table number
     */
    public void setName(String name) {
        if (name != null)
            this.name = name;
    }

    public ArrayList<DepartmentService> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<DepartmentService> departments) {
        this.departments = departments;
    }

    public void setNurses(ArrayList<NurseService> nurses) {
        this.nurses = nurses;
    }

    public ArrayList<NurseService> getNurses() {
        return nurses;
    }

    public void setDoctors(ArrayList<DoctorService> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<DoctorService> getDoctors() {
        return doctors;
    }

    public ArrayList<PatientService> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<PatientService> patients) {
        this.patients = patients;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public int getNewDepartmentID(){
        if (departments.isEmpty()){
            return 1;
        }else{
            Collections.sort(departments);
            return departments.get(departments.size()-1).getID() + 1;
        }
    }

    public int getNewDoctorID(){
        if (doctors.isEmpty()){
            return 1;
        }else{
            Collections.sort(doctors);
            return doctors.get(doctors.size()-1).getID() + 1;
        }
    }

    public int getNewNurseID(){
        if (nurses.isEmpty()){
            return 1;
        }else{
            Collections.sort(nurses);
            return nurses.get(nurses.size()-1).getID() + 1;
        }
    }

    public int getNewPatientID(){
        if (patients.isEmpty()){
            return 1;
        }else{
            Collections.sort(patients);
            return patients.get(patients.size()-1).getID() + 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (name != ((Hospital)o).name) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return  this.hashCode();
    }

    @Override
    public String toString() {
        return "Больница{ " + name + "\n" + city + ", " + country + " }";
    }
}
