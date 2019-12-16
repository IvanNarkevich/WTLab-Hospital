package by.bsuir.wt_lab.entity;

import java.util.ArrayList;
import java.util.Collections;

public class Hospital implements java.io.Serializable {

    private ArrayList<Department> departments;
    private ArrayList<Doctor> doctors;
    private ArrayList<Nurse> nurses;
    private ArrayList<Patient> patients;

    public Hospital(){
        departments = new ArrayList<Department>();
        doctors = new ArrayList<Doctor>();
        patients = new ArrayList<Patient>();
        nurses = new ArrayList<Nurse>();
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void setNurses(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }

    public ArrayList<Nurse> getNurses() {
        return nurses;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
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
