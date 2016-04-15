package org.luojj.service;

import org.luojj.entity.User;







public interface IUserService {
	  // 通过用户名及密码核查用户登录
    public boolean isRegistered(String phoneNumber);
    public User checkLogin(String phoneNumber,String loginPassword);
    public User register(String phoneNumber,String loginPassword);
    public int updateUser(User user);
    public User getUser(String phoneNumber);
}
