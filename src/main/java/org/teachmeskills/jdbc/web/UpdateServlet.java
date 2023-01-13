package org.teachmeskills.jdbc.web;

import org.teachmeskills.jdbc.logic.UpdateLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update", value = "/update")
public class UpdateServlet extends HttpServlet {
    private final UpdateLogic updateLogic = UpdateLogic.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        updateLogic.update(request);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
