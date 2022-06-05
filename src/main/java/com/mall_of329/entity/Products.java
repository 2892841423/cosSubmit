package com.mall_of329.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Products)实体类
 *
 * @author makejava
 * @since 2022-06-05 22:11:33
 */
@Data
public class Products implements Serializable {
    private static final long serialVersionUID = 549884524071793976L;
    /**
    * 商品id
    */
    private String id;
    /**
    * 商品名称
    */
    private String goodsname;
    /**
    * 商品介绍
商品介绍
    */
    private String introduction;
    /**
    * 单价
    */
    private Integer price;
    /**
    * 库存
    */
    private Integer rest;
    /**
    * 商品图片
    */
    private String photo;
    /**
    * 销量
    */
    private Integer sales;
    /**
    * 店铺的id
    */
    private String mallid;

}