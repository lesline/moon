#==================结构说明文档:MVC-WEB版========================

#=======================指令说明=======================

1.清空环境
mvn clean 

2.建立Eclipse环境
mvn eclipse:eclipse 

3.清空Eclipse环境
mvn eclipse:clean 

4.只编译
mvn compile 

5.只打包
mvn package -Dmaven.ext.skip=true

6.只装配
mvn process-resources

7.打包+装配+安装二进制
mvn install -Dmaven.ext.skip=true

8.依赖关系查询
mvn dependency:tree
mvn dependency:analyze
mvn dependency:list




#=======================常用指令=======================
mvn clean install -Dmaven.ext.skip=true -Pdemo


因为snapshot是定时从maven私服上取，而非实时，可通过以下命令强制从maven私服上取最新jar包
mvn clean package -Dmaven.ext.skip=true -U

