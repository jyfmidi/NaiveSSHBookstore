package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by 滩涂上的芦苇 on 2016/6/14.
 */
public class BookMonConnect {
    private static final String URL = "localhost";
    private static final int PORT = 27017;

    private static final String DBNAME = "Mongo_bookstore";
    private static final String COLLNAME = "BookProfile";

    private MongoClient conn = null;
    private MongoDatabase db = null;
    private MongoCollection<Document> coll = null;

    public BookMonConnect() throws Exception {
        try {
            conn = new MongoClient(URL, PORT);
            db = conn.getDatabase(DBNAME);

            coll = db.getCollection(COLLNAME);
        } catch (Exception e) {
            throw e;
        }
    }

    public MongoCollection<Document> getCollection() {
        return coll;
    }

    public void close() throws Exception {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
