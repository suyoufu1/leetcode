# 左连接 将左边的数据展示出来，不包括公共部分
select  a.name b.state from a left join b where a.id = b.id;
# 先选出最大的，再选出第二大的
    select MAX(salary) from A #选出最大的
    # 把最大的作为选出第二大的条件即可
    select MAX(salary) secondHightSalary from A where salary < (select MAX(salary) from A);
#超过经理收入的员工
select e.name from Employee e join Employee m on e.manageId = m.id where e.salary > m.salary
#查找重复的电子邮箱 group by 和 having 一起使用 WHERE ，关键字无法与聚合函数一起使用。
select Email from person group by Email having count(*)>1
select * from person where name in (select name from person group by name having count(*)>0);
select * from person p where (select count(*) from person e where e.name = p.name)>1;
#从不订购的客户
select name from customer c left join oder o on c.id = o.customerId where o.customerId is null ;
#上升的温度 内连接
select * from weather w1 join weather w2 on
DateDiff(w1.RecordDate,w2.RecordDate) == 1 where w1.Temperature > w2.Temperature;
#大的国家
select name,population,area from world where area > 30000000 or population > 25000000;

