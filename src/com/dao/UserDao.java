package com.dao;

import com.entity.UsersEntity;
import org.omg.CORBA.UserException;

import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/6.
 */
public interface UserDao {
    // register user, insert into database
    public void addUser(UsersEntity user) throws Exception;
    // update user
    public void updateUser(UsersEntity user) throws Exception;
    // delete user by name
    public void deleteUserByName(String username) throws Exception;

    public UsersEntity queryByName(String username) throws Exception;

    public Vector<UsersEntity> queryAll() throws Exception;
}
