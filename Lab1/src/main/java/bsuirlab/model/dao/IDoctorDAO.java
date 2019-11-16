package main.java.bsuirlab.model.dao;

import main.java.bsuirlab.model.dao.impl.DAOException;
import main.java.bsuirlab.model.service.DoctorService;

import java.util.ArrayList;

public interface IDoctorDAO {

    /**
     * Add doctor to file
     * @param path Path to file
     * @param doctor Doctor
     * @throws DAOException If file not found
     */
    void addDoctor(String path, DoctorService doctor) throws DAOException;

    /**
     * Show information about all doctors
     * @param path Path to file
     * @return List of doctors
     * @throws DAOException If file not found
     */
    ArrayList<DoctorService> showDoctors(String path) throws DAOException;

    /**
     * Delete doctor from file
     * @param path Path to file
     * @param doctor Doctor
     * @throws DAOException If file not found
     */
    void deleteDoctor(String path, DoctorService doctor) throws DAOException;

    /**
     * Edit information about doctor
     * @param path Path to file
     * @param sourceDoctor Replaceable doctor
     * @param destDoctor Replacing doctor
     * @throws DAOException If file not found
     */
    void editDoctor(String path, DoctorService sourceDoctor, DoctorService destDoctor) throws DAOException;

}
