package com.asl.msmqdemo.exception;

/**
 * @author Lance
 * @date 2021/1/7 11:27
 */
public class MsmqException extends RuntimeException{
    public MsmqException(String message) {
        super(message);
    }
}
