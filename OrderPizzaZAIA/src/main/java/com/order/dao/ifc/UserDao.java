package com.order.dao.ifc;

import com.order.entity.Users;

/**
 * 用户操作接口
 */
public interface UserDao {
	//login
	public Users queryUserByUsernameAndPassword(String username, String password);
	//register
	public Boolean queryUserByUserMessage(Users user);
}
