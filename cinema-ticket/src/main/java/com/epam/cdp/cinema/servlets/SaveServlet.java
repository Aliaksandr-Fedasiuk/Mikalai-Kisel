package com.epam.cdp.cinema.servlets;

import com.epam.cdp.cinema.service.TicketService;

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
@WebServlet(description = "Save User Servlet", urlPatterns = {"/SaveServlet", "/SaveServlet.do"})
public class SaveServlet extends HttpServlet {
    private TicketService ticketService = new TicketService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Integer place = Integer.valueOf(request.getParameter("place"));
        Long userId = ticketService.registerUser(name, password);
        ticketService.buyTickets(userId, place);
        request.getRequestDispatcher("/InputServlet.do").forward(request, response);
    }
}
