# 一. 安装

## 1.1 安装

1. 安装JDK
2. 解压

## 1.2 目录

- bin 

  脚本文件，包括 ES 启动 & 安装插件等等

- config 

  elasticsearch.yml（ES 配置文件）、jvm.options（JVM 配置文件）、日志配置文件等等

- lib 

  类库

- logs 

  日志文件

- modules 

  ES 所有模块，包括 X-pack 等

- plugins 

   ES 已经安装的插件。默认没有插件

- data

  ES 启动的时候，会有该目录，用来存储文档数据。该目录可以设置

## 1.3 启停

1. 进入 bin/ 目录

2. 执行 ./elasticsearch 或者 ./elasticsearch -d

   

## 1.4 问题

1. 



# 二. 配置

## 2.1 elasticsearch.yml

```shell
#集群名称
cluster.name: my-application
#节点名称
node.name: node-1

#数据存储目录（多个路径）
path.data: /path/to/data
#日志目录
path.logs: /path/to/logs

#本机的IP地址
network.host: 0.0.0.0
#监听端口(默认)
http.port: 9200

#发现
discovery.seed_hosts: ["host1", "host2"]
#
cluster.initial_master_nodes: ["node-1", "node-2"]

```



## 2.2 jvm.options

