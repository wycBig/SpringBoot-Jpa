package com.inrdev.Entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long uid;
    @Column(name = "uname")
    private String uname;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "phone")
    private String phone;
    @Column(name = "area")
    private String area;
    @Column(name = "manage")
    private Integer manage;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name="photo")
    private String photo;
    @Column(name = "create_time")
    private Date createTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getManage() {
        return manage;
    }

    public void setManage(Integer manage) {
        this.manage = manage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User() {
    }

    public User(Long uid, String uname, Integer gender, String phone, String area, Integer manage, String username, String password, String photo, Date createTime) {
        this.uid = uid;
        this.uname = uname;
        this.gender = gender;
        this.phone = phone;
        this.area = area;
        this.manage = manage;
        this.username = username;
        this.password = password;
        this.photo = photo;
        this.createTime = createTime;
    }
}
