package com.example.springbootrocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author wenxiaojun
 * @since 2020/9/11 16:36
 */
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }


}

@Slf4j
@Service
@RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-1")
class MyConsumer1 implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("received message: {}", message);
    }
}

@Slf4j
@Service
@RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-2")
class MyConsumer2 implements RocketMQListener<OrderPaidEvent> {
    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        log.info("received orderPaidEvent: {}", orderPaidEvent);
    }
}