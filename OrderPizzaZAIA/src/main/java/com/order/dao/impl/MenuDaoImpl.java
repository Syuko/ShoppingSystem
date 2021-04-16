package com.order.dao.impl;

import com.order.dao.ifc.MenuDao;
import com.order.entity.Category;
import com.order.entity.Menu;
import com.order.util.DBUtil_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品接口
 */
public class MenuDaoImpl implements MenuDao {
    private static Connection conn = null;
    private static PreparedStatement stat=null;
    private static ResultSet rs=null;
    //最新8个商品
    private static final String QUERT_NEW_MENU= "select * from order_menu ORDER BY MenuUpDate desc LIMIT 8";
    //所有商品
    private static final String QUERT_ALL_MENU= "select * from order_menu";
    //根据id查询
    private static final String QUERT_MENU_BY_ID= "select * from order_menu where MenuId = ?";
    /**
     * 查找最新商品
     * @return menuList
     */
    @Override
    public List<Menu> findNew() {
        List<Menu> menuList = new ArrayList<>();
        Menu menu = null;
        try{
            conn = DBUtil_pool.getConnection();
            stat = conn.prepareStatement(QUERT_NEW_MENU);
            rs = stat.executeQuery();
            while (rs.next()){
                menu = new Menu();
                Category c = new Category();

                c.setMenuTypeId(rs.getInt("MenuTypeId"));
                menu.setCategory(c);

                menu.setMenuId(rs.getInt("MenuId"));
                menu.setMenuName(rs.getString("MenuName"));
                menu.setMenuPhoto(rs.getString("MenuPhoto"));
                menu.setMenuRetail(rs.getFloat("MenuRetail"));
                menu.setMenuIntroduction(rs.getString("MenuIntroduction"));
                menuList.add(menu);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return menuList;
    }

    /**
     * 查找所有商品
     * @return allMenu
     */
    @Override
    public List<Menu> findAllMenu() {
        List<Menu> allMenu = new ArrayList<>();
        Menu menu = null;
        try{
            conn = DBUtil_pool.getConnection();
            stat = conn.prepareStatement(QUERT_ALL_MENU);
            rs = stat.executeQuery();
            while (rs.next()){
                menu = new Menu();
                Category c = new Category();

                c.setMenuTypeId(rs.getInt("MenuTypeId"));
                menu.setCategory(c);

                menu.setMenuId(rs.getInt("MenuId"));
                menu.setMenuName(rs.getString("MenuName"));
                menu.setMenuPhoto(rs.getString("MenuPhoto"));
                menu.setMenuRetail(rs.getFloat("MenuRetail"));
                menu.setMenuIntroduction(rs.getString("MenuIntroduction"));
                allMenu.add(menu);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return allMenu;
    }

    /**
     * 根据id查询商品对象
     * @param mid
     * @return
     */
    @Override
    public Menu findMenuById(int mid) {
        Menu menu = null;
        try{
            conn = DBUtil_pool.getConnection();
            stat = conn.prepareStatement(QUERT_MENU_BY_ID);
            stat.setInt(1, mid);
            rs = stat.executeQuery();
            if (rs.next()){
                menu = new Menu();
                Category c = new Category();

                c.setMenuTypeId(rs.getInt("MenuTypeId"));
                menu.setCategory(c);

                menu.setMenuId(rs.getInt("MenuId"));
                menu.setMenuName(rs.getString("MenuName"));
                menu.setMenuPhoto(rs.getString("MenuPhoto"));
                menu.setMenuRetail(rs.getFloat("MenuRetail"));
                menu.setMenuIntroduction(rs.getString("MenuIntroduction"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return menu;
    }
}
