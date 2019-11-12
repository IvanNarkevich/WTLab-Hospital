package com.narkevich.bsuirlab.model.service;

import com.narkevich.bsuirlab.model.bean.Department;

public class DepartmentService implements Comparable<DepartmentService>{

    private Department department;

    public DepartmentService(String name, int ID){
        department = new Department();
        department.setName(name);
        department.setID(ID);
    }

    public int getID(){
        return department.getID();
    }

    public String getName(){
        return department.getName();
    }

    public int compareTo(DepartmentService department){
        return ((Integer) getID()).compareTo(department.getID());
    }

}
