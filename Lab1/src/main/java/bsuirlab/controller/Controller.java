package main.java.bsuirlab.controller;

import main.java.bsuirlab.model.service.*;
import main.java.bsuirlab.view.View;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private View view = new View();

    private HospitalService hospital = HospitalService.getHospital();

    public void choiceController(){
        Scanner userKey = new Scanner(System.in);
        view.showChoice();
        int choice;
        try {
            choice = Integer.parseInt(userKey.nextLine()) ;
        }catch (NumberFormatException e) {
            choice = 0;
        }
        while (choice != 0){
            switch (choice){
                case 1:
                    ArrayList<DepartmentService> list1 = hospital.getDepartments();
                    view.showDepartmentName();
                    try {
                        String departmentName = userKey.nextLine();
                        if (departmentName.trim().isEmpty()){
                            throw new NullStringException();
                        }else{
                            DepartmentService department = new DepartmentService(departmentName, hospital.getNewDepartmentID());
                            list1.add(department);
                            hospital.setDepartments(list1);
                        }
                    }
                    catch (NullStringException e)
                    {
                        view.showExceptionInfo(e.getMessage().toString());
                    }
                    break;
                case 2:
                    try {
                        ArrayList<DepartmentService> list2 = hospital.getDepartments();
                        if (list2.size() > 0)
                            view.showDepartmentList(list2);
                        else
                            view.showNullList();
                    }
                    catch (Exception e)
                    {
                        view.showExceptionInfo(e.getMessage().toString());
                    }
                    break;
                case 3:
                    ArrayList<DoctorService> list3 = hospital.getDoctors();
                    String doctorName;
                    String birthDate;
                    int departmentID;
                    try {
                        view.showName();
                        doctorName = userKey.nextLine();
                        if (doctorName.trim().isEmpty()) {
                            throw new NullStringException();
                        }
                        view.showBirthDate();
                        birthDate = userKey.nextLine();
                        if (birthDate.trim().isEmpty()) {
                            throw new NullStringException();
                        }
                        view.showDepartmentID();
                        departmentID = Integer.parseInt(userKey.next());
                        if (!hospital.validateDepartmentID(departmentID))
                            throw new WrongIDException();
                        DoctorService doctor = new DoctorService(doctorName, birthDate, departmentID, hospital.getNewDoctorID());
                        list3.add(doctor);
                        hospital.setDoctors(list3);
                    }catch (NullStringException e){
                        view.showExceptionInfo(e.getMessage().toString());
                    }catch (WrongIDException e) {
                        view.showExceptionInfo(e.getMessage().toString());
                    }catch (NumberFormatException e){
                        view.showExceptionInfo(e.getMessage().toString());
                    }
                    break;
                case 4:
                    try {
                        ArrayList<DoctorService> list4 = hospital.getDoctors();
                        if (list4.size() > 0)
                            view.showDoctorList(list4);
                        else
                            view.showNullList();
                    }
                    catch (Exception e)
                    {
                        view.showExceptionInfo(e.getMessage().toString());
                    }
                    break;
                case 5:
                    ArrayList<NurseService> list5 = hospital.getNurses();
                    String nurseName;
                    try{
                        view.showName();
                        nurseName = userKey.nextLine();
                        if (nurseName.trim().isEmpty()){
                            throw new NullStringException();
                        }
                        view.showBirthDate();
                        birthDate = userKey.nextLine();
                        if(birthDate.trim().isEmpty()){
                            throw new NullStringException();
                        }
                        view.showDepartmentID();
                        departmentID = Integer.parseInt(userKey.next());
                        if (!hospital.validateDepartmentID(departmentID)){
                            throw new WrongIDException();
                        }
                        NurseService nurse = new NurseService(nurseName, birthDate, departmentID, hospital.getNewNurseID());
                        list5.add(nurse);
                        hospital.setNurses(list5);
                    }
                    catch (NullStringException e)
                    {
                        view.showExceptionInfo(e.getMessage().toString());
                    }catch (WrongIDException e) {
                        view.showExceptionInfo(e.getMessage().toString());
                    }catch (NumberFormatException e){
                        view.showExceptionInfo(e.getMessage().toString());
                    }
                    break;
                case 6:
                    try {
                        ArrayList<NurseService> list = hospital.getNurses();
                        if (list.size() > 0)
                            view.showNurseList(list);
                        else
                            view.showNullList();
                    }
                    catch (Exception e)
                    {
                        view.showExceptionInfo(e.getMessage().toString());
                    }
                    break;
                case 7:
                    ArrayList<PatientService> list7 = hospital.getPatients();
                    String patientName;
                    String admissionDate;
                    String diagnosis;
                    String treatment;
                    int doctorID;
                    try{
                        view.showName();
                        patientName = userKey.nextLine();
                        if(patientName.trim().isEmpty()){
                            throw new NullStringException();
                        }
                        view.showBirthDate();
                        birthDate = userKey.nextLine();
                        if(birthDate.trim().isEmpty()){
                            throw new NullStringException();
                        }
                        view.showAdmissionDate();
                        admissionDate = userKey.nextLine();
                        if(admissionDate.trim().isEmpty()){
                            throw new NullStringException();
                        }
                        view.showDepartmentID();
                        departmentID = Integer.parseInt(userKey.next());
                        if (!hospital.validateDepartmentID(departmentID)){
                            throw new WrongIDException();
                        }
                        doctorID = Integer.parseInt(userKey.next());
                        if (!hospital.validateDoctorID(doctorID)){
                            throw new WrongIDException();
                        }
                        ArrayList<DoctorService> list = hospital.getDoctors();
                        for(DoctorService d: list){
                            if (d.getID() == doctorID){
                                if (d.getDepartmentID() != departmentID){
                                    throw new DepartmentAndDoctorMismatchException();
                                }
                                break;
                            }
                        }
                        view.showDiagnosis();
                        diagnosis = userKey.nextLine();
                        if (diagnosis.trim().isEmpty()){
                            throw new NullStringException();
                        }
                        view.showTreatment();
                        treatment = userKey.nextLine();
                        if (treatment.trim().isEmpty()){
                            throw new NullStringException();
                        }
                        PatientService patient = new PatientService(patientName, birthDate, admissionDate, diagnosis, treatment, departmentID, doctorID, hospital.getNewPatientID());
                        list7.add(patient);
                        hospital.setPatients(list7);
                    }
                    catch (NullStringException e){
                        view.showExceptionInfo(e.getMessage().toString());
                    }catch (WrongIDException e) {
                        view.showExceptionInfo(e.getMessage().toString());
                    }catch (DepartmentAndDoctorMismatchException e){
                        view.showExceptionInfo(e.getMessage().toString());
                    }catch (NumberFormatException e){
                        view.showExceptionInfo(e.getMessage().toString());
                    }
                    break;
                case 8:
                    try {
                        ArrayList<PatientService> list8 = hospital.getPatients();
                        if (list8.size() > 0)
                            view.showPatientList(list8);
                        else
                            view.showNullList();
                    }
                    catch (Exception e)
                    {
                        view.showExceptionInfo(e.getMessage().toString());
                    }
                    break;
                case 9:
                    int patientID;
                    try{
                        view.showPatientID();
                        patientID = Integer.parseInt(userKey.nextLine());
                        if (!hospital.validatePatientID(patientID)){
                            throw new WrongIDException();
                        }
                        ArrayList<PatientService> list9 = hospital.getPatients();
                        for (PatientService p: list9){
                            if (p.getID() == patientID){
                                list9.remove(p);
                            }
                        }
                        hospital.setPatients(list9);
                    }catch(WrongIDException e){
                        view.showExceptionInfo(e.getMessage().toString());
                    }catch(NumberFormatException e){
                        view.showExceptionInfo(e.getMessage().toString());
                    }
                    break;
            }
            view.showChoice();
            try {
                choice = Integer.parseInt(userKey.nextLine()) ;
            }catch (NumberFormatException e) {
                choice = 0;
            }
        }
    }
}

