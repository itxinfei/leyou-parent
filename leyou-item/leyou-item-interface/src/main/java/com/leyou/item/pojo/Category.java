package com.leyou.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


/**
 * @Author: cuzz
 * @Date: 2018/11/1 10:16
 * @Description: 分类
 */
@Table(name = "tb_category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long parentId;
    /**
     * 注意isParent生成的getter和setter方法需要手动加上Is
     */
    private Boolean isParent;
    private Integer sort;

    //多对多操作
    private List<Brand> Brands;

}
