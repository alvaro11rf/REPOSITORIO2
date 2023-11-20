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
@WebServlet("/viewDrawing")
public class ViewDrawingServlet extends HttpServlet {
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
        String drawingId = request.getParameter("drawingId");
        System.out.println(drawingId);
        if (drawingId != null) {
            Draw drawingDetails = drawService.getDrawingDetailsById(Integer.parseInt(drawingId));
            request.setAttribute("draw", drawingDetails);
            String drawing = request.getParameter("shapesJSON");
            request.setAttribute("draw",drawing);


            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewDrawing.jsp");
            dispatcher.forward(request, response);
        } else {
            // Manejo de caso en el que no se proporciona un ID de dibujo válido
            response.sendRedirect("/allDrawings"); // Puedes redirigir a otra página o manejarlo de acuerdo a tus necesidades

        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewDrawing.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewDrawing.jsp");

        dispatcher.forward(request,response);

    }
}
