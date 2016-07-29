package com.dao;


import com.entity.BooksEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/7.
 */
public class BookDaoImp implements BookDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory ses) {
        sessionFactory = ses;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBook(BooksEntity book) throws Exception {
        // TODO Auto-generated method stub
        Session sesssion = sessionFactory.openSession();

        Transaction tx = sesssion.beginTransaction();
        try {
            sesssion.save(book);
        }
        catch (Exception e){
            System.out.println("Something is wrong when adding the books.");
        }
        tx.commit();
        sesssion.close();
        return;
    }

    @Override
    public void updateBook(BooksEntity book) throws Exception {
        // TODO Auto-generated method stub
        Session sesssion = sessionFactory.openSession();

        Transaction tx = sesssion.beginTransaction();
        try {
            sesssion.update(book);
        }
        catch (Exception e){
            System.out.println("Something is wrong when updating the books.");
        }
        tx.commit();
        sesssion.close();
        return;
    }

    @Override
    public Vector<BooksEntity> queryAll() throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String hcl = "from BooksEntity";
        Query query = ses.createQuery(hcl);
        Vector<BooksEntity> books = new Vector<BooksEntity>(query.list());
        ses.close();
        return books;
    }

    public Vector<String> queryAllCategory() throws Exception{
        Session ses=sessionFactory.openSession();
        String sql="select distinct category from books";
        Query query=ses.createSQLQuery(sql);
        Vector<String> categorys=new Vector<String>(query.list());
        ses.close();
        return categorys;
    }

    @Override
    public BooksEntity queryByIsbn(String isbn) throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String hcl = "from BooksEntity where isbn=?";
        Query query = ses.createQuery(hcl);
        query.setParameter(0, isbn);
        BooksEntity book = (BooksEntity) query.uniqueResult();
        ses.close();
        return book;
    }

    @Override
    public Vector<BooksEntity> queryByTitle(String title) throws Exception {
        Session ses = sessionFactory.openSession();
        String hcl = "from BooksEntity where title like '%"+title+"%'";
        Query query = ses.createQuery(hcl);
        Vector<BooksEntity> books = new Vector<BooksEntity>(query.list());
        ses.close();
        return books;
    }

    @Override
    public Vector<BooksEntity> queryByCategory(String category) throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String hcl = "from BooksEntity where category like '%"+category+"%'";
        Query query = ses.createQuery(hcl);
        Vector<BooksEntity> books = new Vector<BooksEntity>(query.list());
        ses.close();
        return books;
    }

    @Override
    public void deleteByIsbn(String isbn) throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();

        Transaction tx = ses.beginTransaction();
        BooksEntity book=new BooksEntity();
        book.setIsbn(isbn);
        try {
            ses.delete(book);
        }
        catch (Exception e){
            System.out.println("Something is wrong when deleting the user.");
        }
        tx.commit();
        ses.close();
    }
}
