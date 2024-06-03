# MyBatis Plus快速入门
## 数据库准备
* 部署mysql

开发阶段也可以连接本地mysql服务

```shell
# 拉取镜像
docker pull mysql:8.0.30

# 创建容器
docker run -d --name mysql -p 3307:3306 -v mysql_data:/var/lib/mysql -v mysql_conf:/etc/mysql --restart=always --privileged=true -e MYSQL_ROOT_PASSWORD=1234 mysql:8.0.30
```



* docker exec 进入mysql容器

* mysql -uroot -p 登录你的 MySQL 数据库，然后 执行这条SQL：

```sql
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '1234';
```



首先在数据库中准备一张表，为后序的学习做准备。
1. **创建数据库**

   在MySQL中创建一个数据库`hello_mp`

   ```sql
   CREATE DATABASE hello_mp CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
   ```

2. **创建表**

   在`hello-mp`库中创建一个表`user`

   ```sql
   DROP TABLE IF EXISTS user;
   CREATE TABLE user
   (
       id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
       name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
       age INT(11) NULL DEFAULT NULL COMMENT '年龄',
       email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
       PRIMARY KEY (id)
   );
   ```

3. **插入数据**

   ```bash
   INSERT INTO user (id, name, age, email) VALUES
   (1, 'Jone', 18, 'test1@baomidou.com'),
   (2, 'Jack', 20, 'test2@baomidou.com'),
   (3, 'Tom', 28, 'test3@baomidou.com'),
   (4, 'Sandy', 21, 'test4@baomidou.com'),
   (5, 'Billie', 24, 'test5@baomidou.com');
   ```

## 与SpringBoot集成

Mybatis Plus与SpringBoot的集成十分简单，具体操作如下

1. **引入Maven 依赖**

   提前创建好一个SpringBoot项目，然后在项目中引入MyBatis Plus依赖

   本案例完整的`pom.xml`文件如下

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>
       <parent>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-parent</artifactId>
           <version>3.0.9</version>
           <relativePath/> <!-- lookup parent from repository -->
       </parent>
       <groupId>com.atguigu</groupId>
       <artifactId>hello-mp</artifactId>
       <version>0.0.1-SNAPSHOT</version>
       <name>hello-mp</name>
       <description>hello-mp</description>
       <properties>
           <java.version>17</java.version>
       </properties>
       <dependencies>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
           </dependency>
   
           <dependency>
               <groupId>com.mysql</groupId>
               <artifactId>mysql-connector-j</artifactId>
               <scope>runtime</scope>
           </dependency>
           <dependency>
               <groupId>org.projectlombok</groupId>
               <artifactId>lombok</artifactId>
               <optional>true</optional>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-test</artifactId>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>com.baomidou</groupId>
               <artifactId>mybatis-plus-boot-starter</artifactId>
               <version>3.5.3.2</version>
           </dependency>
       </dependencies>
   
       <build>
           <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
               </plugin>
           </plugins>
       </build>
   
   </project>
   ```

2. **配置`application.yml`文件**

   配置数据库相关内容如下

   ```yml
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       username: root
       password: Atguigu.123
       url: jdbc:mysql://192.168.10.101:3306/hello_mp?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2b8
   ```

## 创建实体类

创建与`user`表相对应的实体类，如下

```java
@Data
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("email")
    private String email;
}
```

