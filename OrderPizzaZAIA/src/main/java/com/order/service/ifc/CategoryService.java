package com.order.service.ifc;

import com.order.entity.Category;

import java.util.List;

/**
 * 商品类别业务逻辑接口
 */
public interface CategoryService {
    /**
     * return 所有商品类别
     */
    public List<Category> findAll();

}
