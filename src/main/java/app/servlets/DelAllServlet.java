package app.servlets;

import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/delall.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("answer");
        String result = "";
        if (answer.equals("y") || answer.equals("yes")) {
            result = "OK";
            Model model = Model.getInstance();
            model.delAll();
        }else if (answer.equals("n") || answer.equals("no") || answer.equals("not")) {
            result = "NOK";
        }

        req.setAttribute("userDelAllNames", result);
        doGet(req, resp);
    }
}
