package org.teachmeskills.jdbc.web;

import org.teachmeskills.jdbc.db.Delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "delete", value = "/delete")
public class DeleteServlet extends HttpServlet {
    private final Delete delete = Delete.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        delete.delete();
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleid = request.getParameter("deleteid");
        if (!deleid.equals("")) {
            int id = Integer.parseInt(deleid);
            delete.delete(id);
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
