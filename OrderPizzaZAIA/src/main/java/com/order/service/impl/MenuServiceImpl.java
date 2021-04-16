package com.order.service.impl;

import com.order.dao.ifc.MenuDao;
import com.order.dao.impl.MenuDaoImpl;
import com.order.entity.Menu;
import com.order.service.ifc.MenuService;

import java.util.List;

/**
 * 商品业务逻辑实现
 */
public class MenuServiceImpl implements MenuService {
    private MenuDao menuDao = new MenuDaoImpl();

    @Override
    public List<Menu> findNew() {
        return menuDao.findNew();
    }

    @Override
    public List<Menu> findAllMenu() {
        return menuDao.findAllMenu();
    }

    @Override
    public Menu findMenuById(int mid) {
        return menuDao.findMenuById(mid);
    }


}
