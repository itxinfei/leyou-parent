# 乐优商城
## 项目介绍
乐优商城是一个全品类的电商购物网站（B2C），用户可以在线购买商品、加入购物车、下单、秒杀商品，可以评论已购买商品，管理员可以在后台管理商品的上下架、促销活动，管理员可以监控商品销售状况，客服可以在后台处理退款操作，希望未来3到5年可以支持千万用户的使用。

## 软件架构
![输入图片说明](https://images.gitee.com/uploads/images/2020/0617/154553_3e990dad_800553.png "1525703759035.png")
![输入图片说明](https://images.gitee.com/uploads/images/2020/0617/154620_6c3df726_800553.png "1525704277126.png")
## 后端工程架构

- 服务网关-10010
- leyou-api-gateway

- 注册中心-10086
- leyou-registry

- 商品服务-8081
- leyou-item 

- 文件服务-8082
- leyou-upload

- 用户服务-8085
- leyou-user

- 短信服务-8086
- leyou-sms-service

- 授权中心-8087
- leyou-auth

- 购物车-8088
- leyou-cart

- 订单系统-8089
- leyou-order

- 通用工具
- leyou-common

## 前端工程架构
- 后台系统-9001
- leyou-manage-web
- 前端页面-9002
- leyou-portal


## nginx
### api网关
- http://api.leyou.com
- http://127.0.0.1:10010

### 后端管理
- http://manage.leyou.com
- http://127.0.0.1:9001




