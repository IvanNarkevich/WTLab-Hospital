package by.bsuir.wt_lab.parser;

import by.bsuir.wt_lab.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMHandler {

    private static final Logger logger = LogManager.getLogger();
    private final static String xmlFile = "src/main/resources/Data.xml";

    private ArrayList<Department> departments = new ArrayList<Department>();

    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();

    private ArrayList<Nurse> nurses = new ArrayList<Nurse>();

    private ArrayList<Patient> patients = new ArrayList<Patient>();

    private Hospital hospital = new Hospital();

    private static String getTextContent(Node parentNode,String childName)
    {
        NodeList nlist = parentNode.getChildNodes();
        for (int i = 0 ; i < nlist.getLength() ; i++) {
            Node n = nlist.item(i);
            String name = n.getNodeName();
            if ( name != null && name.equals(childName) )
                return n.getTextContent();
        }
        return "";
    }

    public Hospital parse(String path) throws IOException {
        Department department;
        Doctor doctor;
        Nurse nurse;
        Patient patient;

        try
        {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            logger.info("Начало парсинга");
            NodeList nDepartments = doc.getElementsByTagName("department");
            for (int i = 0; i < nDepartments.getLength(); i++) {
                Element node = (Element)nDepartments.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    department = new Department();
                    department.setName(getTextContent(node, "name"));
                    department.setID(Integer.parseInt(node.getAttribute("id")));
                    departments.add(department);
                    department = null;
                }
            }
            logger.info("Парсинг отделений " + departments.size());

            NodeList nDoctors = doc.getElementsByTagName("doctor");
            for (int i = 0; i < nDoctors.getLength(); i++) {
                Element node = (Element)nDoctors.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    doctor = new Doctor();
                    doctor.setID(Integer.parseInt(node.getAttribute("id")));
                    doctor.setName(getTextContent(node, "name"));
                    doctor.setBirthDate(getTextContent(node, "birthdate"));
                    doctor.setDepartmentID(Integer.parseInt(getTextContent(node, "departmentID")));
                    doctors.add(doctor);
                    doctor = null;
                }
            }
            logger.info("Парсинг докторов " + doctors.size());

            NodeList nNurses = doc.getElementsByTagName("nurse");
            for (int i = 0; i < nNurses.getLength(); i++) {
                Element node = (Element)nNurses.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    nurse = new Nurse();
                    nurse.setID(Integer.parseInt(node.getAttribute("id")));
                    nurse.setName(getTextContent(node, "name"));
                    nurse.setBirthDate(getTextContent(node, "birthdate"));
                    nurse.setDepartmentID(Integer.parseInt(getTextContent(node, "departmentID")));
                    nurses.add(nurse);
                    nurse = null;
                }
            }
            logger.info("Парсинг медсестёр " + nurses.size());

            NodeList nPatients = doc.getElementsByTagName("patient");
            for (int i = 0; i < nPatients.getLength(); i++) {
                Element node = (Element)nPatients.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    patient = new Patient();
                    patient.setID(Integer.parseInt(node.getAttribute("id")));
                    patient.setName(getTextContent(node, "name"));
                    patient.setBirthDate(getTextContent(node, "birthdate"));
                    patient.setAdmissionDate(getTextContent(node, "admissiondate"));
                    patient.setDiagnosis(getTextContent(node, "diagnosis"));
                    patient.setTreatment(getTextContent(node, "treatment"));
                    patient.setDoctorID(Integer.parseInt(getTextContent(node, "doctorID")));
                    patient.setDepartmentID(Integer.parseInt(getTextContent(node, "departmentID")));
                    patients.add(patient);
                    doctor = null;
                }
            }
            logger.info("Парсинг пациентов " + patients.size());

            hospital.setDepartments(departments);
            hospital.setDoctors(doctors);
            hospital.setNurses(nurses);
            hospital.setPatients(patients);
        } catch (Exception e) {
            logger.error("Parse error", e);
        }
        return hospital;
    }
}
