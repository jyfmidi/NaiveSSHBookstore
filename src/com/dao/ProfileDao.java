package com.dao;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * Created by 滩涂上的芦苇 on 2016/6/12.
 */
public interface ProfileDao {
    public static final String USERNAME = "uname";
    public static final String EMAIL = "email";
    public static final String QQ = "qq";
    public static final String TEL = "tel";

    public Document getUserProfile(String uname) throws Exception;

    public void updateUserEmail(String uname, String email) throws Exception;

    public void updateUserQQ(String uname, String qq) throws Exception;

    public void updateUserTel(String uname, String tel) throws Exception;

    public void deleteUserProfile(String uname) throws Exception;

    public void insertUserProfile(String uname) throws Exception;
}
