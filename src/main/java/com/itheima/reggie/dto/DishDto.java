package com.itheima.reggie.dto;

import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;

    public DishDto() {
    }

    public DishDto(List<DishFlavor> flavors, String categoryName, Integer copies) {
        this.flavors = flavors;
        this.categoryName = categoryName;
        this.copies = copies;
    }

    /**
     * 获取
     * @return flavors
     */
    public List<DishFlavor> getFlavors() {
        return flavors;
    }

    /**
     * 设置
     * @param flavors
     */
    public void setFlavors(List<DishFlavor> flavors) {
        this.flavors = flavors;
    }

    /**
     * 获取
     * @return categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取
     * @return copies
     */
    public Integer getCopies() {
        return copies;
    }

    /**
     * 设置
     * @param copies
     */
    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public String toString() {
        return "DishDto{flavors = " + flavors + ", categoryName = " + categoryName + ", copies = " + copies + "}";
    }
}
