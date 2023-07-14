package com.whyjc.springsecurity.service;

import com.whyjc.springsecurity.entity.User;
import com.whyjc.springsecurity.util.ResponseResult;

/**
 * @Author :Yijc
 * @Date :2023/7/13
 */
public interface ILoginService {

    public ResponseResult login(User user);

    public ResponseResult logout();
}
