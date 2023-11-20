package com.esliceu.DRAWING.Controllers;

import com.esliceu.DRAWING.Model.User;
import com.esliceu.DRAWING.Services.DrawService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/pagina")


public class PaginaServlet  extends HttpServlet {

    DrawService drawService = new DrawService();
    User user = new User();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendRedirect("/login");
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pagina.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String draw = request.getParameter("draw");
        System.out.println(draw);
        String drawing = request.getParameter("shapesJSON");
        drawService.saveDrawing(drawing, user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/allDrawings.jsp");

        dispatcher.forward(request,response);

    }
}
