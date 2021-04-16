package com.order.service.impl;

import com.order.dao.ifc.CategoryDao;
import com.order.dao.impl.CategoryDaoImpl;
import com.order.entity.Category;
import com.order.service.ifc.CategoryService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


import java.util.List;

/**
 * 商品类别规则（接口）实现类
 */
public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        List<Category> list = null;
        //获取缓存管理器
        CacheManager cacheManager = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
        //获取缓存对象categoryCache
        Cache cache = cacheManager.getCache("categoryCache");
        //缓存获取数据map
        Element element = cache.get("clist");
        //判断缓存中有没有数据
        if (element == null){
            //没有
            list = categoryDao.findAll();
            //放入缓存
            cache.put(new Element("clist",list));
//            System.out.println("First:缓存没有数据");
        } else {
            list = (List<Category>) element.getObjectValue();
//            System.out.println("缓存有数据");
        }
//        List<Category> list = categoryDao.findAll();
        return list;
    }
}
