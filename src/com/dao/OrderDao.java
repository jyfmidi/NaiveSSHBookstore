package com.dao;

import com.entity.OrdersEntity;
import org.hibernate.internal.CriteriaImpl;

import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/8.
 */
public interface OrderDao {
    // insert cart into database to become an order
    public void pay(OrdersEntity order) throws Exception;
    // query order by username
    public Vector<OrdersEntity> queryByUsername(String username) throws Exception;

    public Vector<Integer> queryUserBooks() throws Exception;

    public Vector<BigDecimal> queryUserPrice() throws Exception;

    public Vector<Integer> queryUserTimes() throws Exception;
    // query all orders
    public Vector<OrdersEntity> queryAll() throws Exception;

    public Vector<Integer> queryCategoryBooks() throws Exception;

    public Vector<Integer> queryCategoryTimes() throws Exception;

    public Vector<Integer> queryBookBooks() throws Exception;

    public Vector<Integer> queryBookTimes() throws Exception;
}
