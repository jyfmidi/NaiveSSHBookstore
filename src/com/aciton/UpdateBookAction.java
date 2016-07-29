package com.aciton;

import com.entity.BooksEntity;
import com.service.BookService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/7.
 */
public class UpdateBookAction {
    public static final long serialVersionUID = 1L;
    public static final String ADMIN = "admin";
    public static final String INDEX = "index";

    public HttpServletRequest request;

    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private String isbn;
    private String title;
    private String category;
    private BigDecimal price;
    private String profile;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String execute() {
        request = ServletActionContext.getRequest();

        if ((int)request.getSession().getAttribute("isAdmin")!=1) {
            request.setAttribute("status", "Fatal: you are not administrator!");
            ServletActionContext.setRequest(request);
            return INDEX;
        }

        try {
            BooksEntity book = bookService.queryByIsbn(isbn);
            // book not exist, insert operation
            if (book == null && price.compareTo(BigDecimal.ZERO)==1) {
                book = new BooksEntity();
                book.setIsbn(isbn);
                book.setTitle(title);
                book.setCategory(category);
                book.setPrice(price);
                bookService.addBook(book);
                request.setAttribute("status", "添加图书成功");
            }
            else { // book exist, update operation
                boolean changed = false;
                if (title != null && title != "") {
                    book.setTitle(title);
                    changed = true;
                }
                if (category != null && category != "") {
                    book.setCategory(category);
                    changed = true;
                }
                if (price.compareTo(BigDecimal.ZERO)==1) {
                    book.setPrice(price);
                    changed = true;
                }
                if (!changed){
                    request.setAttribute("status", "图书添加失败，请仔细检查");
                    ServletActionContext.setRequest(request);
                    return ADMIN;
                }
                bookService.updateBook(book);
            }
            Vector<BooksEntity> books = new Vector<BooksEntity>();
            books = bookService.queryAll();
            request.setAttribute("booklist", books);
            request.setAttribute("isbn",isbn);
            request.setAttribute("profile",profile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ServletActionContext.setRequest(request);
        return ADMIN;
    }
}
