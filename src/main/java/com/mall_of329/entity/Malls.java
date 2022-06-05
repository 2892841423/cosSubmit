package com.mall_of329.entity;

import java.io.Serializable;

/**
 * (Malls)实体类
 *
 * @author makejava
 * @since 2022-06-05 22:11:15
 */
public class Malls implements Serializable {
    private static final long serialVersionUID = -30730053422524580L;
    /**
    * 店铺id
    */
    private String id;
    /**
    * 店铺名字
    */
    private String mallname;
    /**
    * 发货地址
    */
    private String shipperaddress;
    /**
    * 店主id
    */
    private String userid;
    /**
    * 店铺标志
    */
    private String logal;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMallname() {
        return mallname;
    }

    public void setMallname(String mallname) {
        this.mallname = mallname;
    }

    public String getShipperaddress() {
        return shipperaddress;
    }

    public void setShipperaddress(String shipperaddress) {
        this.shipperaddress = shipperaddress;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLogal() {
        return logal;
    }

    public void setLogal(String logal) {
        this.logal = logal;
    }

}