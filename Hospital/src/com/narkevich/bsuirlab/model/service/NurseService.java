package com.narkevich.bsuirlab.model.service;

import com.narkevich.bsuirlab.model.bean.Nurse;

public class NurseService implements Comparable<NurseService>{

    private Nurse nurse;

    public NurseService(String name, String birthDate, int departmentID, int ID){
        nurse = new Nurse();
        nurse.setName(name);
        nurse.setBirthDate(birthDate);
        nurse.setDepartmentID(departmentID);
        nurse.setID(ID);
    }

    public String getName(){
        return nurse.getName();
    }

    public String getBirthDate(){
        return nurse.getBirthDate();
    }

    public int getDepartmentID(){
        return nurse.getDepartmentID();
    }

    public int getID(){
        return nurse.getID();
    }

    public int compareTo(NurseService nurse){
        return ((Integer) getID()).compareTo(nurse.getID());
    }
}
