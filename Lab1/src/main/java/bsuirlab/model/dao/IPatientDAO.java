package main.java.bsuirlab.model.dao;

import main.java.bsuirlab.model.dao.impl.DAOException;
import main.java.bsuirlab.model.service.PatientService;

import java.util.ArrayList;

public interface IPatientDAO {

    /**
     * Add patient to file
     * @param path Path to file
     * @param patient Patient
     * @throws DAOException If file not found
     */
    void addPatient(String path, PatientService patient) throws DAOException;

    /**
     * Show information about all patients
     * @param path Path to file
     * @return List of patients
     * @throws DAOException If file not found
     */
    ArrayList<PatientService> showPatients(String path) throws DAOException;

    /**
     * Delete patient from file
     * @param path Path to file
     * @param patient Patient
     * @throws DAOException If file not found
     */
    void deletePatient(String path, PatientService patient) throws DAOException;

    /**
     * Edit information about patient
     * @param path Path to file
     * @param sourcePatient Replaceable patient
     * @param destPatient Replacing patient
     * @throws DAOException If file not found
     */
    void editPatient(String path, PatientService sourcePatient, PatientService destPatient) throws DAOException;

}
