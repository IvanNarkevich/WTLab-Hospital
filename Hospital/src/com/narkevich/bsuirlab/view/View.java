package com.narkevich.bsuirlab.view;

import com.narkevich.bsuirlab.model.service.DepartmentService;
import com.narkevich.bsuirlab.model.service.DoctorService;
import com.narkevich.bsuirlab.model.service.NurseService;
import com.narkevich.bsuirlab.model.service.PatientService;

import javax.print.Doc;
import java.util.ArrayList;

public class View {

    public void showHospitalEnter(){
        System.out.println("Введите информацию о больнице");
    }

    public void showCountry(){
        System.out.println("Введите страну");
    }

    public void showCity(){
        System.out.println("Введите город");
    }

    public void showAddress(){
        System.out.println("Введите адрес");
    }

    public void showHospitalName(){
        System.out.println("Введите название");
    }

    public void showChoice(){
        System.out.println("Нажмите 1, чтобы добавить отделение");
        System.out.println("Нажмите 2, чтобы просмотреть список отделений");
        System.out.println("Нажмите 3, чтобы добавить врача в отделение");
        System.out.println("Нажмите 4, чтобы просмотреть список врачей");
        System.out.println("Нажмите 5, чтобы добавить медсестру в отделение");
        System.out.println("Нажмите 6, чтобы просмотреть список медсестёр");
        System.out.println("Нажмите 7, чтобы добавить пациента в отделение");
        System.out.println("Нажмите 8, чтобы просмотреть список пациентов");
        System.out.println("Нажмите 9, чтобы выписать пациента");
        System.out.println("Нажмите 0, чтобы выйти");
    }

    public void showExceptionInfo(){
        System.out.println("Введите корректные данные");
    }

    public void showWrongIDExceptionInfo(){
        System.out.println("Введите существующий ID");
    }

    public void showUnknownException(){
        System.out.println("Список не может быть показан");
    }

    public void showDepartmentAndDoctorMismatch(){
        System.out.println("Выбранный врач работает в другом отделении");
    }

    public void showAdmissionDate(){
        System.out.println("Введите дату поступления");
    }

    public void showDiagnosis(){
        System.out.println("Введите диагноз");
    }

    public void showTreatment(){
        System.out.println("Введите лечение");
    }

    public void showDepartmentList(ArrayList<DepartmentService> list){
        for (DepartmentService d: list){
            System.out.printf("ID: %s  Название: %s  \n", d.getID(), d.getName());
        }
    }

    public void showDepartmentName(){
        System.out.println("Введите имя отделения");
    }

    public void showDoctorList(ArrayList<DoctorService> list){
        for (DoctorService d: list){
            System.out.printf("ID: %s  Имя: %s  ID отделения: %s\n", d.getID(), d.getName(), d.getDepartmentID());
        }
    }

    public void showNurseList(ArrayList<NurseService> list){
        for (NurseService n: list){
            System.out.printf("ID: %s  Имя: %s  ID отделения: %s\n", n.getID(), n.getName(), n.getDepartmentID());
        }
    }

    public void showPatientList(ArrayList<PatientService> list){
        for (PatientService p: list){
            System.out.printf("ID: %s  Имя: %s Дата поступления: : %s ID отделения: %s ID врача: %s Диагноз: %s Лечение: %s\n", p.getID(), p.getName(), p.getAdmissionDate(), p.getDepartmentID(), p.getDoctorID(), p.getDiagnosis(), p.getTreatment());
        }
    }


    public void showName(){
        System.out.println("Введите имя");
    }

    public void showBirthDate(){
        System.out.println("Введите дату рождения в виде ДД.ММ.ГГГГ");
    }

    public void showDepartmentID(){
        System.out.println("Введите ID существующего отделения");
    }

    public void showPatientID(){
        System.out.println("Введите ID выписываемого пациента");
    }

    public void showNullList(){
        System.out.println("Список пуст");
    }
}
