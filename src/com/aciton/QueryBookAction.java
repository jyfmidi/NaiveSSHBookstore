package com.aciton;

import com.entity.BooksEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/7.
 */
public class QueryBookAction extends ActionSupport{
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";
    public static final String ADMIN = "admin";

    public HttpServletRequest request;

    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private String method;
    private String content;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        Vector<BooksEntity> books = new Vector<BooksEntity>();
        String returnPath = null;
        try {
            // if no content, query all books
            if (content == null || content.equals("")) {
                books = bookService.queryAll();
            }
            else if (method.equals("title")) { // query by title
                books = bookService.queryByTitle(content);
            }
            else if (method.equals("isbn")) { // by isbn
                BooksEntity book = bookService.queryByIsbn(content);
                if (book != null) {
                    books.add(book);
                }
            }
            else if (method.equals("category")) { // by category
                books = bookService.queryByCategory(content);
            }
            request.setAttribute("booklist", books);
            Object name = request.getSession().getAttribute("username");

            if (name != null && name.equals("admin")) {
                returnPath = ADMIN;
            }
            else {
                returnPath = RETURN;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServletActionContext.setRequest(request);
        return returnPath;
    }
}
