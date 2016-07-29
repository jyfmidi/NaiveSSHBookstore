package com.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * Created by 滩涂上的芦苇 on 2016/6/14.
 */
public class BookProfileImp implements BookProfileDao{
    private MongoCollection<Document> coll = null;
    private Document d = null;
    private Document d2 = null;

    public BookProfileImp(MongoCollection<Document> c) {
        coll = c;
        d = new Document();
        d2 = new Document();
    }

    @Override
    public Document getBookProfile(String isbn) throws Exception {
        // TODO Auto-generated method stub
        d.append(BOOKID, isbn);
        return coll.find(d).first();
    }

    @Override
    public void updateBookProfile(String isbn, String profile) throws Exception {
        // TODO Auto-generated method stub
        d.append(BOOKID, isbn);
        d2.append(PROFILE, profile);
        coll.updateOne(d, new BasicDBObject().append("$set", d2));
    }


    @Override
    public void deleteBookProfile(String isbn) throws Exception {
        // TODO Auto-generated method stub
        d.append(BOOKID, isbn);
        coll.findOneAndDelete(d);
    }

    @Override
    public void insertBookProfile(String isbn) throws Exception {
        // TODO Auto-generated method stub
        d.append(BOOKID, isbn);
        coll.insertOne(d);
    }
}
