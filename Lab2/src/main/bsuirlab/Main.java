package main.bsuirlab;

import main.bsuirlab.exception.DataBaseException;
import main.bsuirlab.exception.ValidationException;
import main.bsuirlab.parser.SAXHandler;
import main.bsuirlab.service.DataBaseManager;
import main.bsuirlab.service.MigrationService;
import main.bsuirlab.service.XSDValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

public class Main {

    private final static String xmlFile = "src/main/resources/Data.xml";
    private final static String xsdFile = "src/main/resources/Schema.xsd";

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws SAXException, IOException {

        logger.info("Запуск приложения...");

        try {
            XSDValidator.validate(new File(xmlFile), new File(xsdFile));
        } catch (ValidationException e) {
            logger.error(e.getMessage());
            return;
        }

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        SAXHandler saxHandler = new SAXHandler();
        xmlReader.setContentHandler(saxHandler);
        xmlReader.parse(new InputSource("src/main/resources/Data.xml"));

        MigrationService migrationService = MigrationService.getInstance();

        Connection connection = null;
        DataBaseManager dbManager = DataBaseManager.getInstance();
        try {
            connection = dbManager.getConnection();
            migrationService.migrateDepartments(connection, saxHandler.getDepartmentList());
            migrationService.migrateDoctors(connection, saxHandler.getDoctorList());
            migrationService.migrateNurses(connection, saxHandler.getNurseList());
            migrationService.migratePatients(connection, saxHandler.getPatientList());
        } catch (DataBaseException e) {
            logger.error(e.getMessage());
        }

    }
}
