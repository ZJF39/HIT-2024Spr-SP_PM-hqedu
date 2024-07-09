# 哈工大2024春季学期 软件过程与项目管理课设
## 浩奇HQ培训信息管理系统

## [接口文档点此跳转](#接口文档)

**项目结构：**
- [x] 培训申请管理
- [x] 培训课程管理
- [x] 讲师管理
- [x] 学员管理
- [x] 课程报名管理（学生个人）
- [x] 培训评价管理
- [x] 培训过程管理
- [x] 数据统计
- [x] 企业用户管理
- [x] 登录服务(管理员、学员、企业用户)

### 2024.7.9更新  
上述后端需求全部实现，数据统计及培训过程管理部分不在该仓库维护  

### 2024.7.5更新
实现根据课程展示学员信息功能 可根据审批通过名单自动更新  

### 2024.7.2更新
实现培训评价管理 增删查  

### 2024.7.1更新
实现课程报名管理 增删查及审批通过申请功能  
遗留问题：课程暂未与学员关联，考虑增加功能：培训申请通过后课程自动与学员关联  

### 2024.6.30更新  
实现培训申请管理 增删查
实现培训课程管理 增删改查

### 2024.6.29更新  
完成了企业管理系统，实现增删改查服务。  

### 2024.6.28更新  
完成了讲师管理系统，实现增删改查服务。

### 2024.6.27更新
完善了学员信息管理系统  
实现了批量删除学员信息、按所给字段插入学员信息、根据姓名模糊查询学员信息并分页显示。

### 2024.6.26更新
实现了初版学员信息管理  
能够对学员信息进行增删改查服务。  
要求字段严格。

