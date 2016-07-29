package com.aciton;

import com.service.BookProfileService;
import com.service.UserProfileService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 滩涂上的芦苇 on 2016/6/14.
 */
public class UpdateBookProfile {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;
    private BookProfileService bookProfileService;

    private String isbn;
    private String profile;

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getProfile(){return this.profile;}

    public void setProfile(String profile){this.profile=profile;}

    public String execute() {
        request = ServletActionContext.getRequest();
        isbn=(String) request.getAttribute("isbn");
        profile=(String) request.getAttribute("profile");

        try {
            bookProfileService = new BookProfileService();

            if (profile != null) {
                bookProfileService.updateBookProfile(isbn, profile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("status", "Update book profile: succeed.");
        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
