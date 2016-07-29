package com.service;

import com.dao.OrderDao;
import com.entity.OrdersEntity;
import org.hibernate.internal.CriteriaImpl;

import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/8.
 */
public class OrderService {
    private OrderDao dao;

    public void setDao(OrderDao d) {
        dao = d;
    }

    public void pay(OrdersEntity order) throws Exception {
        // TODO Auto-generated method stub
        try {
            dao.pay(order);
        } catch (Exception e) {
            throw e;
        }
    }

    public Vector<Integer> queryUserTimes() throws Exception {
        // TODO Auto-generated method stub
        Vector<Integer> orders = null;
        try {
            orders = dao.queryUserTimes();
        } catch (Exception e) {
            throw e;
        }

        return orders;
    }

    public Vector<Integer> queryCategoryTimes() throws Exception {
        // TODO Auto-generated method stub
        Vector<Integer> orders = null;
        try {
            orders = dao.queryCategoryTimes();
        } catch (Exception e) {
            throw e;
        }

        return orders;
    }

    public Vector<Integer> queryBookTimes() throws Exception {
        // TODO Auto-generated method stub
        Vector<Integer> orders = null;
        try {
            orders = dao.queryBookTimes();
        } catch (Exception e) {
            throw e;
        }

        return orders;
    }




    public Vector<Integer> queryUserBooks() throws Exception {
        // TODO Auto-generated method stub
        Vector<Integer> orders = null;
        try {
            orders = dao.queryUserBooks();
        } catch (Exception e) {
            throw e;
        }

        return orders;
    }

    public Vector<Integer> queryCategoryBooks() throws Exception {
        // TODO Auto-generated method stub
        Vector<Integer> orders = null;
        try {
            orders = dao.queryCategoryBooks();
        } catch (Exception e) {
            throw e;
        }

        return orders;
    }

    public Vector<Integer> queryBookBooks() throws Exception {
        // TODO Auto-generated method stub
        Vector<Integer> orders = null;
        try {
            orders = dao.queryBookBooks();
        } catch (Exception e) {
            throw e;
        }

        return orders;
    }





    public Vector<BigDecimal> queryUserPrice() throws Exception {
        // TODO Auto-generated method stub
        Vector<BigDecimal> orders = null;
        try {
            orders = dao.queryUserPrice();
        } catch (Exception e) {
            throw e;
        }

        return orders;
    }

    public Vector<OrdersEntity> queryByUsername(String username) throws Exception {
        // TODO Auto-generated method stub
        Vector<OrdersEntity> orders = null;
        try {
            orders = dao.queryByUsername(username);
        } catch (Exception e) {
            throw e;
        }

        return orders;
    }


    public Vector<OrdersEntity> queryAll() throws Exception {
        // TODO Auto-generated method stub
        Vector<OrdersEntity> orders = null;
        try {
            orders = dao.queryAll();
        } catch (Exception e) {
            throw e;
        }

        return orders;
    }
}
