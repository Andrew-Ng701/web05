package com.itheima.reggie.dto;

import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;


public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;

    public SetmealDto() {
    }

    public SetmealDto(List<SetmealDish> setmealDishes, String categoryName) {
        this.setmealDishes = setmealDishes;
        this.categoryName = categoryName;
    }

    /**
     * 获取
     * @return setmealDishes
     */
    public List<SetmealDish> getSetmealDishes() {
        return setmealDishes;
    }

    /**
     * 设置
     * @param setmealDishes
     */
    public void setSetmealDishes(List<SetmealDish> setmealDishes) {
        this.setmealDishes = setmealDishes;
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

    public String toString() {
        return "SetmealDto{setmealDishes = " + setmealDishes + ", categoryName = " + categoryName + "}";
    }
}
