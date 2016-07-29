package com.aciton;

import com.entity.BooksEntity;
import com.entity.OrdersEntity;
import com.service.BookService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/8.
 */
public class updateCart {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;

    private String bookname;
    private int quantity;
    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String execute() {
        request = ServletActionContext.getRequest();

        Vector<OrdersEntity> orderlist=new Vector<OrdersEntity>();
        Vector<String>namelist=new Vector<String>();
        Vector<BigDecimal>pricelist=new Vector<BigDecimal>();

        try{
            if(request.getSession().getAttribute("cart")!=null)
            {
            /*if there is a cart*/
                orderlist=(Vector<OrdersEntity>)request.getSession().getAttribute("cart");
            }
            boolean exist=false;
            for(int i=0;i<orderlist.size();i++)
            {
                BooksEntity book=bookService.queryByIsbn(orderlist.get(i).getIsbn());
                namelist.add(book.getTitle());
                pricelist.add(book.getPrice());
                if(orderlist.get(i).getIsbn().equals(bookname))
                {
                /*the book exist*/
                    orderlist.get(i).setAmount(orderlist.get(i).getAmount()+quantity);
                    exist=true;
                }
            }
            if(!exist)
            {
                OrdersEntity newOrder=new OrdersEntity();
                newOrder.setAmount(quantity);
                newOrder.setIsbn(bookname);
                orderlist.add(newOrder);
                BooksEntity book=bookService.queryByIsbn(bookname);
                namelist.add(book.getTitle());
                pricelist.add(book.getPrice());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        request.setAttribute("namelist",namelist);
        request.setAttribute("pricelist",pricelist);
        request.getSession().setAttribute("cart", orderlist);

        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
