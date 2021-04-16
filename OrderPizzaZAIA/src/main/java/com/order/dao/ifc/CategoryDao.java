package com.order.dao.ifc;

import com.order.entity.Category;

import java.util.List;

/**
 * 商品类别接口
 */
public interface CategoryDao {
    /**
     * 所有商品类别
     */
    public List<Category> findAll();
}
