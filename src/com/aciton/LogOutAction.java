package com.aciton;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 滩涂上的芦苇 on 2016/6/14.
 */
public class LogOutAction {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;

    public String execute() {
        request = ServletActionContext.getRequest();
        if (request.getSession().getAttribute("username") != null) {
            request.getSession().setAttribute("username", "");
            request.getSession().setAttribute("cart","");
            request.setAttribute("status", "Logout success!");
        }
        else {
            request.setAttribute("status", "Logout failed: not logged in.");
        }
        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
