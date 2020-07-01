package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.vo.PageResult;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品品牌
 */
@Service
public class BrandService {


    @Resource
    private BrandMapper brandMapper;

    /**
     * 查询所有品牌
     *
     * @return
     */
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }


    /**
     * @param brand
     * @return
     */
    public List<Brand> findAllSelect(Brand brand) {
        return brandMapper.select(brand);
    }

    /**
     * 新增品牌
     *
     * @param brand
     * @return
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        // 新增品牌信息
        this.brandMapper.insertSelective(brand);
        // 新增品牌和分类中间表
        for (Long cid : cids) {
            this.brandMapper.insertCategoryBrand(cid, brand.getId());
        }
    }

    /**
     * 分页查询
     */
    public List<Brand> findByPage(Brand brand, int pageNum, int pageSize) {
        // 使用分页插件:
        PageHelper.startPage(pageNum, pageSize);
        // 进行条件查询:
        return brandMapper.selectByExample(brand);
    }

    /**
     * @param cid
     * @return
     */
    public List<Brand> queryBrandByCategory(Long cid) {
        return this.brandMapper.queryByCategoryId(cid);
    }

    /**
     *
     * @param id
     * @return
     */
    public Brand queryById(Long id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        if (brand == null) {
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        return brand;
    }
}