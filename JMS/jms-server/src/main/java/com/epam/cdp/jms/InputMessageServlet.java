package com.epam.cdp.jms;

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
 * @since 29 Jan, 2015
 */
@WebServlet(description = "Input Message Servlet", urlPatterns = {"/InputMessageServlet", "/InputMessageServlet.do"})
public class InputMessageServlet extends HttpServlet {

    private static final long serialVersionUID = -5792353423192865715L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/jsps/message/input.jsp").forward(request, response);
    }
}
