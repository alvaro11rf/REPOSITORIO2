package com.esliceu.DRAWING.Services;

import com.esliceu.DRAWING.DAOS.UserDAO;
import com.esliceu.DRAWING.DAOS.UserDAOImpl;
import com.esliceu.DRAWING.Model.User;

import java.util.List;

public class UserService {

    UserDAO userDAO = new UserDAOImpl();
    public void addUser(User user){
         userDAO.addUser(user);
    }
    public boolean isRegistred(String username) {
        return userDAO.isRegistred(username);
    }
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    public User getUserByUserName(String username) {
        return userDAO.getUserByUserName(username);
    }

    public boolean authenticateUser(String username, String password) {

        return userDAO.authenticateUser(username,password);
    }
}


