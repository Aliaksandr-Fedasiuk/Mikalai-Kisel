package com.epam.cdp.cinema.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 11 Feb, 2015
 */
@WebServlet(description = "Input User Servlet", urlPatterns = {"/InputServlet", "/InputServlet.do"})
public class InputServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/jsps/input.jsp").forward(
                request, response);
    }

}
