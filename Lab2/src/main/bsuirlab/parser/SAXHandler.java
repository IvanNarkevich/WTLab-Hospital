package main.bsuirlab.parser;

import main.bsuirlab.entity.*;
import main.bsuirlab.tagEnum.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXHandler extends DefaultHandler {

    private static final Logger logger = LogManager.getLogger();

    private ArrayList<Department> departmentList = new ArrayList<Department>();
    private Department department;

    private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    private Doctor doctor;

    private ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
    private Nurse nurse;

    private ArrayList<Patient> patientList = new ArrayList<Patient>();
    private Patient patient;

    private StringBuilder text;
    private EntityTag entityTag = EntityTag.NONE;

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public ArrayList<Nurse> getNurseList() {
        return nurseList;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    @Override
    public void startDocument() throws SAXException {
        logger.info("Начало парсинга.");
    }

    @Override
    public void endDocument() throws SAXException {
        logger.info("Окончание парсинга.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        text = new StringBuilder();
        EntityTag rootTag = EntityTag.NONE;
        try {
            rootTag = EntityTag.valueOf(qName.toUpperCase());
            entityTag = rootTag;
        } catch (IllegalArgumentException e) {
        }
        switch (rootTag) {
            case DEPARTMENT:
                department = new Department();
                department.setID(Integer.parseInt(attributes.getValue("id")));
                break;
            case DOCTOR:
                doctor = new Doctor();
                doctor.setID(Integer.parseInt(attributes.getValue("id")));
                break;
            case NURSE:
                nurse = new Nurse();
                nurse.setID(Integer.parseInt(attributes.getValue("id")));
                break;
            case PATIENT:
                patient = new Patient();
                patient.setID(Integer.parseInt(attributes.getValue("id")));
                break;
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String qNameUpperCase = qName.toUpperCase();
        switch (entityTag) {
            case DEPARTMENT: {
                DepartmentTag departmentTag = DepartmentTag.NONE;
                try {
                    departmentTag = DepartmentTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                }
                switch (departmentTag) {
                    case NAME:
                        department.setName(text.toString());
                        break;
                    default:
                        departmentList.add(department);
                        department = null;
                        entityTag = EntityTag.NONE;
                        break;
                }
            }
            break;
            case DOCTOR: {
                DoctorTag doctorTag = DoctorTag.NONE;
                try {
                    doctorTag = DoctorTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                }
                switch (doctorTag) {
                    case NAME:
                        doctor.setName(text.toString());
                        break;
                    case BIRTHDATE:
                        doctor.setBirthDate(text.toString());
                        break;
                    case DEPARTMENTID:
                        doctor.setDepartmentID(Integer.parseInt(text.toString()));
                        break;
                    default:
                        doctorList.add(doctor);
                        doctor = null;
                        entityTag = EntityTag.NONE;
                        break;
                }
            }
            break;
            case NURSE: {
                NurseTag nurseTag = NurseTag.NONE;
                try {
                    nurseTag =NurseTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                }
                switch (nurseTag) {
                    case NAME:
                        nurse.setName(text.toString());
                        break;
                    case BIRTHDATE:
                        nurse.setBirthDate(text.toString());
                        break;
                    case DEPARTMENTID:
                        nurse.setDepartmentID(Integer.parseInt(text.toString()));
                        break;
                    default:
                        nurseList.add(nurse);
                        nurse = null;
                        entityTag = EntityTag.NONE;
                        break;
                }
                break;
            }
            case PATIENT: {
                PatientTag patientTag = PatientTag.NONE;
                try {
                    patientTag = PatientTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                }
                switch (patientTag) {
                    case NAME:
                        patient.setName(text.toString());
                        break;
                    case BIRTHDATE:
                        patient.setBirthDate(text.toString());
                        break;
                    case ADMISSIONDATE:
                        patient.setAdmissionDate(text.toString());
                        break;
                    case DIAGNOSIS:
                        patient.setDiagnosis(text.toString());
                        break;
                    case TREATMENT:
                        patient.setTreatment(text.toString());
                        break;
                    case DEPARTMENTID:
                        patient.setDepartmentID(Integer.parseInt(text.toString()));
                        break;
                    case DOCTORID:
                        patient.setDoctorID(Integer.parseInt(text.toString()));
                        break;
                    default:
                        patientList.add(patient);
                        patient = null;
                        entityTag = EntityTag.NONE;
                        break;
                }
                break;
            }
        }
    }
}
