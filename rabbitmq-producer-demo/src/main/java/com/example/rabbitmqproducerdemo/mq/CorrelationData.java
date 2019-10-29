package com.example.rabbitmqproducerdemo.mq;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Gary
 * @className CorrelationData
 * @description TODO
 * @date 2019-07-18 10:12
 **/
@Data
@Accessors(chain = true)
public class CorrelationData extends org.springframework.amqp.rabbit.connection.CorrelationData {
    /**
     * 消息体
     */
    private Object message;

    /**
     * 交换机名称
     */
    private String exchange;

    /**
     * 路由key
     */
    private String routingKey;

    /**
     * 重试次数
     */
    private int retryCount = 0;

    public CorrelationData() {
        super();
    }

    public CorrelationData(String id) {
        super(id);
    }

    public CorrelationData(String id, Object data) {
        this(id);
        this.message = data;
    }
}
