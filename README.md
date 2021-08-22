# spring-cloud 个人搭建基础框架
## 一个大致的分布式结构和基础功能，可以根据各自情况在添加和调整，有不足之处，请各位指出，谢谢
### 功能介绍
```
功能点：
    个人根据所学搭建了一个基础框架
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
   │  │  ├─base------------------公共基础包
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
