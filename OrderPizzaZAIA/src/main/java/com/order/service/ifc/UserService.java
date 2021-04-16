package com.order.service.ifc;

import com.order.entity.Users;

public interface UserService {
	/**
	 * 用户登录
	 */
	public Users userLogin(String username, String password);
	/**
	 * 用户注册
	 */
	public Boolean userRegister(Users user);
}
