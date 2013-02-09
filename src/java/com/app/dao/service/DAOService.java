
package com.app.dao.service;

import com.app.dao.UserDAO;
import com.app.dao.UserDAOImpl;

public class DAOService {
    private static UserDAO userDAO = new UserDAOImpl();
    public static UserDAO getUserDAO(){
        return userDAO;
    }
}
