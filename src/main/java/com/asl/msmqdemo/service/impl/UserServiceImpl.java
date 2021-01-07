package com.asl.msmqdemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.asl.msmqdemo.entity.Message;
import com.asl.msmqdemo.entity.User;
import com.asl.msmqdemo.mapper.UserMapper;
import com.asl.msmqdemo.service.IMsmqService;
import com.asl.msmqdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Lance
 * @date 2021/1/7 10:56
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IMsmqService msmqService;

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }
}
