package main.java.bsuirlab.model.dao;

import main.java.bsuirlab.model.dao.impl.DAOException;
import main.java.bsuirlab.model.service.NurseService;

import java.util.ArrayList;

public interface INurseDAO {

    /**
     * Add nurse to file
     * @param path Path to file
     * @param nurse Nurse
     * @throws DAOException If file not found
     */
    void addNurse(String path, NurseService nurse) throws DAOException;

    /**
     * Show information about all nurses
     * @param path Path to file
     * @return List of nurses
     * @throws DAOException If file not found
     */
    ArrayList<NurseService> showNurses(String path) throws DAOException;

    /**
     * Delete nurse from file
     * @param path Path to file
     * @param nurse Nurse
     * @throws DAOException If file not found
     */
    void deleteNurse(String path, NurseService nurse) throws DAOException;

    /**
     * Edit information about nurse
     * @param path Path to file
     * @param sourceNurse Replaceable nurse
     * @param destNurse Replacing nurse
     * @throws DAOException If file not found
     */
    void editNurse(String path, NurseService sourceNurse, NurseService destNurse) throws DAOException;

}
