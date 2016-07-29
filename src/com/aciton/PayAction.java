package com.aciton;

import com.entity.OrdersEntity;
import com.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
public class PayAction {
    public static final long serialVersionUID = 1L;
    public static final String SUCCESS= "success";
    public static final String FAILED= "failed";

    public HttpServletRequest request;

    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String execute() {
        request = ServletActionContext.getRequest();

        Vector<OrdersEntity> orderlist=(Vector<OrdersEntity>)request.getSession().getAttribute("cart");
        try {
            String username = String.valueOf(request.getSession().getAttribute("username"));

            // pay for everything
            for (int i = 0; i < orderlist.size(); i++) {
                OrdersEntity order = orderlist.get(i);
                order.setUname(username);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                order.setPaytime(df.format(new Date()));
                orderService.pay(order);
            }
            orderlist=new Vector<OrdersEntity>();
            request.getSession().setAttribute("cart",orderlist);
            request.getSession().setAttribute("username", username);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("status", "支付失败");
            ServletActionContext.setRequest(request);
            return FAILED;
        }
        request.setAttribute("status", "支付成功");
        ServletActionContext.setRequest(request);
        return SUCCESS;
    }
}
