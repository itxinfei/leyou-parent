package com.leyou.cart.service;

import com.leyou.auth.pojo.UserInfo;
import com.leyou.cart.client.GoodsClient;
import com.leyou.cart.interceptor.LoginInterceptor;
import com.leyou.cart.pojo.Cart;
import com.leyou.common.utils.JsonUtils;
import com.leyou.item.pojo.Sku;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private GoodsClient goodsClient;

    static final String KEY_PREFIX = "ly:cart:uid:";

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    /**
     * 添加购物车
     *
     * @param cart
     */
    public void addCart(Cart cart) {
        //获取用户登录信息
        UserInfo user = LoginInterceptor.getLoginUser();
        //Redis的key
        String key = KEY_PREFIX + user.getId();
        //获取hash操作对象
        BoundHashOperations<String, Object, Object> hashOps = this.redisTemplate.boundHashOps(key);
        //查询是否存在
        Long skuId = cart.getSkuId();
        Integer num = cart.getNum();
        Boolean boo = hashOps.hasKey(skuId.toString());
        if (boo) {
            //存在，获取购物车数据
            String json = hashOps.get(skuId.toString()).toString();
            cart = JsonUtils.parse(json, Cart.class);
            //修改购物车数量
            cart.setNum(cart.getNum() + num);
        } else {
            //不存在，新增购物车数据
            cart.setUserId(user.getId());
            //其他商品信息，需要查询商品服务
            Sku sku = this.goodsClient.querySkuBySkuId(skuId);
            cart.setImage(StringUtils.isBlank(sku.getImages()) ? "" :
                    StringUtils.split(sku.getImages(), ",")[0]);
            cart.setPrice(sku.getPrice());
            cart.setTitle(sku.getTitle());
            cart.setOwnSpec(sku.getOwnSpec());
        }
        //将购物车数据写入redis
        hashOps.put(cart.getSkuId().toString(), JsonUtils.serialize(cart));

    }

    /**
     * 查询订单
     *
     * @return
     */
    public List<Cart> queryCartList() {
        //获取登陆用户
        UserInfo user = LoginInterceptor.getLoginUser();
        //判断是否存在购物车
        String key = KEY_PREFIX + user.getId();
        if (!this.redisTemplate.hasKey(key)) {
            //不存在，直接返回
            return null;
        }
        BoundHashOperations<String, Object, Object> hashOps = this.redisTemplate.boundHashOps(key);
        List<Object> carts = hashOps.values();
        //判断是否有数据
        if (CollectionUtils.isEmpty(carts)) {
            return null;
        }
        //查询购物车数据
        return carts.stream().map(o -> JsonUtils.parse(o.toString(), Cart.class)).collect(Collectors.toList());
    }

    /**
     * @param skuId
     * @param num
     */
    public void updateNum(Long skuId, Integer num) {
        //获取登陆用户
        UserInfo user = LoginInterceptor.getLoginUser();
        String key = KEY_PREFIX + user.getId();
        BoundHashOperations<String, Object, Object> hashOps = this.redisTemplate.boundHashOps(key);
        //获取购物车
        String json = hashOps.get(skuId.toString()).toString();
        Cart cart = JsonUtils.parse(json, Cart.class);
        cart.setNum(num);
        //写入购物车
        hashOps.put(skuId.toString(), JsonUtils.serialize(cart));
    }

    /**
     * @param skuId
     */
    public void deleteCart(String skuId) {
        //获取登陆用户
        UserInfo user = LoginInterceptor.getLoginUser();
        String key = KEY_PREFIX + user.getId();
        BoundHashOperations<String, Object, Object> hashOps = this.redisTemplate.boundHashOps(key);
        hashOps.delete(skuId);
    }
}
