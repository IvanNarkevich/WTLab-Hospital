package main.java.bsuirlab.model.dao;

import main.java.bsuirlab.model.dao.impl.*;

public class DAOFactory {

    private static final DAOFactory daoFactory = new DAOFactory();

    private final IDepartmentDAO departmentDAO = new DepartmentDAO();
    private final IDoctorDAO doctorDAO = new DoctorDAO();
    private final INurseDAO nurseDAO = new NurseDAO();
    private final IPatientDAO patientDAO = new PatientDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        return daoFactory;
    }

    public IDepartmentDAO getDepartmentDAO() {
        return departmentDAO;
    }

    public  IDoctorDAO getDoctorDAO() {
        return doctorDAO;
    }

    public INurseDAO getNurseDAO() {
        return nurseDAO;
    }

    public IPatientDAO getPatientDAO() {
        return patientDAO;
    }
}
