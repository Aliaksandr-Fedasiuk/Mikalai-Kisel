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
@WebServlet(description = "Input Person Servlet", urlPatterns = {"/InputPersonServlet", "/InputPersonServlet.do"})
public class InputPersonServlet extends HttpServlet {

    @EJB
    PersonManager personManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/jsps/person/input.jsp").forward(request, response);
    }
}
