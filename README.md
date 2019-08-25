# spring-cloud 个人搭建基础框架
## 只有基础功能，可以根据业务情况在添加模块
### 功能介绍
```
功能点：
    个人根据(https://github.com/paascloud)这个项目以及所学搭建了一个基础框架
技术点：
    核心框架：springcloud全家桶
    安全框架：Spring Security Spring Cloud Oauth2
    持久层框架：MyBatis、Mybatis_PageHelper
    数据库连接池：Alibaba Druid
    三方服务： 邮件服务、阿里云短信服务
```
### 目录结构说明
```
   ├─spring-cloud----------------------------父项目，公共依赖
   │  ├─base-service
   │  │  │
   │  │  ├─eureka-service------------------微服务注册中心
   │  │  │
   │  │  ├─oauth-service------------------用户授权中心
   │  │  │
   │  │  ├─txlcn-service------------------txlcn分布式事务系统(待调整)
   │  │  │
   │  │  └─zuul-service------------------微服务网关中心
   │  │
   │  ├─common
   │  │  │
   │  │  ├─base------------------公共POJO基础包
   │  │  │
   │  │  ├─config------------------公共配置包
   │  │  │
   │  │  ├─security-app------------------公共无状态安全认证
   │  │  │
   │  │  ├─security-core------------------安全服务核心包
   │  │  │
   │  │  └─security-feign------------------基于auth2的feign配置
   │  │
  
```
