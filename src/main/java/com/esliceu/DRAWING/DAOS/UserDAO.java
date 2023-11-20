package com.esliceu.DRAWING.DAOS;

import com.esliceu.DRAWING.Model.User;

import java.util.List;

public interface UserDAO {
    User getUserByUserName(String username);
    void addUser(User user);
    List<User> getAllUsers();

    boolean isRegistred(String username);

    boolean authenticateUser(String username, String password);
}
