package com.asl.msmqdemo.mapper;

import com.asl.msmqdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lance
 * @date 2021/1/7 10:54
 */
@Repository
@Mapper
public interface UserMapper {
    void saveUser(User user);
}
