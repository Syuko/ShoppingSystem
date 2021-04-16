package com.order.dao.impl;

import com.order.dao.ifc.CategoryDao;
import com.order.entity.Category;
import com.order.util.DBUtil_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品类别接口
 */
public class CategoryDaoImpl implements CategoryDao {

    private static Connection conn = null;
    private static PreparedStatement stat=null;
    private static ResultSet rs=null;
    private static final String QUERT_ALL_MENUTYPE = "select * from order_menu_type";
    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        Category category = null;
        try {
            conn = DBUtil_pool.getConnection();
            stat = conn.prepareStatement(QUERT_ALL_MENUTYPE);
            rs = stat.executeQuery();
            while (rs.next()){
                category = new Category();
                category.setMenuTypeId(rs.getInt("MenuTypeId"));
                category.setMenuType(rs.getString("MenuType"));
                category.setMenuClass(rs.getString("MenuClass"));
                categoryList.add(category);

            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return categoryList;
    }
}
