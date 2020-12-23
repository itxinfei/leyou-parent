package com.leyou.goods.search.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 商品分类的FeignClient
 */
@FeignClient("item-service")
public interface CategoryClient extends CategoryApi {


    List<String> queryNameByIds(List<Long> asList);
}
