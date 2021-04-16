package com.order.dao.ifc;


import com.order.entity.Menu;

import java.util.List;

public interface MenuDao {
    public List<Menu> findNew();

    public List<Menu> findAllMenu();//查询所有商品

    Menu findMenuById(int mid);//根据id查询
}
