# dsbenchmarkToetcd

```
{
  "test-exec": {
    "outer-list": [
      {
        "id": 4,
        "inner-list": [
          {
            "name": 0,
            "value": "Item-4-0"
          },
          {
            "name": 2,
            "value": "Item-4-2"
          },
          {
            "name": 1,
            "value": "Item-4-1"
          }
        ]
      },
      {
        "id": 0,
        "inner-list": [
          {
            "name": 0,
            "value": "Item-0-0"
          },
          {
            "name": 2,
            "value": "Item-0-2"
          },
          {
            "name": 1,
            "value": "Item-0-1"
          }
        ]
      },
      {
        "id": 1,
        "inner-list": [
          {
            "name": 0,
            "value": "Item-1-0"
          },
          {
            "name": 2,
            "value": "Item-1-2"
          },
          {
            "name": 1,
            "value": "Item-1-1"
          }
        ]
      },
      {
        "id": 2,
        "inner-list": [
          {
            "name": 0,
            "value": "Item-2-0"
          },
          {
            "name": 2,
            "value": "Item-2-2"
          },
          {
            "name": 1,
            "value": "Item-2-1"
          }
        ]
      },
      {
        "id": 3,
        "inner-list": [
          {
            "name": 0,
            "value": "Item-3-0"
          },
          {
            "name": 2,
            "value": "Item-3-2"
          },
          {
            "name": 1,
            "value": "Item-3-1"
          }
        ]
      }
    ]
  }
}

```

```
[root@localhost bin]# ./etcdctl get --prefix t
test-exec/outer-list/0/id
0
test-exec/outer-list/0/inner-list/0
Item-0-0
test-exec/outer-list/0/inner-list/1
Item-0-1
test-exec/outer-list/0/inner-list/2
Item-0-2
test-exec/outer-list/3/id
3
test-exec/outer-list/3/inner-list/0
Item-3-0
test-exec/outer-list/3/inner-list/1
Item-3-1
test-exec/outer-list/3/inner-list/2
Item-3-2
[root@localhost bin]# 
[root@localhost bin]# 
```
