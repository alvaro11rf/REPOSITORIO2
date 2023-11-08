package com.esliceu.DRAWING.Controllers;
import com.esliceu.DRAWING.DAOS.UserDAO;
import com.esliceu.DRAWING.DAOS.UserDAOImpl;
import com.esliceu.DRAWING.Model.User;
import com.esliceu.DRAWING.Services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/register")

public class RegisterServlet extends HttpServlet {

    UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        dispatcher.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        boolean isRegistred = userService.isRegistred(username);
        if (isRegistred){
            request.setAttribute("errorMessage", "El nombre de usuario ya está registrado.");
            //if password.length <5
        }else {
            if ((new User(username,password,email)).getPassword().length()>=5) {
                userService.addUser(new User(username, password, email));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                dispatcher.forward(request, response);
            }else {
                request.setAttribute("errorMessage", "La contraseña no puede tener menos de 5 caracteres");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        dispatcher.forward(request,response);
        //Crear el metodo para añadir usuario
    }


}