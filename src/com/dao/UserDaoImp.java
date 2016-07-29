package com.dao;
import com.entity.UsersEntity;
import com.service.UserService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/6.
 */
public class UserDaoImp implements UserDao{

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
    public void addUser(UsersEntity user) throws Exception {
        Session ses = sessionFactory.openSession();

        Transaction tx = ses.beginTransaction();
        try {
            ses.save(user);
        }
        catch (Exception e){
            System.out.println("Something is wrong when adding the user.");
        }
        tx.commit();
        ses.close();

        return;
    }



    @Override
    public void updateUser(UsersEntity user)
            throws Exception {
        Session ses = sessionFactory.openSession();

        Transaction tx = ses.beginTransaction();
        try {
            ses.update(user);
        }
        catch (Exception e){
            System.out.println("Something is wrong when updating the user.");
        }
        tx.commit();
        ses.close();
    }

    @Override
    public void deleteUserByName(String username) throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();

        Transaction tx = ses.beginTransaction();
        UsersEntity user=new UsersEntity();
        user.setUname(username);
        try {
            ses.delete(user);
        }
        catch (Exception e){
            System.out.println("Something is wrong when deleting the user.");
        }
        tx.commit();
        ses.close();
    }

    @Override
    public UsersEntity queryByName(String username) throws Exception {
        // TODO Auto-generated method stub
        Session ses = sessionFactory.openSession();
        String hcl = "from UsersEntity where uname=?";
        Query query = ses.createQuery(hcl);
        query.setParameter(0, username);
        query.setMaxResults(1);
        UsersEntity user = (UsersEntity)query.uniqueResult();

        ses.close();
        return user;
    }

    public Vector<UsersEntity> queryAll() throws Exception {
        Session ses = sessionFactory.openSession();
        String hcl = "from UsersEntity ";
        Query query = ses.createQuery(hcl);
        Vector<UsersEntity> books = new Vector<UsersEntity>(query.list());
        ses.close();
        return books;
    }
}
