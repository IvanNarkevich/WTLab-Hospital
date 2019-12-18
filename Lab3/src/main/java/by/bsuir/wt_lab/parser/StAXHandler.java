package by.bsuir.wt_lab.parser;

import by.bsuir.wt_lab.entity.*;
import by.bsuir.wt_lab.tagEnum.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class StAXHandler {

    private static final Logger logger = LogManager.getLogger();
    private final static String xmlFile = "src/main/resources/Data.xml";
    private static EntityTag entityTag = EntityTag.NONE;

    public Hospital parse(String path) throws FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        Hospital hospital = new Hospital();
        try {
            InputStream input = new FileInputStream(path);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            hospital = process(reader);

        } catch (XMLStreamException e) {
            logger.error("Ошибка парсинга", e);
        }
        return hospital;
    }

    private static Hospital process(XMLStreamReader reader) throws XMLStreamException {
        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Nurse> nurses = new ArrayList<>();
        ArrayList<Patient> patients = new ArrayList<>();
        Department department = null;
        Doctor doctor = null;
        Nurse nurse = null;
        Patient patient = null;

        Hospital hospital = new Hospital();

        String elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName().toUpperCase();
                    switch (elementName) {
                        case "DEPARTMENT":
                            department = new Department();
                            department.setID(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            entityTag = EntityTag.DEPARTMENT;
                            break;
                        case "DOCTOR":
                            doctor = new Doctor();
                            doctor.setID(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            entityTag = EntityTag.DOCTOR;
                            break;
                        case "NURSE":
                            nurse = new Nurse();
                            nurse.setID(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            entityTag = EntityTag.NURSE;
                            break;
                        case "PATIENT":
                            patient = new Patient();
                            patient.setID(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            entityTag = EntityTag.PATIENT;
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (entityTag) {
                        case DEPARTMENT: {
                            switch (elementName) {
                                case "NAME":
                                    department.setName(text.toString());
                                    break;
                            }
                        }
                        break;
                        case DOCTOR: {
                            switch (elementName) {
                                case "NAME":
                                    doctor.setName(text.toString());
                                    break;
                                case "BIRTHDATE":
                                    doctor.setBirthDate(text.toString());
                                    break;
                                case "DEPARTMENTID":
                                    doctor.setDepartmentID(Integer.parseInt(text.toString()));
                                    break;
                            }
                        }
                        break;
                        case NURSE: {
                            switch (elementName) {
                                case "NAME":
                                    nurse.setName(text.toString());
                                    break;
                                case "BIRTHDATE":
                                    nurse.setBirthDate(text.toString());
                                    break;
                                case "DEPARTMENTID":
                                    nurse.setDepartmentID(Integer.parseInt(text.toString()));
                                    break;
                            }
                            break;
                        }
                        case PATIENT: {
                            switch (elementName) {
                                case "NAME":
                                    patient.setName(text.toString());
                                    break;
                                case "BIRTHDATE":
                                    patient.setBirthDate(text.toString());
                                    break;
                                case "ADMISSIONDATE":
                                    patient.setAdmissionDate(text.toString());
                                    break;
                                case "DIAGNOSIS":
                                    patient.setDiagnosis(text.toString());
                                    break;
                                case "TREATMENT":
                                    patient.setTreatment(text.toString());
                                    break;
                                case "DEPARTMENTID":
                                    patient.setDepartmentID(Integer.parseInt(text.toString()));
                                    break;
                                case "DOCTORID":
                                    patient.setDoctorID(Integer.parseInt(text.toString()));
                                    break;
                            }
                            break;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName().toUpperCase();
                    switch (elementName) {
                        case "DEPARTMENT":
                            departments.add(department);
                            entityTag = EntityTag.NONE;
                            break;
                        case "DOCTOR":
                            doctors.add(doctor);
                            entityTag = EntityTag.NONE;
                            break;
                        case "NURSE":
                            nurses.add(nurse);
                            entityTag = EntityTag.NONE;
                            break;
                        case "PATIENT":
                            patients.add(patient);
                            entityTag = EntityTag.NONE;
                            break;
                    }
            }
        }
        hospital.setDepartments(departments);
        hospital.setDoctors(doctors);
        hospital.setNurses(nurses);
        hospital.setPatients(patients);
        return hospital;
    }
}
