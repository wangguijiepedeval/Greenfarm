

# RuoYi、Redis、Nacos、Sentinel相关

### 运行Windows下的Redis服务：

```powershell
 .\redis-server.exe redis.windows.conf
```

结果图：

![image-20220702104524028](https://wangguijie-typora.oss-cn-chengdu.aliyuncs.com/img/image-20220702104524028.png)

之后访问服务端：

```powershell
#访问redis服务端口
.\redis-cli.exe -h 127.0.0.1 -p 6379
#查看密码
config get requirepass
#修改密码
config set requirepass redis 密码
#验证密码
auth 密码
```

> ==注意：这里我们可以不设置密码，而是让密码默认为空即可，这样不会影响服务的访问，所以在这里我没有设置密码。==



### 运行Windows下的Nacos服务：

安装注意事项

1、注意安装时，startup.cmd默认启动方式是cluster模式，在本地运行是需要改成standalone模式的

- cluster集群模式
- standalone单机模式

![image-20220702110532892](https://wangguijie-typora.oss-cn-chengdu.aliyuncs.com/img/image-20220702110532892.png)

2、注意启动服务后， http://127.0.0.1:8848/nacos ，然后再打开的首页输入Nacos的账号： nacos 和密码： nacos ，就可以登录刚刚启动的Nacos。







### 运行Windows下的Sentinel服务：

命令行打开，运行
我的jar包路径： `D:\coding\Sentinel\sentinel-dashboard-1.8.4.jar`

```powershell
#运行
java -jar sentinel-dashboard-1.8.4.jar
```

运行结果图：

<img src="https://wangguijie-typora.oss-cn-chengdu.aliyuncs.com/img/image-20220702111558107.png" alt="image-20220702111558107" style="zoom:50%;" />

Sentinel在8080端口运行，大多时候被占用。注意windows 8080端口被占用的解决；

```shell
#显示所有的端口占用情况
netstat -ano
#查看占用8080端口的进程PID
netstat -aon|findstr "8080"
#查看对应PID为7172（根据实际情况写PID号）的服务进制
tasklist|findstr "7172"
```

然后在任务管理器->进程关闭对应服务

启动sentinel服务后， http://localhost:8080 ，然后再打开的首页输入sentinel 的账号： sentinel 和密码： sentinel ，就可以登录刚刚启动的sentinel 。







```shell
### If use MySQL as datasource:
spring.datasource.platform=mysql
 
### Count of DB:
db.num=1
 
### Connect URL of DB:
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=root
db.password=wgj123456
```

==PS：==

![image-20220702114746606](https://wangguijie-typora.oss-cn-chengdu.aliyuncs.com/img/image-20220702114746606.png)







### RuoYi管理系统后端

网关的运行要事先启动nacos服务：

![image-20220704125104367](https://wangguijie-typora.oss-cn-chengdu.aliyuncs.com/img/image-20220704125104367.png)

> 以上时若依网关应用服务





### RuoYi管理系统前端

前端RuoYi-ui建议使用vscode打开，并配置安装npm

前端页面使用以下代码运行：

```shell
npm run dev
```

> 其他更多关于若依前端的信息、命令参照`readme`：[RuoYi-Cloud: 🎉 基于Spring Boot、Spring Cloud & Alibaba的分布式微服务架构权限管理系统，同时提供了 Vue3 的版本 - Gitee.com](https://gitee.com/wangguijie/RuoYi-Cloud/tree/master/ruoyi-ui)



#### 前端目录结构：

D:\coding\RuoYi_Cloud\ruoyi-ui\src\layout\components\Sidebar\Logo.vue：是主页面的左边栏

