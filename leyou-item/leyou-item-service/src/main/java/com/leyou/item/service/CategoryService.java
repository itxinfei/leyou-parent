package com.leyou.item.service;

import com.leyou.item.api.CategoryApi;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService implements CategoryApi {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 根据父节点查询商品类目
     *
     * @param pid
     * @return
     */
    public List<Category> queryListByParent(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return this.categoryMapper.select(record);
    }

    /**
     * 根据ID查询商品列表
     *
     * @return
     */
    public List<Category> queryByBrandId(Long bid) {
        return this.categoryMapper.queryByBrandId(bid);
    }

    /**
     * 根据id删除
     *
     * @param bid
     */
    public void deleteById(Long bid) {
        categoryMapper.deleteByBrandId(bid);
    }

    /**
     * 根据id查询商品分类
     *
     * @param ids
     */
    @Override
    public List<Category> queryCategoryListByids(List<Long> ids) {
        return null;
    }
}
