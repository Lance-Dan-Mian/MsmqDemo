package com.asl.msmqdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.asl.msmqdemo.common.Result;
import com.asl.msmqdemo.entity.Message;
import com.asl.msmqdemo.entity.User;
import com.asl.msmqdemo.service.IMsmqService;
import com.asl.msmqdemo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Lance
 * @date 2021/1/7 10:44
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IMsmqService msmqService;


    @PostMapping("/user/accept")
    public Result<User> acceptUser(User user) {
        if (logger.isDebugEnabled()) {
            logger.debug(this.getClass().getName() + ":" + JSONObject.toJSONString(user));
        }
        Result<User> result = new Result<>(0, "操作成功");
        Message message = new Message(JSONObject.toJSONString(user), UUID.randomUUID().toString(), "userCreate");
        msmqService.send(message);
        return result;
    }

    @GetMapping("/user/create")
    public Result createUser() {
        Result<User> result = new Result<>(0, "操作成功");

        Message receive = msmqService.receive(2000);
        if (logger.isDebugEnabled()) {
            logger.debug(this.getClass().getName() + ":" + JSONObject.toJSONString(receive));
        }
        if (receive.getContent() != null) {
            User user = JSONObject.parseObject(receive.getContent(), User.class);
            userService.saveUser(user);
        }
        return result;
    }
}
