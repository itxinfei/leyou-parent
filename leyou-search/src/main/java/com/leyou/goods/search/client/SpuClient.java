package com.leyou.goods.search.client;

import com.leyou.item.api.SpuApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 */
@FeignClient("item-service")
public interface SpuClient extends SpuApi {

}
