package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuBo;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.item.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品管理
 * <p>
 * SPU：Standard Product Unit （标准产品单位） ，一组具有共同属性的商品集
 * SKU：Stock Keeping Unit（库存量单位），SPU商品集因具体特性不同而细分的每个商品
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @GetMapping("/spu/page")
    @ApiOperation(value = "分页查询Spu", notes = "分页查询Spu")
    public ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable", defaultValue = "true") Boolean saleable) {
        PageResult<SpuBo> result = goodsService.querySpuByPage(key, saleable, page, rows);
        if (result == null || CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增商品", notes = "新增商品")
    public ResponseEntity<Void> saveGoods(@RequestBody SpuBo spuBo) {
        goodsService.saveGoods(spuBo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改商品", notes = "修改商品")
    public ResponseEntity<Void> updateGoods(@RequestBody SpuBo spuBo) {
        goodsService.updateGoods(spuBo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/spu/detail/{spuId}")
    @ApiOperation(value = "根据spuId查询SpuDetail", notes = "根据spuId查询SpuDetail")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable("spuId") Long spuId) {
        SpuDetail spuDetail = goodsService.querySpuDetailBySpuId(spuId);
        if (spuDetail == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(spuDetail);
    }

    @GetMapping("/sku/list")
    @ApiOperation(value = "根据spuId查询Sku集合", notes = "根据spuId查询Sku集合")
    public ResponseEntity<List<Sku>> querySkusBySpuId(@RequestParam("spuId") Long spuId) {

        List<Sku> skus = goodsService.querySkusBySpuId(spuId);
        if (CollectionUtils.isEmpty(skus)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(skus);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据spuId查询Spu", notes = "根据spuId查询Spu")
    public ResponseEntity<Spu> querySpuById(@PathVariable("id") Long id) {
        Spu spu = goodsService.querySpuById(id);
        if (spu == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(spu);
    }

    @GetMapping("sku/{skuId}")
    @ApiOperation(value = "根据spuId查询Spu", notes = "根据spuId查询Spu")
    public ResponseEntity<Sku> querySkuBySkuId(@PathVariable("skuId") Long skuId) {
        Sku sku = goodsService.querySkuBySkuId(skuId);
        if (sku == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(sku);
    }

}
