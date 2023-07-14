package com.whyjc.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whyjc.springsecurity.entity.Menu;

import java.util.List;

/**
 * @Author :Yijc
 * @Date :2023/7/14
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long id);
}
