package com.leyou.item.controller;

import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品品牌管理
 */
@Controller
@RequestMapping("brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    /**
     * 查询所有品牌
     *
     * @return
     */
    @RequestMapping("list")
    public ResponseEntity<List<Brand>> findAll() {

        List<Brand> list = this.brandService.findAll();
        if (list == null || list.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }

    @RequestMapping("findAllSelect")
    public ResponseEntity<List<Brand>> findAllSelect(Brand brand) {
        List<Brand> list = brandService.findAllSelect(brand);
        if (list == null || list.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 新增品牌
     */
    @PostMapping
    public ResponseEntity<Brand> addBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        this.brandService.saveBrand(brand, cids);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 分页查询
     * pageNum：页数（第几页）
     * pageSize：每页的数据行数
     */
    @RequestMapping("search")
    public ResponseEntity<List<Brand>> search(@RequestBody Brand brand, int pageNum, int pageSize) {

        return (ResponseEntity<List<Brand>>) brandService.findByPage(brand, pageNum, pageSize);
    }

    /**
     * 根据分类查询品牌
     *
     * @param cid
     * @return
     */
    @RequestMapping("cid/{cid}")
    public ResponseEntity<List<Brand>> queryBrandListByCid(@PathVariable("cid") Long cid) {

        List<Brand> brandList = this.brandService.queryBrandByCategory(cid);
        if (CollectionUtils.isEmpty(brandList)) {
            // 响应404
            return ResponseEntity.badRequest().build();
        }
        // 响应200
        return ResponseEntity.ok(brandList);
    }

    /**
     * 测试接口
     * @return
     */
    @RequestMapping("pangzhao")
    public ResponseEntity demo() {
        System.out.println(ResponseEntity.badRequest().build());
        return ResponseEntity.ok().build();
    }


}
