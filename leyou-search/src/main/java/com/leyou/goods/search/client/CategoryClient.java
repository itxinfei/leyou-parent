package com.leyou.goods.search.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**item-service
 * 商品分类的FeignClient
 */
@FeignClient("item-service")
public interface CategoryClient extends CategoryApi {

}
