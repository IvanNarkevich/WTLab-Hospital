package main.java.bsuirlab.model.dao.impl;

import main.java.bsuirlab.model.dao.IDepartmentDAO;
import main.java.bsuirlab.model.service.DepartmentService;

import java.io.*;
import java.util.ArrayList;

public class DepartmentDAO implements IDepartmentDAO {
    @Override
    public void addDepartment(String path, DepartmentService department) throws DAOException {
        ArrayList<DepartmentService> list = showDepartments(path);
        if (!list.contains(department))
        {
            try (FileWriter writer = new FileWriter(path, true)) {
                writer.append(String.valueOf(department.getID()));
                writer.append("\r\n");
                writer.append(department.getName());
                writer.append("\r\n");
                writer.flush();
            } catch (IOException ex) {
                throw new DAOException(ex);
            }
        }
    }

    @Override
    public ArrayList<DepartmentService> showDepartments(String path) throws DAOException {
        ArrayList<DepartmentService> list = new ArrayList<>();
        String name;
        int ID;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            while ((ID = Integer.parseInt(reader.readLine())) != 0) {
                name = reader.readLine();
                DepartmentService department = new DepartmentService(name, ID);
                list.add(department);
            }
            reader.close();
        } catch (IOException ex) {
            throw new  DAOException(ex);
        }
        return list;
    }

    @Override
    public void deleteDepartment(String path, DepartmentService department) throws DAOException {
        ArrayList<DepartmentService> list = showDepartments(path);
        for (DepartmentService d: list){
            if(d.equals(department)){
                list.remove(d);
                break;
            }
        }
        UpdateDepartments(path, list);
    }

    @Override
    public void editDepartment(String path, DepartmentService sourceDepartment, DepartmentService destDepartment) throws DAOException {
        ArrayList<DepartmentService> list = showDepartments(path);
        for (DepartmentService d: list){
            if( d.equals(sourceDepartment) ){
                list.set(list.indexOf(d), destDepartment);
            }
        }
        UpdateDepartments(path, list);
    }

    private void UpdateDepartments(String path, ArrayList<DepartmentService> list) throws DAOException {
        try (FileWriter writer = new FileWriter(path, false)) {
            for(DepartmentService d: list){
                writer.append(String.valueOf(d.getID()));
                writer.append("\r\n");
                writer.append(d.getName());
                writer.append("\r\n");
                writer.flush();
            }
        } catch (IOException ex) {
            throw new DAOException(ex);
        }
    }
}
