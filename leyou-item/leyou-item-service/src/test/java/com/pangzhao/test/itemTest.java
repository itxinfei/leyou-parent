package com.pangzhao.test;

import com.leyou.item.LyItemService;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *


@RunWith(SpringRunner.class)
@SpringBootTest(classes = LyItemService.class)
public class itemTest {


    @Resource
    private CategoryMapper categoryMapper;


    @Test
    public void categoryTest() {
        Category category = new Category();
        category.setId((long) 1);
        category.setName("测试");
        
    }

}
 */