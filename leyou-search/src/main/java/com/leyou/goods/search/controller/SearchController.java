package com.leyou.goods.search.controller;


import com.leyou.common.pojo.PageResult;
import com.leyou.goods.search.client.CategoryClient;
import com.leyou.goods.search.pojo.Goods;
import com.leyou.goods.search.pojo.SearchRequest;
import com.leyou.goods.search.service.SearchService;
import com.leyou.item.pojo.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {

    @Resource
    private SearchService searchService;

    @Resource
    private CategoryClient categoryClient;

    /**
     * 搜索商品
     *
     * @param request
     * @return
     */
    @PostMapping("page")
    public ResponseEntity<PageResult<Goods>> search(@RequestBody SearchRequest request) {
        PageResult<Goods> result = this.searchService.search(request);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 根据3级分类id，查询1~3级的分类
     *
     * @param id
     * @return
     */
    @GetMapping("all/level")
    public ResponseEntity<List<Category>> queryAllByCid3(@RequestParam("id") Long id) {
        List ids = new ArrayList();
        ids.add(id);
        List<Category> list = this.categoryClient.queryCategoryListByids(ids);
        if (list == null || list.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }
}
