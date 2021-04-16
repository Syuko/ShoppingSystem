package com.order.entity;

import java.io.Serializable;

/**
 * 商品类别实体
 */
public class Category implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1575272427167767230L;

    private Integer menuTypeId;
    private String menuType;
    private String menuClass;

    public String getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    public Integer getMenuTypeId() {
        return menuTypeId;
    }

    public void setMenuTypeId(Integer menuTypeId) {
        this.menuTypeId = menuTypeId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        return "Category{" +
                "menuTypeId=" + menuTypeId +
                ", menuType='" + menuType + '\'' +
                ", menuClass='" + menuClass + '\'' +
                '}';
    }
}
