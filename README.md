# spring cloud demo

这代码就当作自己的demo库吧

### 主要的microservice
- registry 注册中心
- config 配置中心
- config-repo 配置文件仓库
- gateway 网关中心
- auth-service 授权中心
- monitor 监控中心
- zipkin 链路追踪
- 其他 各个业务逻辑服务

### 杂七杂八环境
- java8
- mysql
- redis
- rabbitmq
- 配置文件管理库（github）

### 其他说明：

#### 启动顺序
1. registry 注册中心
2. config 配置中心
3. gateway 网关中心  auth-service 授权中心
4. 其他资源服务随意启动

#### swagger： 
配置在网关的文档中心，需要授权访问
url：http://127.0.0.1:8060/swagger-ui.html


#### 完成的模块
- 服务注册消费
- 分布式配置中心(支持refresh)
- 服务网关中心
- oauth2授权
- 统一swagger文档中心结合oauth2认证
- 简单服务容错(Hystrix)
- 统一异常处理(gateway特殊处理)