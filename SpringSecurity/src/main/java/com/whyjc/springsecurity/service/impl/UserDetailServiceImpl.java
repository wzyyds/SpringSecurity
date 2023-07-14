package com.whyjc.springsecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whyjc.springsecurity.entity.LoginUser;
import com.whyjc.springsecurity.entity.User;
import com.whyjc.springsecurity.mapper.MenuMapper;
import com.whyjc.springsecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

/**
 * @Author :Yijc
 * @Date :2023/7/13
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("user_name",username);
        User user = userMapper.selectOne(wrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }
        List<String> menus = menuMapper.selectPermsByUserId(user.getId());
        return new LoginUser(user,menus);
    }
}
