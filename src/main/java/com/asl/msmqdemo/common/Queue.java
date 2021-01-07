package com.asl.msmqdemo.common;

import com.asl.msmqdemo.exception.MsmqException;
import ionic.msmq.Message;
import ionic.msmq.MessageQueueException;

import java.io.UnsupportedEncodingException;

/**
 * @author Lance
 * @date 2021/1/7 11:34
 */
public class Queue {
    private String host;
    private String queuName;

    private ionic.msmq.Queue queue;

    public void send(String message, String descLabel, String messageId) {
        check();
        try {
            Message msg = new Message(message, descLabel, messageId);
            queue.send(msg);
        } catch (Exception e) {
            throw new MsmqException(e.getMessage());
        }
    }

    public com.asl.msmqdemo.entity.Message receive() throws MsmqException {
        return receive(null);
    }

    public com.asl.msmqdemo.entity.Message receive(Integer timeout) throws MsmqException {
        check();
        Message msg = null;
        com.asl.msmqdemo.entity.Message result = new com.asl.msmqdemo.entity.Message();
        try {
            if (timeout != null) {
                msg = queue.receive(timeout);
            } else {
                msg = queue.receive();
            }
            if (msg != null) {
                result.setLabel(msg.getLabel());
                result.setMessageId(msg.getCorrelationId());
                result.setContent(msg.getMessage());
            }
        } catch (Exception e) {
            throw new MsmqException("get mesage fail");
        }

        return result;
    }

    public Queue(String host, String queuName) {
        this.host = host;
        this.queuName = queuName;
    }

    public void init() throws MessageQueueException {
        String queueFullName = getQueueFullName();
        queue = new ionic.msmq.Queue(queueFullName);
    }

    public static void main(String[] args) throws MessageQueueException {
        Queue queue = new Queue("", "alice");
        queue.init();
    }

    public void destory() {
        if (queue != null) {
            try {
                queue.close();
            } catch (MessageQueueException e) {
                e.printStackTrace();
            }
        }
    }

    private void check() {
        if (queue == null) {
            throw new MsmqException("connect a queue first!");
        }
    }

    private String getQueueFullName() {
        String h1 = host;

        if ((h1 == null) || h1.equals("")) {
            h1 = ".";
        }

        String a1 = "OS";
        char[] c = h1.toCharArray();
        if ((c[0] >= '1') && (c[0] <= '9')) {
            a1 = "TCP";
        }

        return "DIRECT=" + a1 + ":" + h1 + "\\private$\\" + queuName;
    }
}
