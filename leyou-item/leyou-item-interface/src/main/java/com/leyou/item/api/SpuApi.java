package com.leyou.item.api;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuBo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("spu")
public interface SpuApi {

    /**
     * 分页查询spu的方法
     *
     * @param key
     * @param page
     * @param rows
     * @param saleable
     * @return
     */
    @GetMapping("page")
    ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "rows", defaultValue = "5") int rows,
            @RequestParam(value = "saleable", defaultValue = "0") int saleable
    );

    /**
     * 根据spu的id查询spu的信息
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    ResponseEntity<Spu> querySpuBySpuId(@PathVariable("id") Long id);
}
