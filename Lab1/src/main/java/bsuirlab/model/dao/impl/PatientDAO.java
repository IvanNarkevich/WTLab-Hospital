package main.java.bsuirlab.model.dao.impl;

import main.java.bsuirlab.model.dao.IPatientDAO;
import main.java.bsuirlab.model.service.PatientService;

import java.io.*;
import java.util.ArrayList;

public class PatientDAO implements IPatientDAO {
    @Override
    public void addPatient(String path, PatientService patient) throws DAOException {
        ArrayList<PatientService> list = showPatients(path);
        if (!list.contains(patient))
        {
            try (FileWriter writer = new FileWriter(path, true)) {
                writer.append(String.valueOf(patient.getID()));
                writer.append("\r\n");
                writer.append(patient.getName());
                writer.append("\r\n");
                writer.append(patient.getBirthDate());
                writer.append("\r\n");
                writer.append(patient.getAdmissionDate());
                writer.append("\r\n");
                writer.append(patient.getDiagnosis());
                writer.append("\r\n");
                writer.append(patient.getTreatment());
                writer.append("\r\n");
                writer.append(String.valueOf(patient.getDepartmentID()));
                writer.append("\r\n");
                writer.append(String.valueOf(patient.getDoctorID()));
                writer.append("\r\n");
                writer.flush();
            } catch (IOException ex) {
                throw new DAOException(ex);
            }
        }
    }

    @Override
    public ArrayList<PatientService> showPatients(String path) throws DAOException {
        ArrayList<PatientService> list = new ArrayList<>();
        String name, birthDate, admissionDate, diagnosis, treatment;
        int ID, departmentID, doctorID;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            while ((ID = Integer.parseInt(reader.readLine())) != 0) {
                name = reader.readLine();
                birthDate = reader.readLine();
                admissionDate = reader.readLine();
                diagnosis = reader.readLine();
                treatment = reader.readLine();
                departmentID = Integer.parseInt(reader.readLine());
                doctorID = Integer.parseInt(reader.readLine());
                PatientService patient = new PatientService(name, birthDate, admissionDate, diagnosis, treatment, departmentID, doctorID,  ID);
                list.add(patient);
            }
            reader.close();
        } catch (IOException ex) {
            throw new  DAOException(ex);
        }
        return list;
    }

    @Override
    public void deletePatient(String path, PatientService patient) throws DAOException {
        ArrayList<PatientService> list = showPatients(path);
        for (PatientService p: list){
            if(p.equals(patient)){
                list.remove(p);
                break;
            }
        }
        UpdatePatients(path, list);
    }

    @Override
    public void editPatient(String path, PatientService sourcePatient, PatientService destPatient) throws DAOException {
        ArrayList<PatientService> list = showPatients(path);
        for (PatientService p: list){
            if( p.equals(sourcePatient) ){
                list.set(list.indexOf(p), destPatient);
            }
        }
        UpdatePatients(path, list);
    }

    private void UpdatePatients(String path, ArrayList<PatientService> list) throws DAOException {
        try (FileWriter writer = new FileWriter(path, false)) {
            for(PatientService p: list){
                writer.append(String.valueOf(p.getID()));
                writer.append("\r\n");
                writer.append(p.getName());
                writer.append("\r\n");
                writer.append(p.getBirthDate());
                writer.append("\r\n");
                writer.append(p.getAdmissionDate());
                writer.append("\r\n");
                writer.append(p.getDiagnosis());
                writer.append("\r\n");
                writer.append(p.getTreatment());
                writer.append("\r\n");
                writer.append(String.valueOf(p.getDepartmentID()));
                writer.append("\r\n");
                writer.append(String.valueOf(p.getDoctorID()));
                writer.append("\r\n");
                writer.flush();
            }
        } catch (IOException ex) {
            throw new DAOException(ex);
        }
    }
}
