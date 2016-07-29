package com.aciton;

import com.entity.BooksEntity;
import com.service.BookService;
import com.service.OrderService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
public class StatBook {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;

    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
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
        Vector<BooksEntity> categorys=null;
        Vector<Integer>times=null;
        Vector<Integer>bookNumber=null;

        try {
            categorys=bookService.queryAll();
            times=orderService.queryBookTimes();
            bookNumber=orderService.queryBookBooks();
            request.setAttribute("categorylist",categorys);
            request.setAttribute("timeslist",times);
            request.setAttribute("bookNumber",bookNumber);
            request.getSession().setAttribute("username", name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
