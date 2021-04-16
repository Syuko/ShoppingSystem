package com.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品类（菜）
 */
public class Menu implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -8980671482470413841L;
    private Integer menuId;
    private String menuPhoto;
    private String menuName;
    private float menuRetail;
    private String menuIntroduction;
    private Date menuUpDate;
    private Category category;//商品类别

    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuPhoto='" + menuPhoto + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuRetail=" + menuRetail +
                ", menuIntroduction='" + menuIntroduction + '\'' +
                ", menuUpDate=" + menuUpDate +
                ", category=" + category +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getMenuUpDate() {
        return menuUpDate;
    }

    public void setMenuUpDate(Date menuUpDate) {
        this.menuUpDate = menuUpDate;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuPhoto() {
        return menuPhoto;
    }

    public void setMenuPhoto(String menuPhoto) {
        this.menuPhoto = menuPhoto;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public float getMenuRetail() {
        return menuRetail;
    }

    public void setMenuRetail(float menuRetail) {
        this.menuRetail = menuRetail;
    }

    public String getMenuIntroduction() {
        return menuIntroduction;
    }

    public void setMenuIntroduction(String menuIntroduction) {
        this.menuIntroduction = menuIntroduction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
