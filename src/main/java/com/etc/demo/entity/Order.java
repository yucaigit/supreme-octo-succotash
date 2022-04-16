package com.etc.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * order
 *
 * @author
 */
@Data
public class Order implements Serializable {
    private Integer orderId;

    private Integer userId;

    private Integer goodsId;

    private Integer shoppingId;

    private Integer orderState;

    private String orderSendtime;

    private String orderEndtime;

    private String orderDescribe;

    private String orderAmount;

    private Goods goods;

    private static final long serialVersionUID = 1L;
}