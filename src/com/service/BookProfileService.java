package com.service;

import com.dao.BookProfileImp;
import com.mongo.BookMonConnect;
import org.bson.Document;

/**
 * Created by 滩涂上的芦苇 on 2016/6/14.
 */
public class BookProfileService {
    private BookMonConnect mc = null;
    private BookProfileImp dao = null;

    public BookProfileService() throws Exception {
        mc = new BookMonConnect();
        dao = new BookProfileImp(mc.getCollection());
    }

    public Document getBookProfile(String uname) throws Exception {
        // TODO Auto-generated method stub
        Document up = null;
        try {
            up = dao.getBookProfile(uname);
        } catch (Exception e) {
            throw e;
        } finally {
            mc.close();
        }

        return up;
    }

    public void updateBookProfile(String uname, String email) throws Exception {
        // TODO Auto-generated method stub
        try {
            System.out.println("service" + uname);
            dao.updateBookProfile(uname, email);
        } catch (Exception e) {
            throw e;
        } finally {
            //mc.close();
        }
    }

    public void deleteBookProfile(String uname) throws Exception {
        // TODO Auto-generated method stub
        try {
            dao.deleteBookProfile(uname);
        } catch (Exception e) {
            throw e;
        } finally {
            mc.close();
        }
    }

    public void insertBookProfile(String uname) throws Exception {
        // TODO Auto-generated method stub
        try {
            dao.insertBookProfile(uname);
        } catch (Exception e) {
            throw e;
        } finally {
            mc.close();
        }
    }
}
