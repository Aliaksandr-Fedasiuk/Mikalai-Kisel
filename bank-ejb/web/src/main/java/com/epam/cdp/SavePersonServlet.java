package com.epam.cdp;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kisel.nikolay@gmail.com
 * @since 23.11.2014
 */
@WebServlet(description = "Save Person Servlet", urlPatterns = {"/SavePersonServlet", "/SavePersonServlet.do"})
public class SavePersonServlet extends HttpServlet {

    @EJB
    PersonManager personManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        final Person person = new Person(name, surname);
        personManager.savePerson(person);
        request.getRequestDispatcher("/PersonServlet.do").forward(request, response);
    }


}
