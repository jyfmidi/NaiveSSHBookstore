package com.aciton;

import com.service.BookProfileService;
import com.service.UserProfileService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;

/**
 * Created by 滩涂上的芦苇 on 2016/6/14.
 */
public class InsertBookProfile {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;

    private BookProfileService bookProfileService;

    private String isbn;

    public void setUsername(String isbn) {
        this.isbn = isbn;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        isbn=(String) request.getAttribute("isbn");

        try {
            bookProfileService = new BookProfileService();
            bookProfileService.insertBookProfile(isbn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
