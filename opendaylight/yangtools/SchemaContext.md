# SchemaContext

SchemaContext是根据Yang文件定义生成的框架，类似于工程建筑搭建的钢结构框架是根据设计图纸而来的一样  

Yang文件定义的所有内容经过解析后会生成相应的SchemaContext, SchemaContext和Yang文件应该是1：1的对应关系

| schema                | impl                             |type                 | Description                         |
|-----------------------|----------------------------------|---------------------|-------------------------------------|
| LeafSchemaNode        |LeafEffectiveStatementImpl        |a leaf               |                                     |
| LeafListSchemaNode    |LeafListEffectiveStatementImpl    |leaf-list            |                                     |
| ListSchemaNode        |ListEffectiveStatementImpl        |list                 |                                     |
