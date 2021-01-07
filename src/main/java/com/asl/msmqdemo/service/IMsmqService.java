package com.asl.msmqdemo.service;

import com.asl.msmqdemo.entity.Message;
import com.asl.msmqdemo.exception.MsmqException;

/**
 * @author Lance
 * @date 2021/1/7 11:23
 */
public interface IMsmqService {
    void send(Message message) throws MsmqException;
    Message receive(int timeout);
}
