package com.dao;

import com.entity.OrdersEntity;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/8.
 */
public class OrderDaoImp implements OrderDao {

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
    public void pay(OrdersEntity order)
            throws Exception {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        try {
            session.save(order);
        }
        catch (Exception e){
            System.out.println("Something is wrong when add order");
        }
        tx.commit();
        session.close();
        return;
    }

    public Vector<OrdersEntity> queryByUsername(String username) throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String hcl = "from OrdersEntity where uname=?";
        Query query = ses.createQuery(hcl);
        query.setParameter(0,username);
        Vector<OrdersEntity>orders=new Vector<OrdersEntity>(query.list());
        ses.close();
        return orders;
    }

    @Override
    public Vector<Integer> queryUserTimes() throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String sql = "select usercount(uname) from users";
        Query query = ses.createSQLQuery(sql);
        Vector<Integer>temp=new Vector<Integer>(query.list());
        ses.close();
        return temp;
    }

    public Vector<Integer> queryCategoryTimes() throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String sql = "SELECT catCount(category) FROM (SELECT DISTINCT category FROM books) as c";
        Query query = ses.createSQLQuery(sql);
        Vector<Integer>temp=new Vector<Integer>(query.list());
        ses.close();
        return temp;
    }

    public Vector<Integer> queryBookTimes() throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String sql = "SELECT bookCount(isbn) FROM books";
        Query query = ses.createSQLQuery(sql);
        Vector<Integer>temp=new Vector<Integer>(query.list());
        ses.close();
        return temp;
    }



    public Vector<Integer> queryUserBooks() throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String sql = "select userBook(uname) from users";
        Query query = ses.createSQLQuery(sql);
        Vector<Integer>temp=new Vector<Integer>(query.list());
        return temp;
    }

    public Vector<Integer> queryCategoryBooks() throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String sql = "SELECT catBook(category) FROM (SELECT DISTINCT category FROM books) as c;";
        Query query = ses.createSQLQuery(sql);
        Vector<Integer>temp=new Vector<Integer>(query.list());
        ses.close();
        return temp;
    }

    public Vector<Integer> queryBookBooks() throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String sql = "SELECT bookBook(isbn) FROM books";
        Query query = ses.createSQLQuery(sql);
        Vector<Integer>temp=new Vector<Integer>(query.list());
        ses.close();
        return temp;
    }


    public Vector<BigDecimal> queryUserPrice() throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String sql = "select userPrice(uname) from users";
        Query query = ses.createSQLQuery(sql);
        Vector<BigDecimal>temp=new Vector<BigDecimal>(query.list());
        ses.close();
        return temp;
    }

    @Override
    public Vector<OrdersEntity> queryAll() throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String hcl = "from OrdersEntity";
        Query query = ses.createQuery(hcl);
        Vector<OrdersEntity>orders = new Vector<OrdersEntity>(query.list());
        ses.close();
        return orders;
    }
}
