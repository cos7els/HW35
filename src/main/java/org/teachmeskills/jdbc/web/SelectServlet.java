package org.teachmeskills.jdbc.web;

import org.teachmeskills.jdbc.logic.SelectLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "select", value = "/select")
public class SelectServlet extends HttpServlet {
    private final SelectLogic selectLogic = SelectLogic.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clients", selectLogic.select());
        getServletContext().getRequestDispatcher("/select.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("selectid"));
        request.setAttribute("clients", selectLogic.select(id));
        getServletContext().getRequestDispatcher("/select.jsp").forward(request, response);
    }
}