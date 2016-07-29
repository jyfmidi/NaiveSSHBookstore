package com.aciton;

import com.entity.UsersEntity;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/7.
 */
public class QueryUserAction {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";

    public HttpServletRequest request;

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        Vector<UsersEntity> users = new Vector<UsersEntity>();
        try {
            users = userService.queryAll();
            request.setAttribute("userlist", users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
