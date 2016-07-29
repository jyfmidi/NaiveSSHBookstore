package com.aciton;

import com.entity.UsersEntity;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/8.
 */
public class ChangeUser {
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

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        //String name = String.valueOf(request.getParameter("username"));

        try {
            UsersEntity user=new UsersEntity();
            // if user dosen't exist
            if (userService.queryByName(username) == null) {
                request.setAttribute("status", "修改失败");
            }
            else {
                user=userService.queryByName(username);
                if (user.getIsAdmin()==1)
                {
                    user.setIsAdmin(0);
                }
                else
                {
                    user.setIsAdmin(1);
                }
                userService.updateUser(user);
                request.setAttribute("status", "修改成功");
            }
            Vector<UsersEntity> users = new Vector<UsersEntity>();
            users = userService.queryAll();
            request.setAttribute("userlist", users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServletActionContext.setRequest(request);
        return RETURN;
    }
}