---
### 接口文档目录<span id="接口文档"></span>
---
[1 查询学员信息接口](#1)  
[2 删除学员信息接口](#2)  
[3 修改学员信息接口](#3)  
[4 新增学员信息接口](#4)  

---

[5 查询讲师信息接口](#5)  
[6 删除讲师信息接口](#6)  
[7 修改讲师信息接口](#7)  
[8 新增讲师信息接口](#8)  

---
[9 查询企业信息接口](#9)  
[10 删除企业信息接口](#10)  
[11 修改企业信息接口](#11)  
[12 新增企业信息接口](#12)  

---
[13 查询培训申请信息接口](#13)  
[14 删除培训申请信息接口](#14)  
[15 新增培训申请信息接口](#15)  

---
[16 查询课程信息接口](#16)  
[17 删除课程信息接口](#17)  
[18 修改课程信息接口](#18)  
[19 新增课程信息接口](#19)  

---
[20 查询课程申请信息接口](#20)  
[21 删除课程申请表信息接口](#21)  
[22 审批通过课程申请接口](#22)  
[23 新增课程申请表信息接口](#23)  

---
[24 查询课程评价信息接口](#24)  
[25 删除课程评价信息接口](#25)  
[26 新增课程评价信息接口](#26)  

---
[27 根据课程查询学员信息接口](#27)  

---
[28 查询学员及通讯信息并输出为excel接口](#27)  





---
<p id="1"></p> 

**1\. 查询学员信息** 
###### 接口功能
> 获取学员信息并分页展示（默认显示第一页，每页显示10条记录），可根据姓名模糊查询

###### URL
> [http://localhost:8080/stu/showpages](http://localhost:8080/stu/showpages)

###### 支持格式
> 请求头参数

###### HTTP请求方式
> GET

###### 请求参数
> | 参数 | 必选 | 类型 | 说明 |
>|:-----  |:------- |:-----|----- |
>|page    |false    |int |页码 |
>|pageSize    |false    |int   |每页展示信息条数 |
>|name    |false    |String   |姓名(模糊查询) |

###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |list |学员信息及查询到的信息总条数total    |

###### 接口示例
> 地址：[http://localhost:8080/stu/showpages?page=1&pageSize=5&name=小](http://localhost:8080/stu/showpages?page=1&pageSize=5)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": {
        "total": 11,
        "rows": [
            {
                "id": 1,
                "username": "xiaoming",
                "password": "123456",
                "name": "小明",
                "telNum": "12345678989"
            },
            {
                "id": 2,
                "username": "gangxiao",
                "password": "123456",
                "name": "刚小",
                "telNum": "11122233345"
            },
            {
                "id": 3,
                "username": "xiaowang",
                "password": "123451",
                "name": "小王",
                "telNum": "12345678901"
            },
            {
                "id": 4,
                "username": "xiaohong",
                "password": "123456",
                "name": "小红",
                "telNum": "12345678891"
            },
            {
                "id": 5,
                "username": "xiaolv",
                "password": "123456",
                "name": "小绿",
                "telNum": "12345678891"
            }
        ]
    }
}
``` 

---
<p id="2"></p> 

**2\. 删除学员信息**
###### 接口功能
> 可批量删除/单条删除学员信息数据

###### URL
> [http://localhost:8080/stu/delete/{ids}](http://localhost:8080/stu/delete/{ids})

###### 支持格式
> 请求头参数

###### HTTP请求方式
> Delete

###### 请求参数
> |参数|必选|类型|说明|
> |:-----  |:-------|:-----|----- |
> |ids    |true    |list |删除的学员id列表 |

###### 返回字段
> |返回字段|字段类型|说明                              |
> |:-----   |:------|:-----------------------------   |
> |code   |int    |返回结果状态。1：正常；其他：错误。   |
> |msg  |string | “success”                      |
> |data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/stu/delete/12,13](http://localhost:8080/stu/delete/12,13)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="3"></p> 

**3\. 修改学员信息**
###### 接口功能
> 根据修改传入数据内容，修改指定id的学员信息数据

###### URL
> [http://localhost:8080/stu/update](http://localhost:8080/stu/update)

###### 支持格式
> Json

###### HTTP请求方式
> Put

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|id    |true    |int |要修改的学员id |
>|username    |false    |String |修改后的用户名 |
>|password    |false   |String |修改后的密码 |
>|name    |false    |String |修改后的姓名 |
>|telNum    |false    |String |修改后的电话号码(限制11位) |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/stu/update](http://localhost:8080/stu/update)
``` json
{
    "id":2,
    "username":"gangxiao",
    "name":"刚小",
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="4"></p> 

**4\. 新增学员信息**
###### 接口功能
> 根据所填数据新增学员信息

###### URL
> [http://localhost:8080/stu/add](http://localhost:8080/stu/add)

###### 支持格式
> Json

###### HTTP请求方式
> Post

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|username    |true    |String |新增学员用户名 |
>|password    |true   |String |新增学员密码 |
>|name    |true    |String |新增学员姓名 |
>|telNum    |false    |String |新增学员的电话号码(限制11位，可为null) |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/stu/add](http://localhost:8080/stu/add)
``` json
{
    "username":"dachu",
    "password":"123456",
    "name":"大厨",
    "telNum":"11122233345"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 


---
<p id="5"></p> 

**5\. 查询讲师信息** 
###### 接口功能
> 获取讲师信息并分页展示（默认显示第一页，每页显示10条记录），可根据姓名模糊查询

###### URL
> [http://localhost:8080/tea/show](http://localhost:8080/tea/show)

###### 支持格式
> 请求头参数

###### HTTP请求方式
> GET

###### 请求参数
> | 参数 | 必选 | 类型 | 说明 |
>|:-----  |:------- |:-----|----- |
>|page    |false    |int |页码 |
>|pageSize    |false    |int   |每页展示信息条数 |
>|name    |false    |String   |姓名(模糊查询) |

###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |list |讲师信息及查询到的信息总条数total    |

###### 接口示例
> 地址：[http://localhost:8080/tea/show?page=1&pageSize=10&name=张](http://localhost:8080/tea/show?page=1&pageSize=10&name=张)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": {
        "total": 2,
        "rows": [
            {
                "id": 2,
                "name": "张老师",
                "salary": 3000,
                "age": 48,
                "sex": 2
            },
            {
                "id": 11,
                "name": "张力",
                "salary": 2333,
                "age": 24,
                "sex": 2
            }
        ]
    }
}
``` 

---
<p id="6"></p> 

**6\. 删除讲师信息**
###### 接口功能
> 可批量删除/单条删除讲师信息数据

###### URL
> [http://localhost:8080/tea/delete/{ids}](http://localhost:8080/tea/delete/{ids})

###### 支持格式
> 请求头参数

###### HTTP请求方式
> Delete

###### 请求参数
> |参数|必选|类型|说明|
> |:-----  |:-------|:-----|----- |
> |ids    |true    |list |删除的讲师id列表 |

###### 返回字段
> |返回字段|字段类型|说明                              |
> |:-----   |:------|:-----------------------------   |
> |code   |int    |返回结果状态。1：正常；其他：错误。   |
> |msg  |string | “success”                      |
> |data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/tea/delete/12,13](http://localhost:8080/tea/delete/12,13)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="7"></p> 

**7\. 修改讲师信息**
###### 接口功能
> 根据修改传入数据内容，修改指定id的讲师信息数据

###### URL
> [http://localhost:8080/tea/update](http://localhost:8080/tea/update)

###### 支持格式
> Json

###### HTTP请求方式
> Put

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|id    |true    |int |要修改的讲师id |
>|name    |false    |String |修改后的姓名 |
>|salary    |false   |int |修改后的薪水 |
>|age    |false    |int |修改后的年龄 |
>|sex    |false    |int |修改后的性别（1男2女） |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/tea/update](http://localhost:8080/tea/update)
``` json
{
    "id":2,
    "name":"刚小"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="8"></p> 

**8\. 新增讲师信息**
###### 接口功能
> 根据所填数据新增讲师信息

###### URL
> [http://localhost:8080/tea/add](http://localhost:8080/tea/add)

###### 支持格式
> Json

###### HTTP请求方式
> Post

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|name    |true    |String |新增讲师姓名 |
>|salary    |true   |int |新增讲师薪水 |
>|age    |true    |int |新增讲师年龄 |
>|sex    |false    |int |新增讲师性别（1男2女） |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/tea/add](http://localhost:8080/tea/add)
``` json
{
    "name":"张大力",
    "salary":"2333",
    "age":"23",
    "sex":"1"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 


---
<p id="9"></p> 

**9\. 查询企业信息** 
###### 接口功能
> 获取企业信息并分页展示（默认显示第一页，每页显示10条记录），可根据企业名称模糊查询

###### URL
> [http://localhost:8080/com/show](http://localhost:8080/com/show)

###### 支持格式
> 请求头参数

###### HTTP请求方式
> GET

###### 请求参数
> | 参数 | 必选 | 类型 | 说明 |
>|:-----  |:------- |:-----|----- |
>|page    |false    |int |页码 |
>|pageSize    |false    |int   |每页展示信息条数 |
>|name    |false    |String   |企业名(模糊查询) |

###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |list |企业信息及查询到的信息总条数total    |

###### 接口示例
> 地址：[http://localhost:8080/com/show?page=1&pageSize=10&name=华](http://localhost:8080/com/show?page=1&pageSize=10&name=华)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": {
        "total": 1,
        "rows": [
            {
                "id": 1,
                "name": "华为",
                "flag": 0
            }
        ]
    }
}
``` 

---
<p id="10"></p> 

**10\. 删除企业信息**
###### 接口功能
> 可批量删除/单条删除企业信息数据

###### URL
> [http://localhost:8080/com/delete/{ids}](http://localhost:8080/com/delete/{ids})

###### 支持格式
> 请求头参数

###### HTTP请求方式
> Delete

###### 请求参数
> |参数|必选|类型|说明|
> |:-----  |:-------|:-----|----- |
> |ids    |true    |list |删除的企业id列表 |

###### 返回字段
> |返回字段|字段类型|说明                              |
> |:-----   |:------|:-----------------------------   |
> |code   |int    |返回结果状态。1：正常；其他：错误。   |
> |msg  |string | “success”                      |
> |data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/com/delete/12,13](http://localhost:8080/com/delete/12,13)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="11"></p> 

**11\. 修改企业信息**
###### 接口功能
> 根据修改传入数据内容，修改指定id的企业信息数据

###### URL
> [http://localhost:8080/com/update](http://localhost:8080/com/update)

###### 支持格式
> Json

###### HTTP请求方式
> Put

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|id    |true    |int |要修改的企业id |
>|name    |false    |String |修改后的企业姓名 |
>|flag    |false   |int |修改后的企业认证标识 |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/com/update](http://localhost:8080/com/update)
``` json
{
    "id":2,
    "name":"tencent",
    "flag":"1"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="12"></p> 

**12\. 新增企业信息**
###### 接口功能
> 根据所填数据新增企业信息

###### URL
> [http://localhost:8080/com/add](http://localhost:8080/com/add)

###### 支持格式
> Json

###### HTTP请求方式
> Post

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|name    |true    |String |新增企业姓名 |
>|flag    |false   |int |新增企业认证标识 |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/com/add](http://localhost:8080/com/add)
``` json
{
    "name":"老干妈",
    "flag":"1"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 

---
<p id="13"></p> 

**13\. 查询培训申请信息** 
###### 接口功能
> 获取培训申请并分页展示（默认显示第一页，每页显示10条记录），可根据申请名称模糊查询

###### URL
> [http://localhost:8080/train/show](http://localhost:8080/train/show)

###### 支持格式
> 请求头参数

###### HTTP请求方式
> GET

###### 请求参数
> | 参数 | 必选 | 类型 | 说明 |
>|:-----  |:------- |:-----|----- |
>|page    |false    |int |页码 |
>|pageSize    |false    |int   |每页展示信息条数 |
>|name    |false    |String   |申请名(模糊查询) |

###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |list |申请信息及查询到的信息总条数total    |

###### 接口示例
> 地址：[http://localhost:8080/train/show?page=1&pageSize=5&name=3](http://localhost:8080/train/show?page=1&pageSize=5&name=3)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": {
        "total": 2,
        "rows": [
            {
                "id": 30,
                "trainappName": "培训项目3",
                "companyName": "中兴",
                "startDate": "2024-05-10T16:00:00.000+00:00",
                "endDate": "2024-05-21T16:00:00.000+00:00"
            },
            {
                "id": 38,
                "trainappName": "培训项目13",
                "companyName": "字节",
                "startDate": "2020-12-31T16:00:00.000+00:00",
                "endDate": "2021-01-01T16:00:00.000+00:00"
            }
        ]
    }
}
``` 

---
<p id="14"></p> 

**14\. 删除申请信息**
###### 接口功能
> 可批量删除/单条删除申请信息数据

###### URL
> [http://localhost:8080/train/delete/{ids}](http://localhost:8080/train/delete/{ids})

###### 支持格式
> 请求头参数

###### HTTP请求方式
> Delete

###### 请求参数
> |参数|必选|类型|说明|
> |:-----  |:-------|:-----|----- |
> |ids    |true    |list |删除的申请id列表 |

###### 返回字段
> |返回字段|字段类型|说明                              |
> |:-----   |:------|:-----------------------------   |
> |code   |int    |返回结果状态。1：正常；其他：错误。   |
> |msg  |string | “success”                      |
> |data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/train/delete/12,13](http://localhost:8080/train/delete/12,13)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 

---
<p id="15"></p> 

**15\. 新增申请信息**
###### 接口功能
> 根据所填数据新增申请信息

###### URL
> [http://localhost:8080/train/add](http://localhost:8080/train/add)

###### 支持格式
> Json

###### HTTP请求方式
> Post

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|trainName    |true    |String |新增申请名称 |
>|companyName    |true  |String |新增公司名称 |
>|startDate    |true   |yyyy-MM-dd |新增开始日期 |
>|endDate    |true  |yyyy-MM-dd |新增结束日期 |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/train/add](http://localhost:8080/train/add)
``` json
{
    "trainName": "培训项目A",
    "startDate": "2024-07-01",
    "endDate": "2024-07-31",
    "companyName": "华为"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 

---
<p id="16"></p> 

**16\. 查询课程信息** 
###### 接口功能
> 获取课程信息并分页展示（默认显示第一页，每页显示10条记录），可根据课程名称模糊查询

###### URL
> [http://localhost:8080/course/show](http://localhost:8080/course/show)

###### 支持格式
> 请求头参数

###### HTTP请求方式
> GET

###### 请求参数
> | 参数 | 必选 | 类型 | 说明 |
>|:-----  |:------- |:-----|----- |
>|page    |false    |int |页码 |
>|pageSize    |false    |int   |每页展示信息条数 |
>|name    |false    |String   |课程名(模糊查询) |

###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |list |课程信息及查询到的信息总条数total    |

###### 接口示例
> 地址：[http://localhost:8080/course/show?page=1&pageSize=5&name=机](http://localhost:8080/course/show?page=1&pageSize=5&name=机)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": {
        "total": 2,
        "rows": [
            {
                "id": 7,
                "teacherName": "聂老师",
                "startDate": "2023-12-31T16:00:00.000+00:00",
                "endDate": "2024-01-30T16:00:00.000+00:00",
                "courseName": "计算机组成原理"
            },
            {
                "id": 10,
                "teacherName": "郑老师",
                "startDate": "2023-12-31T16:00:00.000+00:00",
                "endDate": "2024-01-30T16:00:00.000+00:00",
                "courseName": "自动机"
            }
        ]
    }
}
``` 

---
<p id="17"></p> 

**17\. 删除课程信息**
###### 接口功能
> 可批量删除/单条删除课程信息数据

###### URL
> [http://localhost:8080/course/delete/{ids}](http://localhost:8080/course/delete/{ids})

###### 支持格式
> 请求头参数

###### HTTP请求方式
> Delete

###### 请求参数
> |参数|必选|类型|说明|
> |:-----  |:-------|:-----|----- |
> |ids    |true    |list |删除的课程id列表 |

###### 返回字段
> |返回字段|字段类型|说明                              |
> |:-----   |:------|:-----------------------------   |
> |code   |int    |返回结果状态。1：正常；其他：错误。   |
> |msg  |string | “success”                      |
> |data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/course/delete/15,14](http://localhost:8080/course/delete/15,14)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="18"></p> 

**18\. 修改课程信息**
###### 接口功能
> 根据修改传入数据内容，修改指定id的课程信息数据

###### URL
> [http://localhost:8080/course/update](http://localhost:8080/course/update)

###### 支持格式
> Json

###### HTTP请求方式
> Put

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|id    |true    |int |要修改的课程id |
>|courseName    |false    |String |修改后的课程姓名 |
>|teacherName    |false   |String |修改后的讲师姓名 |
>|startDate    |false   |yyyy-MM-dd |修改后的开始日期 |
>|endDate    |false   |yyyy-MM-dd |修改后的结束日期 |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/course/update](http://localhost:8080/course/update)
``` json
{
    "id":"1",
    "courseName":"软件过程",
    "teacherName":"张力"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="19"></p> 

**19\. 新增课程信息**
###### 接口功能
> 根据所填数据新增课程信息

###### URL
> [http://localhost:8080/course/add](http://localhost:8080/course/add)

###### 支持格式
> Json

###### HTTP请求方式
> Post

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|courseName    |true    |String |新增课程姓名 |
>|teacherName    |true  |String |新增讲师姓名 |
>|startDate    |true    |yyyy-MM-dd |新增开始日期 |
>|endDate    |true   |yyyy-MM-dd |新增结束日期 |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/course/add](http://localhost:8080/course/add)
``` json
{
    "courseName": "课程A",
    "startDate": "2024-07-01",
    "endDate": "2024-07-31",
    "teacherName": "张力"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 

---
<p id="20"></p> 

**20\. 查询课程申请信息** 
###### 接口功能
> 获取课程申请表信息并分页展示（默认显示第一页，每页显示10条记录），可根据申请者姓名进行模糊查询

###### URL
> [http://localhost:8080/stuapp/show](http://localhost:8080/stuapp/show)

###### 支持格式
> 请求头参数

###### HTTP请求方式
> GET

###### 请求参数
> | 参数 | 必选 | 类型 | 说明 |
>|:-----  |:------- |:-----|----- |
>|page    |false    |int |页码 |
>|pageSize    |false    |int   |每页展示信息条数 |
>|name    |false    |String   |姓名(模糊查询) |

###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |list |课程申请表信息及查询到的信息总条数total    |

###### 接口示例
> 地址：[http://localhost:8080/stuapp/show?page=1&pageSize=5&name=明](http://localhost:8080/stuapp/show?page=1&pageSize=5&name=明)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": {
        "total": 3,
        "rows": [
            {
                "id": 1,
                "stuName": "小明",
                "courseName": "软件过程"
            },
            {
                "id": 2,
                "stuName": "小明",
                "courseName": "数学"
            },
            {
                "id": 3,
                "stuName": "小明",
                "courseName": "英语"
            }
        ]
    }
}
``` 
---
<p id="21"></p> 

**21\. 删除课程申请表信息**
###### 接口功能
> 可批量删除/单条删除课程申请表信息数据

###### URL
> [http://localhost:8080/stuapp/delete/{ids}](http://localhost:8080/stuapp/delete/{ids})

###### 支持格式
> 请求头参数

###### HTTP请求方式
> Delete

###### 请求参数
> |参数|必选|类型|说明|
> |:-----  |:-------|:-----|----- |
> |ids    |true    |list |删除的申请表id列表 |

###### 返回字段
> |返回字段|字段类型|说明                              |
> |:-----   |:------|:-----------------------------   |
> |code   |int    |返回结果状态。1：正常；其他：错误。   |
> |msg  |string | “success”                      |
> |data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/stuapp/delete/15,14](http://localhost:8080/stuapp/delete/15,14)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="22"></p> 

**22\. 审批通过课程申请**
###### 接口功能
> 根据传入id，将指定id的申请表状态修改为已通过

###### URL
> [http://localhost:8080/stuapp/update](http://localhost:8080/stuapp/update)

###### 支持格式
> Json

###### HTTP请求方式
> Put

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|id    |true    |int |要修改的申请表id |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/stuapp/update](http://localhost:8080/stuapp/update)
``` json
{
    "id":"1"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="23"></p> 

**23\. 新增申请表信息**
###### 接口功能
> 根据所填数据新增申请表信息

###### URL
> [http://localhost:8080/stuapp/add](http://localhost:8080/stuapp/add)

###### 支持格式
> Json

###### HTTP请求方式
> Post

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|stuName    |true    |String |新增申请者姓名 |
>|courseName    |true  |String |新增申请课程名称 |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[http://localhost:8080/stuapp/add](http://localhost:8080/stuapp/add)
``` json
{
    "stuName":"小明",
    "courseName":"数学"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 


---
<p id="24"></p> 

**24\. 查询培训评价信息** 
###### 接口功能
> 获取培训评价信息并分页展示（默认显示第一页，每页显示10条记录），可根据学员姓名/课程名模糊查询

###### URL
> [localhost:8080/eva/show](localhost:8080/eva/show)

###### 支持格式
> 请求头参数

###### HTTP请求方式
> GET

###### 请求参数
> | 参数 | 必选 | 类型 | 说明 |
>|:-----  |:------- |:-----|----- |
>|page    |false    |int |页码 |
>|pageSize    |false    |int   |每页展示信息条数 |
>|stuName    |false    |String   |学生姓名(模糊查询) |
>|courseName    |false    |String   |课程名(模糊查询) |

###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |list |评价信息及查询到的信息总条数total    |

###### 接口示例
> 地址：[localhost:8080/eva/show?page=1&pageSize=5&courseName=软](localhost:8080/eva/show?page=1&pageSize=5&courseName=软)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": {
        "total": 2,
        "rows": [
            {
                "id": 1,
                "stuName": "小明",
                "courseName": "软件过程",
                "eva": "非常棒",
                "rating": 5
            },
            {
                "id": 11,
                "stuName": "小橙",
                "courseName": "软件构造",
                "eva": "非常棒",
                "rating": 5
            }
        ]
    }
}
``` 

---
<p id="25"></p> 

**25\. 删除培训评价信息**
###### 接口功能
> 可批量删除/单条删除培训评价信息数据

###### URL
> [localhost:8080/eva/delete/{ids}](localhost:8080/eva/delete/{ids})

###### 支持格式
> 请求头参数

###### HTTP请求方式
> Delete

###### 请求参数
> |参数|必选|类型|说明|
> |:-----  |:-------|:-----|----- |
> |ids    |true    |list |删除的培训信息id列表 |

###### 返回字段
> |返回字段|字段类型|说明                              |
> |:-----   |:------|:-----------------------------   |
> |code   |int    |返回结果状态。1：正常；其他：错误。   |
> |msg  |string | “success”                      |
> |data |null |null                        |

###### 接口示例
> 地址：[localhost:8080/eva/delete/11,12](localhost:8080/eva/delete/11,12)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 
---
<p id="26"></p> 

**26\. 新增培训评价信息**
###### 接口功能
> 根据所填数据新增培训评价信息

###### URL
> [localhost:8080/eva/add](localhost:8080/eva/add)

###### 支持格式
> Json

###### HTTP请求方式
> Post

###### 请求参数
> |参数|必选|类型|说明|
>|:-----  |:-------|:-----|----- |
>|stuName    |true    |String |评价学员名 |
>|courseName    |true   |String |评价课程名 |
>|eva    |true    |String |评价（限制1024字） |
>|rating    |true    |int |评分（1-5） |
###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |null |null                        |

###### 接口示例
> 地址：[localhost:8080/eva/add](localhost:8080/eva/add)
``` json
{
    "stuName":"小明",
    "courseName":"自动机",
    "eva":"挺好的",
    "rating":"4"
}
``` 
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 

---
<p id="27"></p> 

**27\. 根据课程查询学员信息** 
###### 接口功能
> 根据课程获取学员信息

###### URL
> [localhost:8080/course/showstu/{id}](localhost:8080/course/showstu/{id})

###### 支持格式
> 路径参数

###### HTTP请求方式
> GET

###### 请求参数
> | 参数 | 必选 | 类型 | 说明 |
>|:-----  |:------- |:-----|----- |
>|id    |true  |int |课程id |

###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |list |  课程学员信息 | 

###### 接口示例
> 地址：[localhost:8080/course/showstu/1](localhost:8080/course/showstu/1)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": [
        {
            "id": null,
            "stuName": "小明",
            "courseName": "软件过程",
            "flag": null
        },
        {
            "id": null,
            "stuName": "刚小",
            "courseName": "软件过程",
            "flag": null
        },
        {
            "id": null,
            "stuName": "小王",
            "courseName": "软件过程",
            "flag": null
        },
        {
            "id": null,
            "stuName": "小红",
            "courseName": "软件过程",
            "flag": null
        },
        {
            "id": null,
            "stuName": "小绿",
            "courseName": "软件过程",
            "flag": null
        },
        {
            "id": null,
            "stuName": "小黃",
            "courseName": "软件过程",
            "flag": null
        }
    ]
}
``` 

---
<p id="28"></p> 

**28\. 查询某课程学员及通讯信息并输出为excel** 
###### 接口功能
> 查询某课程学员及通讯信息并输出为excel

###### URL
> [localhost:8080/expansion/generateRecipientList/{ids}](localhost:8080/expansion/generateRecipientList/{ids})

###### 支持格式
> 路径参数

###### HTTP请求方式
> GET

###### 请求参数
> | 参数 | 必选 | 类型 | 说明 |
>|:-----  |:------- |:-----|----- |
>|id    |true  |int |课程id |

###### 返回字段
> |返回字段|字段类型|说明                              |
>|:-----   |:------|:-----------------------------   |
>|code   |int    |返回结果状态。1：正常；其他：错误。   |
>|msg  |string | “success”                      |
>|data |list |  null | 

###### 接口示例
> 地址：[localhost:8080/expansion/generateRecipientList/1](localhost:8080/expansion/generateRecipientList/1)
``` javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
``` 