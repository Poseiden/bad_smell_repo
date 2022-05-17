# 工时管理服务

此项目为工时管理服务

## 目录
* [环境准备](#环境准备)
* [启动命令](#启动命令)
* [词汇表](#词汇表)

## 环境准备
- Java8
- Docker

## 启动命令
```bash
//Step0 在启动该项目前，请预先安装好 Java8 以及 Docker，下载地址：
//Java8: https://www.java.com/en/download/manual.jsp
//Docker: https://docs.docker.com/get-docker/
//本项目正常运行需要占用两个端口，分别为 8080 与 33306, 请提前预留，或自行修改端口号

// Step1  创建该项目所需的数据库实例
sh ./env-build-scripts/create_database_instance.sh  //在项目根目录下执行

// Step2 创建数据库。 待上一步执行成功后，使用任一数据库连接工具连上此数据库实例（示例用户名密码在命令脚本中），在 sql console 中执行以下sql 脚本,创建数据库
// env-build-scripts/init_db.sql  

// Step3 启动项目，在首次运行时， 如果系统中没有对应版本的 gradle，那么会先自动下载，之后项目启动时，会自动运行db/migration下的所有sql 脚本，创建对应的表，数据库结构等等, 最后项目启动在 8080 端口下
./gradlew bootRun       

// 附：构建项目命令
./gradlew build      

```

## 词汇表

### [工时]词汇表
|  领域名词 |  英文   |  模型  |   表名  |  备注  |
|  :----:  | :----: | :----: | :----: | :----: |
|    工时  | effort |  Effort  | effort | / | 
|    工作日  | working day |  workingDay  | / | / | 
|    工作小时数  | working hours |  workingHours  | / | / | 
|    是否收取费用  | billable |  billable  | / | / | 
|     备注  | note |  note  | / | / | 
|    工时状态  | effort status |  effortStatus  | / | / | 
|    已保存  | saved |  saved  | / | / | 
|    已提交  | submitted |  submitted  | / | / | 

### [考勤卡]词汇表
| 领域名词 |  英文   |  模型  |   表名  |  备注  |
|:----:| :----: | :----: | :----: | :----: |
| 考勤卡  | timecard | Timecard | / | / |  
| 时间段  | period | Period | / | / | 
| 总小时数 | total hours | totalHours | / | / | 
| 登记项  | entry |  Entry | / | / | 

### [登记项]词汇表
| 领域名词 |  英文   |  模型  |   表名  |  备注  |
|  :----:  | :----: | :----: | :----: | :----: |
| 登记项  | entry | entry | / | / |  
| 小时数  | hours | hours | / | / |  
| 子登记项  | sub entry | subEntry | / | / |  

### [子登记]项词汇表
| 领域名词 |  英文   |  模型  |   表名  |  备注  |
|  :----:  | :----: | :----: | :----: | :----: |
| 子登记项  |  sub entry | sub entry | / | / |  
| 是否收取费用  |  billable | billable | / | / |  
| 备注  | note | note | / | / |  

### [地点]词汇表
| 领域名词 |  英文   |  模型  |   表名  |  备注  |
|  :----:  | :----: | :----: | :----: | :----: |
| 地点  |  location | location | / | / |  
| 地区缩写  |  code | code | / | / |  
| 地区名称  | name | name | / | / |  
