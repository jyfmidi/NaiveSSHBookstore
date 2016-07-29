package com.aciton;

import com.entity.BooksEntity;
import com.entity.OrdersEntity;
import com.service.BookService;
import com.service.OrderService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
public class StatDate {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;

    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private String startDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    private String endDate;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        String name = String.valueOf(request.getSession().getAttribute("username"));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sd=sdf2.parse(startDate);
            Date ed=sdf2.parse(endDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(ed);
            calendar.add(Calendar.DAY_OF_MONTH, +1);
            ed = calendar.getTime();
            Vector<OrdersEntity> orders = orderService.queryAll();
            Vector<OrdersEntity> result = new Vector<>();
            Vector<BooksEntity> books=new Vector<>();
            for(int i=0;i<orders.size();i++)
            {
                Date temp=sdf.parse(orders.get(i).getPaytime());
                if(sd.getTime()<=temp.getTime()&&temp.getTime()<=ed.getTime())
                {
                    books.add(bookService.queryByIsbn(orders.get(i).getIsbn()));
                    result.add(orders.get(i));
                }
            }
            request.getSession().setAttribute("username", name);
            request.setAttribute("orderlist", result);
            request.setAttribute("booklist", books);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
