package com.service;

import com.dao.UserDao;
import com.entity.UsersEntity;

import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/6.
 */
public class UserService {
    private UserDao dao;

    public void setDao(UserDao d) {
        dao = d;
    }

    public void addUser(UsersEntity user) throws Exception {
        // TODO Auto-generated method stub
        try {
            dao.addUser(user);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateUser(UsersEntity user) throws Exception {
        // TODO Auto-generated method stub
        try {
            dao.updateUser(user);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteUserByName(String username) throws Exception {
        // TODO Auto-generated method stub
        try {
            dao.deleteUserByName(username);
        } catch (Exception e) {
            throw e;
        }
    }

    public UsersEntity queryByName(String username) throws Exception {
        // TODO Auto-generated method stub
        UsersEntity user = null;
        try {
            user = dao.queryByName(username);
        } catch (Exception e) {
            System.out.println("Something is wrong when queryByName");
            throw e;
        }

        return user;
    }

    public Vector<UsersEntity> queryAll() throws Exception {
        // TODO Auto-generated method stub
        Vector<UsersEntity> books = null;
        try {
            books = dao.queryAll();
        } catch (Exception e) {
            throw e;
        }

        return books;
    }
}
