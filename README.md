[TOC]

# listen
java web ssh框架 英语听力练习

大致功能
## 学生
### 注册
ajax 校验用户名是否存在
### 登录
1. 校验用户名是否存在

2. 用户登录密码是否正确
    -[ ] md5加密
### 等级评定
词汇量测试
1. 常规提交 做满30s
2. 超时提交

确定等级 1 2 3
### 做题
- 练习
- 测试

根据用户评定的等级，提供相应难度的题目

一个等级25个关卡

#### 点击关卡

ajax查看历史闯关记录(点击的关卡 分页)

#### 进入做题
题目从管理员设置好的题库池中随机选取，并把选项随机

#### 提交判分
```
超过本关卡规定分数
    且 未超过 关卡总数
        当前关卡 + 1
    若 超过 关卡总数
        当前等级 + 1
        当前关卡数 = 0
没有则继续闯关
```
#### 积分

## 管理员
### 登录
### 上传题目
### 设置关卡
### 管理学生
### 数据统计
查询某个条件做题的 student
- 分页 查询条件
```sql
select
  max(score) as score,
  lpId,
  id,
  stuId
from sysstudentlibrarypool
where stuId in (select distinct (stuId)
                from sysstudentlibrarypool
                where 1 = 1
                    and stuId = (select id from student where student.name = 'exler'))
      and lpId = 1
group by lpId, stuId
order by score desc;
```

1. 子查询中取 学生id(有条件时取单个，没有条件时取所有的学生id)
2. 根据关卡 学生id 分组，然后进行分数排序(取分数最大的)，也可以添加各种条件(指定关卡，指定时间戳等)
3. 就能查询每关的每个学生的最大分数

能根据用户名 做题时间 等级 关卡 找出每个人符合条件的做题最高分(默认)
- 导出 Excel

### 创建件一个 Result类
-[ ] 用于返回数据
