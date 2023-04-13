dalcon.sql
create table dalemp(empid number, empname varchar2(20));

select * from dalemp;
----------------------------------------------------------------------------------------------------------
select * from emp;
select empno,ename from emp;  -- select column name
select empno,ename,sal from emp;

--as is optional
select empno,ename,sal as salary from emp;   
select empno,ename,sal "Annual salary" from emp;   -- alias shd b enclosed within "  "

select empno,ename,sal  "Annual salary" from emp;
select empno, ename, sal, sal+200 Bonus from emp;  -- accepts expr

select distinct deptno from emp;
select distinct deptno,sal, ename from emp;
-- adding string litral using '  ' . Concatination operator is ||
select ename ||' works for   ' || mgr  "manager Details" from emp;

select ename || q'[work's for]'  || mgr  "manager Details" from emp;

describe emp;  -- gives table structure
desc emp;
-- Datas are case sensitive
select empNO,ename,sal as salary from emp where ename='SMITH';   
select empno,ename,sal as salary,job  from emp where ename='SMITH' and  job='CLERK' ;   
select empno,ename,sal as salary,job  from emp where ename='SMITH' or  sal>2500 ;   
-- between and - incl of the range
select empno,ename,sal as salary,job  from emp where sal  between 1000 and 3000;

-- like - pattern matching   %   _
select empno,ename,sal as salary,job  from emp where ename not like 'A%';
select empno,ename,sal as salary,job  from emp where ename like  '_A%';
select empno,ename,sal as salary,job  from emp where ename like '%N';


select empno,ename,sal as salary,job  from emp where sal not between 1000 and 3000;

select empno,ename,sal as salary,job  from emp where ename not like 'A%';
select empno,ename,sal as salary,job  from emp where ename like  '_A%';
select empno,ename,sal as salary,job  from emp where ename like '%N';
--*************************
select empno,ename,sal as salary,job,deptno  from emp where deptno  in(10,20);
select empno,ename,sal as salary,job,deptno  from emp where deptno=10 or deptno=20;

select empno,ename,sal as salary,job,deptno,comm  from emp where comm is not null;

-- sorting
select empno,ename,sal as salary,job,deptno,comm  from emp order by ename desc;-- column name in order by

select empno,ename en,sal as salary,job,deptno,comm  from emp order by 2 ; -- column position in select list in order by
select empno,ename en,sal as salary,job,deptno,comm  from emp order by en ; -- alias name in order by
select empno,ename en,sal as salary,job,deptno,comm  from emp where sal >1000 order by en; 

select &en from emp;

select &enae from &etab where &s=&val; -- substitution variables
select ename from emp where sal=3000;

select &&ena from &etab where &s=&var;  --will prompt only once when varia prefixed with &&

--Functions:
select lower(ename) from emp;
select upper('hello') from dual;  -- dual is a dummy table with one cell
select initcap(ename) from emp;

select concat('Sakshi','Shri') from dual;
select length('Sakshi ') from dual;
select instr('sakshi ', 's') from dual;
select  ename, substr(ename,1,3) from emp;
select  ename, substr(ename,3) from emp;

select replace('ambrtam','am','jj') from dual; -- consider the string
select translate('ambrtam','amb','bo4') from dual; -- consider the character

select length('     hei     ') from dual;
select length(trim('     hei     ')) from dual;
select lpad('Hello',10,'#') from dual;
select rpad('Hello',10,'#') from dual;

select chr(66) from dual;
select ascii('B') from dual;


select ROUND(45.926, 2) from dual;
select ROUND(45.966, 1) from dual;
select ROUND(45.926, 0) from dual;
select ROUND(44.926, -1) from dual;
select ROUND(45.926, -1) from dual;
select ROUND(445.926, -2) from dual;


select trunc(45.926, 2) from dual;
select trunc(45.926, 1) from dual;
select trunc(45.926, 0) from dual;
select trunc(45.926, -1) from dual;
select trunc(45.926, -2) from dual;
select mod(1600,400) from dual;

select sysdate from dual;  -- Date format DD-MON-RR   (DD-MM-RR)
select current_timestamp from dual;

select round('06-Jan-21','year') from dual;
select round('06-Jan-21','month') from dual;
select trunc('06-Jan-21','year') from dual;
select trunc('06-Jan-21','month') from dual;

select round('26-Jan-21','year') from dual;
select round('26-Jan-21','month') from dual;
select trunc('26-Jan-21','year') from dual;
select trunc('26-Jan-21','month') from dual;

select round('06-Jul-21','year') from dual;
select round('06-Jul-21','month') from dual;
select trunc('06-Jul-21','year') from dual;
select trunc('06-Jul-21','month') from dual;

select round('26-Jul-21','year') from dual;
select round('26-Jul-21','month') from dual;
select trunc('26-Jul-21','year') from dual;
select trunc('26-Jul-21','month') from dual;

select round(to_date('15-Jun-21'),'year') from dual;
select round('15-Jun-21','month') from dual;
select trunc('15-Jun-21','year') from dual;
select trunc('15-Jun-21','month') from dual;  --Ans:



select  to_char(sysdate,'MONTH DD, YEAR') from dual;
select  to_char(sysdate,'MON DD, YYYY') from dual;
select  to_char(sysdate,'MON DD, YY DAY') from dual;
select  to_char(sysdate,'dd/mm/yy') from dual;
select  to_char(sysdate,'dd-mm-yy') from dual;

