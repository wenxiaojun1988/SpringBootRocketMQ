package com.example.springbootrocketmq;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author wenxiaojun
 * @since 2020/9/11 15:32
 */
@Data
@AllArgsConstructor
public class OrderPaidEvent implements Serializable {

    private String orderId;

    private BigDecimal paidMoney;

}
