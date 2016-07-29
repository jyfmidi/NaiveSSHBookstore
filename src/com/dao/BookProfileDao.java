package com.dao;

import org.bson.Document;

/**
 * Created by 滩涂上的芦苇 on 2016/6/14.
 */
public interface BookProfileDao {
    public static final String BOOKID = "bookid";
    public static final String PROFILE = "profile";

    public Document getBookProfile(String isbn) throws Exception;

    public void updateBookProfile(String isbn, String profile) throws Exception;

    public void deleteBookProfile(String isbn) throws Exception;

    public void insertBookProfile(String isbn) throws Exception;
}
