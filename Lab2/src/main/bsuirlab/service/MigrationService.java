package main.bsuirlab.service;

import main.bsuirlab.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.bsuirlab.exception.AlreadyExistsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MigrationService {

    private static final Logger logger = LogManager.getLogger();
    private static MigrationService instance = null;

    private MigrationService() {
    }

    public static MigrationService getInstance() {
        if (instance == null) {
            instance = new MigrationService();
            logger.info("Получение экземпляра сервиса миграции");
        }
        return instance;
    }

    private boolean isIdExist(Connection connection, String tableName, int id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        statement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE id = ?;");
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        return resultSet.first();
    }


    public void migrateDepartments(Connection connection, ArrayList<Department> departmentList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        for (Department department : departmentList) {
            try {
                if (isIdExist(connection, "departments", department.getID()))
                    throw new AlreadyExistsException("Entity with id=" + department.getID() + " is already exists at table departments.");
                statement = connection.prepareStatement(
                        "INSERT INTO departments (id, name) VALUES (?,?);");
                statement.setInt(1, department.getID());
                statement.setString(2, department.getName());
                statement.executeUpdate();

            } catch (SQLException | AlreadyExistsException e) {
                logger.error(e.getMessage());
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (statement != null)
                        statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    public void migrateDoctors(Connection connection, ArrayList<Doctor> doctorList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        for (Doctor doctor : doctorList) {
            try {
                if (isIdExist(connection, "doctors", doctor.getID()))
                    throw new AlreadyExistsException("Entity with id=" + doctor.getID() + " is already exists at table doctors.");
                statement = connection.prepareStatement(
                        "INSERT INTO doctors (id, name, birthdate, departmentID) VALUES (?,?,?,?);");
                statement.setInt(1, doctor.getID());
                statement.setString(2, doctor.getName());
                statement.setString(3, doctor.getBirthDate());
                statement.setInt(4, doctor.getDepartmentID());
                statement.executeUpdate();

            } catch (SQLException | AlreadyExistsException e) {
                logger.error(e.getMessage());
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (statement != null)
                        statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    public void migrateNurses(Connection connection, ArrayList<Nurse> nurseList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        for (Nurse nurse : nurseList) {
            try {
                if (isIdExist(connection, "nurses", nurse.getID()))
                    throw new AlreadyExistsException("Entity with id=" + nurse.getID() + " is already exists at table nurses.");
                statement = connection.prepareStatement(
                        "INSERT INTO nurses (id, name, birthdate, departmentID) VALUES (?,?,?,?);");
                statement.setInt(1, nurse.getID());
                statement.setString(2, nurse.getName());
                statement.setString(3, nurse.getBirthDate());
                statement.setInt(4, nurse.getDepartmentID());
                statement.executeUpdate();

            } catch (SQLException | AlreadyExistsException e) {
                logger.error(e.getMessage());
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (statement != null)
                        statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    public void migratePatients(Connection connection, ArrayList<Patient> patientList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        for (Patient patient : patientList) {
            try {
                if (isIdExist(connection, "patients", patient.getID()))
                    throw new AlreadyExistsException("Entity with id=" + patient.getID() + " is already exists at table patients.");
                statement = connection.prepareStatement(
                        "INSERT INTO patients (id, name, birthdate, admissiondate, diagnosis, treatment, departmentID, doctorID) VALUES (?,?,?,?,?,?,?,?);");
                statement.setInt(1, patient.getID());
                statement.setString(2, patient.getName());
                statement.setString(3, patient.getBirthDate());
                statement.setString(4, patient.getAdmissionDate());
                statement.setString(5, patient.getDiagnosis());
                statement.setString(6, patient.getTreatment());
                statement.setInt(7, patient.getDepartmentID());
                statement.setInt(8, patient.getDoctorID());
                statement.executeUpdate();

            } catch (SQLException | AlreadyExistsException e) {
                logger.error(e.getMessage());
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (statement != null)
                        statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
