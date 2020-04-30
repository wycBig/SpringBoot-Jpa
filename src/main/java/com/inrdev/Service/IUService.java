package com.inrdev.Service;

import com.inrdev.Entity.User;

import java.util.List;

public interface IUService {
    //获取所有的用户
    List<User> getAllUser();
    //添加
    int addUser(User user);
    //删除
    int deleteUser(Long id);
    //更新
    int updateUser(User user);
    //查询，按照id
    User queryUser(long id);

    List<User> findByDynamicCases(String username, String password);
}
