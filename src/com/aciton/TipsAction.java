package com.aciton;

import com.mongodb.client.model.geojson.GeoJsonObjectType;
import com.service.BookProfileService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.bson.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by 滩涂上的芦苇 on 2016/6/14.
 */
public class TipsAction {
    public HttpServletRequest request;

    public HttpServletResponse response;

    public BookProfileService bookProfileService;

    public String execute() {
        request = ServletActionContext.getRequest();
        response=ServletActionContext.getResponse();


        String key= String.valueOf(request.getParameter("key"));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Cache-Control","no-cache");
        try{
            bookProfileService=new BookProfileService();
            Document d=bookProfileService.getBookProfile(key);
            String message="{\"content\":\"";

            if (d == null) {
                message=message+"未查询到相关信息";
            }
            else {
                Set set = d.entrySet();
                Iterator i = set.iterator();
                while (i.hasNext()) {
                    Document.Entry entry = (Document.Entry)i.next();
                    if (entry.getKey().equals("profile")) {
                        message=message+(String)entry.getValue();
                    }
                }
            }
            message+="\"}";

            JSONObject obj=JSONObject.fromObject(message);
            PrintWriter out=response.getWriter();
            out.append(obj.toString());
            out.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        ServletActionContext.setRequest(request);
        ServletActionContext.setResponse(response);
        return "return";
    }
}