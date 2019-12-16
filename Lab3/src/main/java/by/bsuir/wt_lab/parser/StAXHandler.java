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
            logger.error("Parse error", e);
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

        Hospital hospital = null;

        String elementName = null;
        DepartmentTag departmentTag = DepartmentTag.NONE;
        DoctorTag doctorTag = DoctorTag.NONE;
        NurseTag nurseTag = NurseTag.NONE;
        PatientTag patientTag = PatientTag.NONE;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (entityTag) {
                        case NONE:
                            entityTag = EntityTag.valueOf(reader.getLocalName().toUpperCase());
                            hospital = new Hospital();
                            break;
                        case HOSPITAL:
                            break;
                        case DEPARTMENTS:
                            department = new Department();
                            department.setID(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            break;
                        case DEPARTMENT:
                            departmentTag = DepartmentTag.valueOf(reader.getLocalName().toUpperCase());
                            break;
                        case DOCTORS:
                            doctor = new Doctor();
                            doctor.setID(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            break;
                        case DOCTOR:
                            doctorTag = DoctorTag.valueOf(reader.getLocalName().toUpperCase());
                            break;
                        case NURSES:
                            nurse = new Nurse();
                            nurse.setID(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            break;
                        case NURSE:
                            nurseTag = NurseTag.valueOf(reader.getLocalName().toUpperCase());
                            break;
                        case PATIENTS:
                            patient = new Patient();
                            patient.setID(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            break;
                        case PATIENT:
                            patientTag = PatientTag.valueOf(reader.getLocalName().toUpperCase());
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
                            switch (departmentTag) {
                                case NAME:
                                    department.setName(text.toString());
                                    break;
                            }
                        }
                        break;
                        case DOCTOR: {
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
                            }
                        }
                        break;
                        case NURSE: {
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
                            }
                            break;
                        }
                        case PATIENT: {
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
                            }
                            break;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    try {
                        entityTag = EntityTag.valueOf(reader.getLocalName().toUpperCase());
                    } catch (EnumConstantNotPresentException | IllegalArgumentException e) {
                        continue;
                    }
                    switch (entityTag) {
                        case HOSPITAL:
                        break;
                        case DEPARTMENTS:
                            hospital.setDepartments(departments);
                            //entityTag = EntityTag.NONE;
                            break;
                        case DEPARTMENT:
                            departments.add(department);
                            department = null;
                            departmentTag = DepartmentTag.NONE;
                            break;
                        case DOCTORS:
                            hospital.setDoctors(doctors);
                            //entityTag = EntityTag.NONE;
                            break;
                        case DOCTOR:
                            doctors.add(doctor);
                            doctor = null;
                            doctorTag = DoctorTag.NONE;
                            break;
                        case NURSES:
                            hospital.setNurses(nurses);
                            //entityTag = EntityTag.NONE;
                            break;
                        case NURSE:
                            nurses.add(nurse);
                            nurse = null;
                            nurseTag = NurseTag.NONE;
                            break;
                        case PATIENTS:
                            hospital.setPatients(patients);
                            //entityTag = EntityTag.NONE;
                            break;
                        case PATIENT:
                            patients.add(patient);
                            patient = null;
                            patientTag = PatientTag.NONE;
                            break;
                    }
            }
        }
        return hospital;
    }
}