select  to_char(sysdate,'ddspth "of" Mon yy') from dual;

select  to_char(sysdate,'fmDDth "of" Mon yy hh24:mi:ss') from dual;

-- https://docs.oracle.com/cd/B28359_01/olap.111/b28126/dml_commands_1029.htm#OLADM780

select to_char(to_date('21-apr-1972'),'ddth "of" mon YYYY') from dual;

select to_char(hiredate,'ddth "of" Mon YYYY') from emp;

select to_char(sal,'$99,999.000') from emp;

select to_number('1000') from dual;

select '10000'||'200' from dual;
select 10000+20 from dual;
---------------------------------------------------------------------------


-- Group functions  - ignores NULL values

select sum(sal),count(*),min(sal),max(sal),avg(sal) from emp;
select count(comm) from emp;
select count(nvl(comm,1)) from emp ;
 
 
 
 --group by clause  -- to create subgroups
 
 Rules:
1) Columns in the select list shd be there in group by clause
   select job,deptno from emp group by deptno,job;

2) Columns in the group by clause may or may not be there in the select list
 	 select job from emp group by deptno,job;


3) Alias name cannot be used in group by
	 select deptno en from emp group by deptno;

4) group by results in unique values/results
	select deptno from emp group by deptno;


5) The columns in the select list within group function may or maynot be there in group by clause.
	select min(sal),deptno from emp group by deptno;


6) To restrict the no.of rows in the group use having clause
	select min(sal),deptno from emp group by deptno having deptno=20;


7) The column used in having clause shd be used in group by clause.
	select min(sal),deptno from emp group by deptno,sal having sal>1000;

8) If the column in the having clause is within the group function , then it
may or maynot be in the group by clause.
	select min(sal),deptno from emp group by deptno having min(sal)>900;

9) Having clause cannot accept alias name.
	select min(sal),deptno  from emp group by deptno dn having dn=30;

10) Cannot use group function with where clause
	select sal,deptno from emp where min(sal)>=950 

--Joins
---------
  -- TO retrive columns from more than one table
  -- Types:
         -- Natural join
         -- Equi join
         -- Outer join
               -- Left outer join
               -- Right outer join
               -- Full outer join
        -- self join
        -- cross join




Natural join  --  it is a type of equi join where the equality condition is taken implicity
--column used in NATURAL join cannot have qualifier

select e.ename,e.job,e.sal,e.deptno,d.dname from emp e natural join dept d;

--Where clause shd be given after join condition.
select ename,job,sal,deptno,dname from emp join dept using(deptno) where job like 'SALESMAN';

-- For applying the join condition use on NOT where.
select e.ename,e.job,e.sal,d.deptno,d.dname from emp e  join dept d on e.deptno=d.deptno where job like 'MANAGER';

select e.ename,e.job,e.sal,e.deptno,d.dname from emp e  join dept d on e.deptno>20;


select e.ename,e.job,e.sal,e.deptno,d.dname from emp e  full outer join dept d on e.deptno=d.deptno;

select m.ename || '  is the manager of  ' || e.ename "Manager Details" from emp  e join emp m
on  m.empno = e.mgr;

select e.ename,e.deptno,d.dname from emp e cross join dept d;

---------------------------------
--Subquery

1) Write a query to find the salary of the employees whose salary is greater than the salary of the employee
whose id is 7566?
select ename,sal from emp where sal>(select sal from emp where empno=7566);

2) Write a query to find the employees who all are earning the highest salary?
select ename,sal from  emp where sal = (select max(sal) from emp);

second highest salary?
select max(sal) from  emp where sal< (select max(sal) from emp);

Multiple row subquery:
-- operators used here is IN , ANY, ALL

<ANY   => <MAX
> ANY => >MIN
=ANY  => IN
>ALL  =>  >MAX
<ALL  =>  <MIN

1) Write a query to find the employees whose salary is equal to the salary of atleast one employee in depart 30?
select empno,ename,deptno,sal from emp where sal in(select distinct sal from emp where deptno=30);

2) Write a query to find the employees whose salary is greater than the salary of atleast one employee in depart 30?
select empno,ename,deptno,sal from emp where sal >ANY(select sal from emp where deptno=30);

select sal from emp where deptno=30;

3) Write a query to find the employees whose salary is less  than the salary of atleast one employee in depart 30?
select empno,ename,deptno,sal from emp where sal <ANY(select sal from emp where deptno=30);


4) Write a query to find the employees whose salary is less  than the salary of all of the employee in depart 30?
select empno,ename,deptno,sal from emp where sal <ALL(select sal from emp where deptno=30);

Multiple Column subquery:
select empno,ename,mgr,deptno from emp where (mgr,deptno) in
(select mgr,deptno from emp where empno in(7566,7788));


7566  7839
select mgr,deptno from emp where empno in(7566,7788)

Corelated subquery:
-----------------------
-- For each and every excution of the subquery , the outer query will be executed.
-- The sub query is executed for each row of the main query.

select ename , (select d.dname from dept d where d.deptno =e.deptno) dname from emp e;

1.Write a query to list the department names which have at least one employee.

select dname from dept d where exists (select 1  from emp e where e.deptno=d.deptno);


--today tasks:

24. Display the details of Blake.
select * from emp where ename='BLAKE'

25. List all Clerks.

select ename,job from emp where job='CLERK' ;

26. List all emps joined on 1 may 1981.
select * from emp where hiredate='01-MAY-1981'









