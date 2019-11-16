package main.java.bsuirlab.model.bean;

import main.java.bsuirlab.model.service.DepartmentService;
import main.java.bsuirlab.model.service.DoctorService;
import main.java.bsuirlab.model.service.NurseService;
import main.java.bsuirlab.model.service.PatientService;

import java.util.ArrayList;
import java.util.Collections;

public class Hospital implements java.io.Serializable {

    private ArrayList<DepartmentService> departments;
    private ArrayList<DoctorService> doctors;
    private ArrayList<NurseService> nurses;
    private ArrayList<PatientService> patients;

    public Hospital(){
        departments = new ArrayList<DepartmentService>();
        doctors = new ArrayList<DoctorService>();
        patients = new ArrayList<PatientService>();
        nurses = new ArrayList<NurseService>();
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

}
