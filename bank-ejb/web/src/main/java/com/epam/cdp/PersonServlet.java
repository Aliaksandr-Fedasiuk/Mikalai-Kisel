package com.epam.cdp;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 23.11.2014
 */
@WebServlet(description = "Persons List Servlet", urlPatterns = {"/PersonServlet", "/PersonServlet.do"})
public class PersonServlet extends HttpServlet {

    @EJB
    PersonManager personManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> persons = personManager.getPersons();
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("WEB-INF/jsps/person/list.jsp").forward(request, response);
    }
}
