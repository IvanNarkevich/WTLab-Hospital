package main.java.bsuirlab.model.service;

public class DepartmentAndDoctorMismatchException extends Exception {
    public DepartmentAndDoctorMismatchException(){
        super("Выбранный врач работает в другом отделении");
    }
}
