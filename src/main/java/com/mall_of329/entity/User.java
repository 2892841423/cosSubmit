package com.mall_of329.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-06-05 22:41:33
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -17364854336143436L;

    /**
    * 商品主键id
    */
    private String id;
    /**
    * 支付宝账号
    */
    private String alipay;
    /**
    * 商户用户名
    */
    private String username;
    /**
    * 联系电话
    */
    private String call;
    /**
    * 联系地址
    */
    private String contactaddress;
    
    private String mail;
    
    private String password;

    public User(String mail) {
        this.mail = mail;
    }
    public  User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getContactaddress() {
        return contactaddress;
    }

    public void setContactaddress(String contactaddress) {
        this.contactaddress = contactaddress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}