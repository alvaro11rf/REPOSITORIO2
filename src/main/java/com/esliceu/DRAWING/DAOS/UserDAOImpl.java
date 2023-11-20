package com.esliceu.DRAWING.DAOS;

import com.esliceu.DRAWING.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static List<User> users = new ArrayList<>();

    @Override
    public User getUserByUserName(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;

    }


    @Override
    public void addUser(User user) {
        if (getUserByUserName(user.getUsername()) == null) {
            if (user.getPassword().length() >= 5) {
                users.add(user);
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public boolean isRegistred(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        ;
        return false;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }
}