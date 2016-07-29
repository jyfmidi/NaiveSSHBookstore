package com.aciton;

import com.service.UserProfileService;
import org.apache.struts2.ServletActionContext;
import org.bson.Document;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 滩涂上的芦苇 on 2016/6/12.
 */
public class QueryUserProfileAction {
    public static final long serialVersionUID = 1L;
    public static final String RETURN = "return";
    public static final String ADMIN = "admin";

    public HttpServletRequest request;
    private UserProfileService userProfileService;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String execute() {
        request = ServletActionContext.getRequest();
        Object name = request.getSession().getAttribute("username");
        String path = RETURN;

        if (name == null || name.equals("")) {
            request.setAttribute("status", "Query user profile: failed.");
            ServletActionContext.setRequest(request);
            return RETURN;
        }
        else if (name.equals("admin")) {
            path = ADMIN;
        }

        try {
            username=(String) request.getSession().getAttribute("username");
            userProfileService = new UserProfileService();
            Document d = userProfileService.getUserProfile(username);
            if (d == null) {
                request.setAttribute("username", username);
                request.setAttribute("email", "");
                request.setAttribute("qq", "");
                request.setAttribute("tel", "");
            }
            else {
                Set set = d.entrySet();
                Iterator i = set.iterator();
                while (i.hasNext()) {
                    Document.Entry entry = (Document.Entry)i.next();
                    if (entry.getKey().equals("uname")) {
                        request.setAttribute("username", entry.getValue());
                    }
                    else if (entry.getKey().equals("email")) {
                        request.setAttribute("email", entry.getValue());
                    }
                    else if (entry.getKey().equals("qq")) {
                        request.setAttribute("qq", entry.getValue());
                    }
                    else if (entry.getKey().equals("tel")) {
                        request.setAttribute("tel", entry.getValue());
                    }
                    else {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServletActionContext.setRequest(request);
        return path;
    }
}
