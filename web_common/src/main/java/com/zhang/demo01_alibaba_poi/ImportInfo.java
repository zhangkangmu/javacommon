package com.zhang.demo01_alibaba_poi;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * Created by zhangyuhong
 * Date:2020/2/26
 *
 * javabean
 */
public class ImportInfo extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String name;
    @ExcelProperty(index = 1)
    private Integer age;
    @ExcelProperty(index = 2)
    private String email;
    /*
    通过 @ExcelProperty 注解与 index 变量可以标注成员变量所映射的列
    作为Excel的模型对象,需要setter方法
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
