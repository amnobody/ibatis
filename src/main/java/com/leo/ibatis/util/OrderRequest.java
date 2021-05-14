package com.leo.ibatis.util;

import lombok.Data;

import java.util.Date;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/10
 * @description
 */
@Data
public class OrderRequest {
    private String orderId;
    private String orderNo;
    private Date orderTime;
}
