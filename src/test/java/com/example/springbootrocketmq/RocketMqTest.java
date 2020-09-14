package com.example.springbootrocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author wenxiaojun
 * @since 2020/9/11 15:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketMqTest {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void testRocketMq1() {

        String name = "aaa";
        rocketMQTemplate.convertAndSend("test-topic-1", name);
        rocketMQTemplate.send("test-topic-2", MessageBuilder.withPayload(new OrderPaidEvent("aa,22", new BigDecimal("22"))).build());

        System.err.println("发送成功...");

    }
}

