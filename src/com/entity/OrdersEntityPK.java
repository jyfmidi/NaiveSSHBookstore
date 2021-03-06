package com.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
public class OrdersEntityPK implements Serializable {
    private String uname;
    private String isbn;
    private String paytime;

    @Column(name = "uname")
    @Id
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Column(name = "isbn")
    @Id
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "paytime")
    @Id
    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntityPK that = (OrdersEntityPK) o;

        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (paytime != null ? !paytime.equals(that.paytime) : that.paytime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uname != null ? uname.hashCode() : 0;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (paytime != null ? paytime.hashCode() : 0);
        return result;
    }
}
