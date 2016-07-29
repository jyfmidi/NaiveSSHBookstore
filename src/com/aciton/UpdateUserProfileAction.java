package com.aciton;

import com.service.UserProfileService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 滩涂上的芦苇 on 2016/6/12.
 */
public class UpdateUserProfileAction {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;
    private UserProfileService userProfileService;

    private String username;
    private String email;
    private String qq;
    private String tel;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        Object name = request.getSession().getAttribute("username");
        if (name == null || name.equals("")) {
            request.setAttribute("status", "Update user profile: failed.");
            ServletActionContext.setRequest(request);
            return RETURN;
        }
        try {
            userProfileService = new UserProfileService();
            username=(String)name;
            if (email != null) {
                System.out.println("action" + username);
                userProfileService.updateUserEmail(username, email);
            }
            if (qq != null) {
                userProfileService.updateUserQQ(username, qq);
            }
            if (tel != null) {
                userProfileService.updateUserTel(username, tel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("status", "Update user profile: succeed.");
        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
