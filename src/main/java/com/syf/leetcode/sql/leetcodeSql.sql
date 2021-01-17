# 查找最晚入职员工的所有信息
select * from employee order by hire_date desc limit 1;
# 查找入职员工时间排名倒数第三的员工所有信息
select * from employee order by hire_date desc limit 2,1;
# 查找各个部门当前(to_date='9999-01-01')领导当前薪水详情以及其对应部门编号dept_no之SQL实现
select s.emp_no,s.salary,s.from_date,s.to_date,d.dept_no
from salaries s left join dept_manager d on
s.emp_no = d.emp_no where s.to_date = '9999-01-01' and
d.to_date='9999-01-01' order by s.emp_no asc ;