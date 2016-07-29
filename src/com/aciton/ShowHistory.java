package com.aciton;

import com.entity.BooksEntity;
import com.entity.OrdersEntity;
import com.service.BookService;
import com.service.OrderService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
public class ShowHistory {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";
    public static final String ADMIN = "admin";

    public HttpServletRequest request;

    private OrderService orderService;

    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        String name = String.valueOf(request.getSession().getAttribute("username"));
        Vector<OrdersEntity> orders = new Vector<OrdersEntity>();
        Vector<String>namelist=new Vector<String>();
        Vector<BigDecimal>pricelist=new Vector<BigDecimal>();

        try
        {
            orders = orderService.queryByUsername(name);
            for(int i=0;i<orders.size();i++)
            {
                BooksEntity book=bookService.queryByIsbn(orders.get(i).getIsbn());
                namelist.add(book.getTitle());
                pricelist.add(book.getPrice());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        request.setAttribute("orderlist", orders);
        request.setAttribute("namelist",namelist);
        request.setAttribute("pricelist",pricelist);
        request.getSession().setAttribute("username", name);

        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
