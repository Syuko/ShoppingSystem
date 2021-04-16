package com.order.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.order.dao.ifc.UserDao;
import com.order.entity.Users;
import com.order.util.DBUtil_pool;
/**
 * 用户访问层
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {

	private static Connection conn = DBUtil_pool.getConnection();
	private static PreparedStatement stat=null;
	private static ResultSet rs=null;
	//登录的sql
	private static final String QUER_USER_BY_USERNAME_PASSWORD="select * from order_user where UserFname=? and UserPassword=?";
	//注册的sql
	private static final String EXE_USER_BY_USER_REGISTER_MESSAGE="INSERT INTO order_user (UserId, UserFname, UserPassword, UserSex, UserPhone) VALUES (?,?,?,?,?)";

	@Override
	public Users queryUserByUsernameAndPassword(String username, String password) {
		Users user=null;
		try {
			stat = conn.prepareStatement(QUER_USER_BY_USERNAME_PASSWORD);
			stat.setString(1, username);
			stat.setString(2, password);
			rs = stat.executeQuery();
			if(rs.next()) {
				user=new Users();
				user.setUserId(rs.getString("UserId"));
				user.setUserTname(rs.getString("UserTname"));
				user.setUserFname(rs.getString("UserFname"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserHead(rs.getString("UserHead"));
				user.setUserPhone(rs.getString("UserPhone"));

//				System.out.println("get user all info");
			}
//			dbp.closeReSource(stat,rs,conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil_pool.closeReSource(stat,rs);
		}
		return user;
	}

	/**
	 * 注册的dao实现
	 * @param user
	 * @return
	 */
	@Override
	public Boolean queryUserByUserMessage(Users user) {
		Boolean exeRegister = false;
		try {
			stat = conn.prepareStatement(EXE_USER_BY_USER_REGISTER_MESSAGE);
			stat.setString(1,user.getUserId());
			stat.setString(2,user.getUserFname());
			stat.setString(3,user.getUserPassword());
			stat.setString(4,user.getUserSex());
			stat.setString(5,user.getUserPhone());
			int result = stat.executeUpdate();
			if(result > 0){
				exeRegister = true;
			}else {
				exeRegister = false;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		finally {
			DBUtil_pool.closeReSource(stat,rs);
		}
		return exeRegister;
	}

}
