package com.leyou.goods.search.client;

import com.leyou.item.api.GoodsApi;
import com.leyou.item.pojo.Spu;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 商品的FeignClient
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {

    Spu querySpuBySpuId(Long id);
}
