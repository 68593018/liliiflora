# NormalizedNode

## Yang Language

This is [RFC6020](https://tools.ietf.org/html/rfc6020) about Yang - A Data Modeling Language

## Normalized DOM Model

This is [opendaylight wiki](https://wiki.opendaylight.org/view/OpenDaylight_Controller:MD-SAL:Design:Normalized_DOM_Model) about NormalizedNode Dom Model


| YANG concept    | NormalizedNode      |type                 | Description                         |
|-----------------|---------------------|---------------------|-------------------------------------|
| container       |ContainerNode        |a leaf               |容器节点,内容为DataContainerChild集合  |
| leaf            |LeafNode             |a leaf               |单个叶子节点                          |
| leaf-list       |LeafSetNode          |Special node         |多个叶子节点                          |
|                 |LeafSetEntryNode     |a leaf               |leaf-list实例                        |
| list            |MapNode              |Special node         |List内部元素为MapEntryNode            |
| list            |UnkeyedListNode      |Special node         |List内部元素为UnkeyedListEntryNode    |
|                 |MapEntryNode         |a leaf               |List实例                             |
|                 |UnkeyedListEntryNode |a leaf               |List实例                             |
| choice          |ChoiceNode           |a leaf               ||

**NormalizedNode内容完全根据Yang定义生成, 可以与XML及其JSON进行无缝转换, 如果要转换成其它自定义格式，需要实现NormalizedNodeStreamWriter接口**  
*例如JSONNormalizedNodeStreamWriter则实现了转换为JSON， XMLStreamNormalizedNodeStreamWriter则实现了转换为XML*  

YangTools整体实现相对比较复杂，JSON转换参见 [JSON To NormalizedNode](https://github.com/opendaylight/yangtools/tree/master/yang/yang-data-codec-gson)  XML转换参见[XML To NormalizedNode](https://github.com/opendaylight/yangtools/tree/master/yang/yang-data-codec-xml)

| NormalizedNode     | build                             |type                 | Description                  |
|--------------------|-----------------------------------|---------------------|------------------------------|
| LeafNode           |ImmutableLeafNodeBuilder           |a leaf               |                              |
| LeafSetEntryNode   |ImmutableLeafSetEntryNodeBuilder   |leaf-list instance   |NodeWithValue作为Identifier   |
| MapNode            |ImmutableMapNodeBuilder            |list                 |                              |
| LeafSetNode        |ImmutableLeafSetNodeBuilder        |leaf-list            |                              |

## NormalizedNode遍历
ODL的社区提供了相应的遍历类及其业务需要实现的接口

- NormalizedNodeNavigator - ODL提供的遍历类
- NormalizedNodeVisitor - 业务需要实现的遍历接口

## 根据Yang的SchemaContext构建NormalizedNode

BuilderTest.java构建NormalizedNode
