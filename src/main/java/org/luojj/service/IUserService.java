package org.luojj.service;

import org.luojj.model.User;





public interface IUserService {
	  // 通过用户名及密码核查用户登录
    public User checkLogin(String phoneNumber, String loginPassword);
    public boolean register(String phoneNumber, String loginPassword);
    public User getUserById(Long id);
}
