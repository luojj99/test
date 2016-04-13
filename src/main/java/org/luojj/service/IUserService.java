package org.luojj.service;

import java.sql.SQLException;

import org.luojj.entity.User;





public interface IUserService {
	  // 通过用户名及密码核查用户登录
    public boolean isRegistered(String phoneNumber);
    public User checkLogin(String phoneNumber,String loginPassword);
    public User register(String phoneNumber,String loginPassword);
}
