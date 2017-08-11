# ODL数据库设计与实现

## The OpenDaylight Architecture

OpenDaylight是一个基于MD-SAL为核心的开源控制器平台项目, 无论北向网络业务的应用还是南向适配不同设备的接口插件均以模块化的方式存在于该平台中，
并通过SAL层实现各模块之间的信息交互和数据转换.

MD-SAL的全称是Model-driven Service Abstraction Layer，即模型驱动-服务抽象层, 这里的模型即Yang文件，服务抽象层则代表了基于Yang定义的数据存储，
数据变化通告，RPC及其Notification等功能，从而在仅仅基于各个模块提供的Yang文件，不需要了解各个模块内部接口及其实现细节的情况下，实现模块间的
消息通信及其数据交互.



