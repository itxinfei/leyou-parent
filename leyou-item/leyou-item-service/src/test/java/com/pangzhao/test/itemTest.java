package com.pangzhao.test;

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