package com.order.service.impl;

import com.order.dao.ifc.UserDao;
import com.order.dao.impl.UserDaoImpl;
import com.order.entity.Users;
import com.order.service.ifc.UserService;
/**
 * 用户逻辑处理层
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{
	private UserDao userDao=new UserDaoImpl();
	@Override
	public Users userLogin(String username, String password) {
		return userDao.queryUserByUsernameAndPassword(username, password);
	}

	@Override
	public Boolean userRegister(Users user) {
		return userDao.queryUserByUserMessage(user);
	}

}
