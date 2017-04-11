# etcdv3

ETCDv3是一个K/V存储的分布式数据库，采用Go语言编写，具有良好的跨平台特性，支持集群，集群间通信采用Raft算法实现 

[etcdv3官方介绍](https://coreos.com/etcd/ "etcdv3")

## Go

Go语言的工具安装请参见官方文档[Go install](https://golang.org/doc/install)，需要注意的是，必须设置以下两个环境变量，并且加入PATH中

+ GOROOT - Go工具的安装路径
+ GOPATH - Go的workspace，go语言与github结合比较紧密，利用go命令可以直接从github上下载代码到该目录, 并且自动编译安装，具体可参见[Go write code](https://golang.org/doc/code.html). 务必仔细阅读

## etcdv3安装

社区提供了三种安装方式，其中第一种不需要Go环境，另外两种都需要，但是仍然建议设置go环境，因为后续的很多工作都需要依赖go，具体安装方式参见社区文档
[downloading and building](https://github.com/coreos/etcd/blob/master/Documentation/dl_build.md)

本地集群启动 [Setting up local clusters](https://github.com/coreos/etcd/blob/master/Documentation/dev-guide/local_cluster.md)

## etcdv3交互方式

`
[root@localhost bin]# ./etcdctl put a 1
No help topic for 'put'
[root@localhost bin]# export ETCDCTL_API=3
[root@localhost bin]# ./etcdctl put a 1   
OK
[root@localhost bin]# ./etcdctl put a 2
OK
[root@localhost bin]# ./etcdctl put a 3
OK
[root@localhost bin]# ./etcdctl get a -w=json
{"header":{"cluster_id":17237436991929493444,"member_id":9372538179322589801,"revision":9,"raft_term":2},"kvs":[{"key":"YQ==","create_revision":7,"mod_revision":9,"version":3,"value":"Mw=="}],"count":1}
[root@localhost bin]# ./etcdctl del a
1
[root@localhost bin]# ./etcdctl put a 4
OK
[root@localhost bin]# ./etcdctl get a -w=json
{"header":{"cluster_id":17237436991929493444,"member_id":9372538179322589801,"revision":11,"raft_term":2},"kvs":[{"key":"YQ==","create_revision":11,"mod_revision":11,"version":1,"value":"NA=="}],"count":1}
[root@localhost bin]# ./etcdctl put a 5
OK
[root@localhost bin]# ./etcdctl get a -w=json
{"header":{"cluster_id":17237436991929493444,"member_id":9372538179322589801,"revision":12,"raft_term":2},"kvs":[{"key":"YQ==","create_revision":11,"mod_revision":12,"version":2,"value":"NQ=="}],"count":1}
[root@localhost bin]# ./etcdctl get --help

`
