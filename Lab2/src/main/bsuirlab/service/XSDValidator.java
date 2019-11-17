package main.bsuirlab.service;

import main.bsuirlab.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidator {

    private static final Logger logger = LogManager.getLogger();

    public static void validate(File XMLFile, File XSDFile) throws ValidationException {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(XSDFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(XMLFile));
            logger.info("Валидация прошла успешно.");
        } catch (IOException e){
            logger.error("Произошла ошибка во время валидации. " + e.getMessage());
            throw new ValidationException("Произошла ошибка во время валидации. " + e.getMessage());
        } catch (SAXException e) {
            logger.error("Ошибка валидации. XML-файл " + XMLFile.getName() + " не является верным: " + e.getMessage());
            throw new ValidationException("XML-файл " + XMLFile.getName() + " не является верным: " + e.getMessage());
        }
    }
}
