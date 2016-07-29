package com.aciton;

import com.entity.BooksEntity;
import com.service.BookService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/7.
 */
public class DeleteBookAction {
    public static final long serialVersionUID = 1L;
    public static final String ADMIN = "admin";
    public static final String INDEX = "index";

    private HttpServletRequest request;

    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        if ((int)request.getSession().getAttribute("isAdmin")!=1) {
            request.setAttribute("status", "Fatal: you are not administrator!");
            ServletActionContext.setRequest(request);
            return INDEX;
        }
        //String isbn = request.getParameter("isbn");
        try {
            if (bookService.queryByIsbn(isbn) == null) {
                request.setAttribute("status", "删除失败");
            }
            else {
                bookService.deleteByIsbn(isbn);
                request.setAttribute("status", "删除成功.");
            }
            Vector<BooksEntity> books = new Vector<BooksEntity>();
            books = bookService.queryAll();
            request.setAttribute("booklist", books);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServletActionContext.setRequest(request);
        return ADMIN;
    }
}
