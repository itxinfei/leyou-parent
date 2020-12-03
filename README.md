## 乐优商城
## 静态页面
http://itxinfei.gitee.io/leyou-parent/

### 交流方式：

QQ技术交流群：863662849<a target="_blank" href="https://qm.qq.com/cgi-bin/qm/qr?k=9yLlyD1dRBL97xmBKw43zRt0-6xg8ohb&jump_from=webapi">
<img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="Java项目交流+求职面试" title="Java项目交流+求职面试"></a><a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=f0hLSE9OTkdHTT8ODlEcEBI" style="text-decoration:none;"><img src="http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_02.png"/></a>

![QQ技术交流群：863662849](https://images.gitee.com/uploads/images/2020/1022/145319_459f7be2_800553.png "QQ技术交流群.png")

## 项目介绍
- 乐优商城是一个全品类的电商购物网站（B2C）。
- 用户可以在线购买商品、加入购物车、下单、秒杀商品
- 可以品论已购买商品
- 管理员可以在后台管理商品的上下架、促销活动
- 管理员可以监控商品销售状况
- 客服可以在后台处理退款操作
- 希望未来3到5年可以支持千万用户的使用


## 系统架构

整个乐优商城可以分为两部分：后台管理系统、前台门户系统。

- 后台管理：
  - 后台系统主要包含以下功能：
    - 商品管理，包括商品分类、品牌、商品规格等信息的管理
    - 销售管理，包括订单统计、订单退款处理、促销活动生成等
    - 用户管理，包括用户控制、冻结、解锁等
    - 权限管理，整个网站的权限控制，采用JWT鉴权方案，对用户及API进行权限控制
    - 统计，各种数据的统计分析展示
  - 后台系统会采用前后端分离开发，而且整个后台管理系统会使用Vue.js框架搭建出单页应用（SPA）。

前台门户

- 前台门户面向的是客户，包含与客户交互的一切功能。例如：
  - 搜索商品
  - 加入购物车
  - 下单
  - 评价商品等等
- 前台系统我们会使用Thymeleaf模板引擎技术来完成页面开发。出于SEO优化的考虑，我们将不采用单页应用。

无论是前台还是后台系统，都共享相同的微服务集群，包括：

- 商品微服务：商品及商品分类、品牌、库存等的服务
- 搜索微服务：实现搜索功能
- 订单微服务：实现订单相关
- 购物车微服务：实现购物车相关功能
- 用户中心：用户的登录注册等功能
- Eureka注册中心
- Zuul网关服务
- Spring Cloud Config配置中心
- ...

## 技术选型

前端技术：

- 基础的HTML、CSS、JavaScript（基于ES6标准）
- JQuery
- Vue.js 2.0以及基于Vue的框架：Vuetify
- 前端构建工具：WebPack
- 前端安装包工具：NPM
- Vue脚手架：Vue-cli
- Vue路由：vue-router
- ajax框架：axios
- 基于Vue的富文本框架：quill-editor

后端技术：

- 基础的SpringMVC、Spring 5.0和MyBatis3
- Spring Boot 2.0.1版本
- Spring Cloud 最新版 Finchley.RC1
- Redis-4.0
- RabbitMQ-3.4
- Elasticsearch-5.6.8
- nginx-1.10.2：
- FastDFS - 5.0.8
- MyCat
- Thymeleaf

## 开发环境

为了保证开发环境的统一，希望每个人都按照我的环境来配置：

- IDE：我们使用Idea 2017.3 版本
- JDK：统一使用JDK1.8
- 项目构建：maven3.3.9以上版本即可
- 版本控制工具：git

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

- 搜索服务-8083
-leyou-search

- 页面静态化-8084
- leyou-goods-web

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