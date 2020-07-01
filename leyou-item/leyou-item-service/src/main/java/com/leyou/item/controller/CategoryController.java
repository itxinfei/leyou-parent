package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类
 */
@Controller
@RequestMapping("category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 根据父节点查询商品类目
     *
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryByParentId(
            @RequestParam(value = "pid", defaultValue = "0") Long pid) {
        List<Category> list = this.categoryService.queryListByParent(pid);
        if (list == null || list.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }


    /**
     * 根据ID查询商品列表
     *
     * @return
     */
    @GetMapping("bid/{bid}")
    public ResponseEntity<List<Category>> queryByBrandId(@PathVariable("bid") Long bid) {

        List<Category> list = this.categoryService.queryByBrandId(bid);
        if (list == null || list.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 根据ID删除商品
     */
    @GetMapping("del/{bid}")
    public ResponseEntity deleteByBrand(@PathVariable("bid") Long bid) {
        categoryService.deleteById(bid);
        return ResponseEntity.ok(bid);

    }

}
