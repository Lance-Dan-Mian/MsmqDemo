package com.asl.msmqdemo.config;

import com.asl.msmqdemo.common.Queue;
import ionic.msmq.MessageQueueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lance
 * @date 2021/1/7 11:20
 */
@Configuration
public class MsmqConfig {
    @Value("${queue.host}")
    private String host;

    @Value("${queue.name}")
    private String queueName;

    @Bean(initMethod="init", destroyMethod = "destory")
    public Queue queue() throws MessageQueueException {
        return new com.asl.msmqdemo.common.Queue(host, queueName);
    }
}
