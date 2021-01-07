package com.asl.msmqdemo.service.impl;

import com.asl.msmqdemo.common.Queue;
import com.asl.msmqdemo.entity.Message;
import com.asl.msmqdemo.exception.MsmqException;
import com.asl.msmqdemo.service.IMsmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lance
 * @date 2021/1/7 11:29
 */
@Service
public class MsmqServiceImpl implements IMsmqService {
    @Autowired
    private Queue queue;


    @Override
    public void send(Message message) throws MsmqException {
        queue.send(message.getContent(), message.getLabel(), message.getMessageId());
    }

    @Override
    public Message receive(int timeout) {
        return queue.receive(timeout);
    }
}
