package com.narkevich.bsuirlab.model.service;

import com.narkevich.bsuirlab.model.bean.Patient;

public class PatientService implements Comparable<PatientService>{

    private Patient patient;

    public PatientService(String name, String birthDate, String admissionDate, String diagnosis, String treatment, int departmentID, int doctorID, int ID){
        patient = new Patient();
        patient.setName(name);
        patient.setBirthDate(birthDate);
        patient.setAdmissionDate(admissionDate);
        patient.setDiagnosis(diagnosis);
        patient.setTreatment(treatment);
        patient.setDepartmentID(departmentID);
        patient.setDoctorID(doctorID);
        patient.setID(ID);
    }

    public String getName(){
        return patient.getName();
    }

    public String getAdmissionDate(){
        return patient.getAdmissionDate();
    }

    public String getBirthDate(){
        return patient.getBirthDate();
    }

    public String getDiagnosis(){
        return patient.getDiagnosis();
    }

    public String getTreatment(){
        return patient.getTreatment();
    }

    public int getID(){
        return patient.getID();
    }

    public int getDepartmentID(){
        return patient.getDepartmentID();
    }

    public int getDoctorID(){
        return patient.getDoctorID();
    }

    public int compareTo(PatientService patient){
        return ((Integer) getID()).compareTo(patient.getID());
    }

}
