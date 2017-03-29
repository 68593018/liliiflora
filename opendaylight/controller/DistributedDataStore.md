# DistributedDataStore

如果需要将其它数据库通过插件形式集成到ODL中，则需要参考此文档[Wiki MD-SAL](https://wiki.opendaylight.org/view/OpenDaylight_Controller:MD-SAL:Architecture:DOM_DataStore:Plugging_in_a_Datastore_into_MD-SAL)相应的API及其SPI 

![MDSAL](DS-Plugin.jpg)

## DataSto简介

ODL的DataStore设计为插件方式集成到MDSAL中，用户可以根据自己的需要替换为自己的数据库插件，Controller项目的DataStore插件有以下两种  

+ DistributedDataStore

+ InMemoryDOMDataStore
