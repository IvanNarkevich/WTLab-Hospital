package by.bsuir.wt_lab.servlet;

import by.bsuir.wt_lab.entity.Hospital;
import by.bsuir.wt_lab.parser.DOMHandler;
import by.bsuir.wt_lab.parser.SAXHandler;
import by.bsuir.wt_lab.parser.StAXHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HospitalServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String path = request.getParameter("path");
        String parser = request.getParameter("parser");

        PrintWriter out = response.getWriter();
        Hospital hospital = new Hospital();

        if ("sax".equals(parser)) {
            SAXHandler saxParser = SAXHandler.getInstance(path);
            try {
                hospital = saxParser.getHospital();
            } catch (Exception e) {
                logger.error("SAX parse error", e);
            }
        } else if ("stax".equals(parser)) {
            StAXHandler staxHandler = new StAXHandler();
            try{
                hospital = staxHandler.parse(path);
            }
            catch (Exception e){
                logger.error("StAX parse error", e);
            }
        } else if ("dom".equals(parser)) {
            DOMHandler domHandler = new DOMHandler();
            try{
                hospital = domHandler.parse(path);
            }
            catch (Exception e){
                logger.error("Dom parse error", e);
            }
        }
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("departments", hospital.getDepartments());
        request.setAttribute("doctors", hospital.getDoctors());
        request.setAttribute("nurses", hospital.getNurses());
        request.setAttribute("patients", hospital.getPatients());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
        dispatcher.forward(request,response);
    }
}
