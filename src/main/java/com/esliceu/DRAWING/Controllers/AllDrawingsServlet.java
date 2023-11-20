package com.esliceu.DRAWING.Controllers;
import com.esliceu.DRAWING.Model.Draw;
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
import java.util.List;

@WebServlet("/allDrawings")

public class AllDrawingsServlet extends HttpServlet{
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
        List<Draw> list = drawService.all();
        System.out.println(list.size());
        request.setAttribute("list",list);

            // Si no hay viewDrawingId, muestra la lista de dibujos
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/allDrawings.jsp");
            dispatcher.forward(request,response);
        }







    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String drawing = request.getParameter("shapesJSON");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        drawService.saveDrawing(drawing, user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/allDrawings.jsp");

        dispatcher.forward(request,response);

    }

}
