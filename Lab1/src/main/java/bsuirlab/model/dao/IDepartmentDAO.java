package main.java.bsuirlab.model.dao;

import main.java.bsuirlab.model.dao.impl.DAOException;
import main.java.bsuirlab.model.service.DepartmentService;

import java.util.ArrayList;

public interface IDepartmentDAO {

    /**
     * Add department to file
     * @param path Path to file
     * @param department Department
     * @throws DAOException If file not found
     */
    void addDepartment(String path, DepartmentService department) throws DAOException;

    /**
     * Show information about all departments
     * @param path Path to file
     * @return List of departments
     * @throws DAOException If file not found
     */
    ArrayList<DepartmentService> showDepartments(String path) throws DAOException;

    /**
     * Delete department from file
     * @param path Path to file
     * @param department Department
     * @throws DAOException If file not found
     */
    void deleteDepartment(String path, DepartmentService department) throws DAOException;

    /**
     * Edit information about department
     * @param path Path to file
     * @param sourceDepartment Replaceable department
     * @param destDepartment Replacing department
     * @throws DAOException If file not found
     */
    void editDepartment(String path, DepartmentService sourceDepartment, DepartmentService destDepartment) throws DAOException;

}
