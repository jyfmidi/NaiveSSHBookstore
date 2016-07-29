package com.aciton;

import com.service.UserProfileService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 滩涂上的芦苇 on 2016/6/12.
 */
public class InsertUserProfileAction {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;

    private UserProfileService userProfileService;

    private String username;

    public void setUsername(String s) {
        username = s;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        username=(String) request.getSession().getAttribute("username");

        try {
            userProfileService = new UserProfileService();
            userProfileService.insertUserProfile(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
