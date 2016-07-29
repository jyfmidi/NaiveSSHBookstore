package com.entity;

import javax.persistence.*;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
@Entity
@Table(name = "orders", schema = "my_bookstore", catalog = "")
@IdClass(OrdersEntityPK.class)
public class OrdersEntity {
    private String uname;
    private String isbn;
    private int amount;
    private String paytime;

    @Id
    @Column(name = "uname")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Id
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Id
    @Column(name = "paytime")
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

        OrdersEntity that = (OrdersEntity) o;

        if (amount != that.amount) return false;
        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (paytime != null ? !paytime.equals(that.paytime) : that.paytime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uname != null ? uname.hashCode() : 0;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (paytime != null ? paytime.hashCode() : 0);
        return result;
    }
}
