package com.aciton;

import com.entity.UsersEntity;
import com.service.OrderService;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
public class StatUser {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";
    public static final String ADMIN = "admin";
    public static final String INDEX = "index";

    public HttpServletRequest request;

    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        Object name = request.getSession().getAttribute("username");
        Vector<UsersEntity>users=new Vector<>();
        Vector<Integer>times=new Vector<>();
        Vector<Integer>bookNumber=new Vector<>();
        Vector<BigDecimal>price=new Vector<>();

        try {
            users=userService.queryAll();
            times=orderService.queryUserTimes();
            bookNumber=orderService.queryUserBooks();
            price=orderService.queryUserPrice();
            request.setAttribute("userlist",users);
            request.setAttribute("timeslist",times);
            request.setAttribute("bookNumber",bookNumber);
            request.setAttribute("pricelist",price);
            request.getSession().setAttribute("username", name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
