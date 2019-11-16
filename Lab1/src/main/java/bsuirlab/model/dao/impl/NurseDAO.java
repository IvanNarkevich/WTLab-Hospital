package main.java.bsuirlab.model.dao.impl;

import main.java.bsuirlab.model.dao.INurseDAO;
import main.java.bsuirlab.model.service.NurseService;

import java.io.*;
import java.util.ArrayList;

public class NurseDAO implements INurseDAO {
    @Override
    public void addNurse(String path, NurseService nurse) throws DAOException {
        ArrayList<NurseService> list = showNurses(path);
        if (!list.contains(nurse))
        {
            try (FileWriter writer = new FileWriter(path, true)) {
                writer.append(String.valueOf(nurse.getID()));
                writer.append("\r\n");
                writer.append(nurse.getName());
                writer.append("\r\n");
                writer.append(nurse.getBirthDate());
                writer.append("\r\n");
                writer.append(String.valueOf(nurse.getDepartmentID()));
                writer.append("\r\n");
                writer.flush();
            } catch (IOException ex) {
                throw new DAOException(ex);
            }
        }
    }

    @Override
    public ArrayList<NurseService> showNurses(String path) throws DAOException {
        ArrayList<NurseService> list = new ArrayList<>();
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
                NurseService nurse = new NurseService(name, birthDate, departmentID, ID);
                list.add(nurse);
            }
            reader.close();
        } catch (IOException ex) {
            throw new  DAOException(ex);
        }
        return list;
    }

    @Override
    public void deleteNurse(String path, NurseService nurse) throws DAOException {
        ArrayList<NurseService> list = showNurses(path);
        for (NurseService n: list){
            if(n.equals(nurse)){
                list.remove(n);
                break;
            }
        }
        UpdateNurses(path, list);
    }

    @Override
    public void editNurse(String path, NurseService sourceNurse, NurseService destNurse) throws DAOException {
        ArrayList<NurseService> list = showNurses(path);
        for (NurseService n: list){
            if( n.equals(sourceNurse) ){
                list.set(list.indexOf(n), destNurse);
            }
        }
        UpdateNurses(path, list);
    }

    private void UpdateNurses(String path, ArrayList<NurseService> list) throws DAOException {
        try (FileWriter writer = new FileWriter(path, false)) {
            for(NurseService n: list){
                writer.append(String.valueOf(n.getID()));
                writer.append("\r\n");
                writer.append(n.getName());
                writer.append("\r\n");
                writer.append(n.getBirthDate());
                writer.append("\r\n");
                writer.append(String.valueOf(n.getDepartmentID()));
                writer.append("\r\n");
                writer.flush();
            }
        } catch (IOException ex) {
            throw new DAOException(ex);
        }
    }
}
