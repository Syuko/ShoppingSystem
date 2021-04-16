package com.order.service.ifc;

import com.order.entity.Menu;

import java.util.List;

/**
 * 商品业务逻辑接口
 */
public interface MenuService {
    /**
     * 查找最新商品*8
     */
    public List<Menu> findNew();

    /**
     * 查找所有商品
     */
    public List<Menu> findAllMenu();

    Menu findMenuById(int mid);
}
