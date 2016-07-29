package com.entity;

import javax.persistence.*;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
@Entity
@Table(name = "users", schema = "my_bookstore", catalog = "")
public class UsersEntity {
    private String uname;
    private String upass;
    private Integer isAdmin;

    @Id
    @Column(name = "uname")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "upass")
    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    @Basic
    @Column(name = "isAdmin")
    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;
        if (upass != null ? !upass.equals(that.upass) : that.upass != null) return false;
        if (isAdmin != null ? !isAdmin.equals(that.isAdmin) : that.isAdmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uname != null ? uname.hashCode() : 0;
        result = 31 * result + (upass != null ? upass.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        return result;
    }
}
