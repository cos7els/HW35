package org.teachmeskills.jdbc.web;

import org.teachmeskills.jdbc.logic.InsertLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "insert", value = "/insert")
public class InsertServlet extends HttpServlet {
    private final InsertLogic insertLogic = InsertLogic.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        insertLogic.insert(request);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
