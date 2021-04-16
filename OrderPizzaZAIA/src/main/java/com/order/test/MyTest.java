package com.order.test;

import java.sql.Connection;
import java.util.List;

import com.order.dao.ifc.CategoryDao;
import com.order.dao.impl.CategoryDaoImpl;
import com.order.entity.Category;
import org.junit.Test;

import com.order.util.DBUtil_pool;

public class MyTest {
	CategoryDao categoryDao = new CategoryDaoImpl();

	@Test
	public void testDBUtil_pool() {
		Connection conn=DBUtil_pool.getConnection();
		System.out.println("链接信息"+conn);
	}

	/**
	 * 测试查询菜单类别
	 */
	@Test
	public void testCategoryFindALl(){
		List<Category> categoryList = categoryDao.findAll();
		System.out.println(categoryList);
	}
}
