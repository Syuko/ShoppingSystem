package com.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author Administrator
 *
 */
public class Users implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 322144283166590485L;
	private String userId;
	private String userFname;
	private String userTname;
	private String userSex;
	private String userHead;
	private String userPassword;
	private String userPhone;

	@Override
	public String toString() {
		return "Users{" +
				"userId='" + userId + '\'' +
				", userFname='" + userFname + '\'' +
				", userTname='" + userTname + '\'' +
				", userSex='" + userSex + '\'' +
				", userHead='" + userHead + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userPhone='" + userPhone + '\'' +
				'}';
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserTname() {
		return userTname;
	}

	public void setUserTname(String userTname) {
		this.userTname = userTname;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}



}
