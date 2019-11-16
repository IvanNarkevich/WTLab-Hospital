package main.java.bsuirlab.model.dao.impl;

import main.java.bsuirlab.model.dao.IDoctorDAO;
import main.java.bsuirlab.model.service.DoctorService;

import java.io.*;
import java.util.ArrayList;

public class DoctorDAO implements IDoctorDAO {
    @Override
    public void addDoctor(String path, DoctorService doctor) throws DAOException {
        ArrayList<DoctorService> list = showDoctors(path);
        if (!list.contains(doctor))
        {
            try (FileWriter writer = new FileWriter(path, true)) {
                writer.append(String.valueOf(doctor.getID()));
                writer.append("\r\n");
                writer.append(doctor.getName());
                writer.append("\r\n");
                writer.append(doctor.getBirthDate());
                writer.append("\r\n");
                writer.append(String.valueOf(doctor.getDepartmentID()));
                writer.append("\r\n");
                writer.flush();
            } catch (IOException ex) {
                throw new DAOException(ex);
            }
        }
    }

    @Override
    public ArrayList<DoctorService> showDoctors(String path) throws DAOException {
        ArrayList<DoctorService> list = new ArrayList<>();
        String name, birthDate;
        int ID, departmentID;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            while ((ID = Integer.parseInt(reader.readLine())) != 0) {
                name = reader.readLine();
                birthDate = reader.readLine();
                departmentID = Integer.parseInt(reader.readLine());
                DoctorService doctor = new DoctorService(name, birthDate, departmentID, ID);
                list.add(doctor);
            }
            reader.close();
        } catch (IOException ex) {
            throw new  DAOException(ex);
        }
        return list;
    }

    @Override
    public void deleteDoctor(String path, DoctorService doctor) throws DAOException {
        ArrayList<DoctorService> list = showDoctors(path);
        for (DoctorService d: list){
            if(d.equals(doctor)){
                list.remove(d);
                break;
            }
        }
        UpdateDoctors(path, list);
    }

    @Override
    public void editDoctor(String path, DoctorService sourceDoctor, DoctorService destDoctor) throws DAOException {
        ArrayList<DoctorService> list = showDoctors(path);
        for (DoctorService d: list){
            if( d.equals(sourceDoctor) ){
                list.set(list.indexOf(d), destDoctor);
            }
        }
        UpdateDoctors(path, list);
    }

    private void UpdateDoctors(String path, ArrayList<DoctorService> list) throws DAOException {
        try (FileWriter writer = new FileWriter(path, false)) {
            for(DoctorService d: list){
                writer.append(String.valueOf(d.getID()));
                writer.append("\r\n");
                writer.append(d.getName());
                writer.append("\r\n");
                writer.append(d.getBirthDate());
                writer.append("\r\n");
                writer.append(String.valueOf(d.getDepartmentID()));
                writer.append("\r\n");
                writer.flush();
            }
        } catch (IOException ex) {
            throw new DAOException(ex);
        }
    }
}
