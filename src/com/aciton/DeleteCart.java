package com.aciton;

import com.entity.BooksEntity;
import com.entity.OrdersEntity;
import com.service.BookService;
import jdk.nashorn.internal.runtime.ECMAException;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
public class DeleteCart {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;
    private String bookname;
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

    public String execute() {
        request = ServletActionContext.getRequest();
        Vector<OrdersEntity> orderlist=(Vector<OrdersEntity>)request.getSession().getAttribute("cart");
        Vector<String>namelist=new Vector<String>();
        Vector<BigDecimal>pricelist=new Vector<BigDecimal>();

        try{
            for(int i=0;i<orderlist.size();i++)
            {
                if(orderlist.get(i).getIsbn().equals(bookname))
                {
                /*the book exist*/
                    orderlist.remove(i);
                }
                else
                {
                    BooksEntity book=bookService.queryByIsbn(orderlist.get(i).getIsbn());
                    namelist.add(book.getTitle());
                    pricelist.add(book.getPrice());
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        request.getSession().setAttribute("cart", orderlist);
        request.setAttribute("namelist",namelist);
        request.setAttribute("pricelist",pricelist);
        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
