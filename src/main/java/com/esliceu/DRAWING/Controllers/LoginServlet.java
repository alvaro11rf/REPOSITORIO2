package com.esliceu.DRAWING.Controllers;
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
@WebServlet("/login")

public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Realiza la autenticación (verifica el nombre de usuario y la contraseña)
        if (userService.authenticateUser(username, password)) {
            // Autenticación exitosa, redirige al usuario a "welcome.jsp"
            response.sendRedirect("/pagina");
            return;
        } else {
            // Autenticación fallida, puedes mostrar un mensaje de error
            // Autenticación fallida, establece un mensaje de error
            request.setAttribute("errorMessage", "Nombre de usuario o contraseña incorrectos");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request,response);
            return;
            // Redirige de nuevo a la página de inicio de sesión con el mensaje de error
            //request.getRequestDispatcher("login.jsp").forward(request, response);
        }


    }




    // Método para verificar la autenticación

}