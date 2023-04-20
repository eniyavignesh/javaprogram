Exception handling:
  --> Error which occurs during the runtime

declare
  eno emp.empno%type;
  enam emp.ename%type;
  salry emp.sal%type;
  
  v_error_code number(20);
  v_error_msg varchar2(235);
begin
    select empno,ename,sal into eno,enam,salry from emp where empno>&no;
    dbms_output.put_line('Empno :' || eno || ' Emp Name :   ' || enam  || ' Salary :   ' || salry);
    
   -- salry :=salry/0;
    --dbms_output.put_line(' Salary :   ' || salry);
    
   insert into batch210(stid,sname,deptno) values(100,'Karthik',1);
exception
     when NO_DATA_FOUND then
         dbms_output.put_line('Employee Number Does Not Exist :(');
    when ZERO_DIVIDE then
         dbms_output.put_line('Dont divide by 0');
    -- when others then
      --      v_error_code:=SQLCODE;
        --    v_error_msg :=SQLERRM;
          -- dbms_output.put_line('Plz contact Admin to resolve error with code ' || v_error_code || ' and msg ' ||  v_error_msg);         
end;
/

set verify off;
--The functions SQLCODE and SQLERRM are especially useful in the OTHERS handler
--because they return the Oracle error code and message text. 

-----------------------------------------------------------
User Defined Exception:
-----------------------------------
1) Declare the Exception
2) Raise the exception
3) Handle the exception

declare
    eno emp.empno%type;
    enam emp.ename%type;
    emp_not_found EXCEPTION;   -- Declare
begin
    eno :=&no;
    if eno>9000 then
       RAISE emp_not_found;             -- Raise
    else
       select ename into enam from emp where empno=eno;
        dbms_output.put_line('Ename : '|| enam);
    end if;
exception
     when emp_not_found then            --handle
         dbms_output.put_line('Emp Number  : '|| eno || ' not found ');
end;
/
---------------------------

Procedure raise_application_error(error_number, message[, {TRUE | FALSE}]);

where error_number is a negative integer in the range -20000 .. -20999 and 
message is a character string up to 2048 bytes long.

declare
    eno emp.empno%type;
    enam emp.ename%type;
    emp_not_found EXCEPTION;   -- Declare
begin
    eno :=&no;
    if eno>9000 then
       RAISE_APPLICATION_ERROR(-20456,'NOT  A VALID EMPLOYEE NUMBER');             -- Raise
    else
       select ename into enam from emp where empno=eno;
        dbms_output.put_line('Ename : '|| enam);
    end if;
exception
     when emp_not_found then            --handle
         RAISE_APPLICATION_ERROR(-20456,'NOT  A VALID EMPLOYEE NUMBER');  
         dbms_output.put_line('Emp Number  : '|| eno || ' not found ');
end;
/
select * from emp;

---------------------------------------------------------------------
PRAGMA EXCEPTION
------------------------------------

declare
  eno emp.empno%type;
  enam emp.ename%type;
  salry emp.sal%type;
  
  v_error_code number(20);
  v_error_msg varchar2(235);
  Toooooooo_many_rooooows  EXCEPTION;                 -- Declare the exception
  PRAGMA EXCEPTION_INIT(Toooooooo_many_rooooows, -01422);  -- map the name of the exception with error code
  
begin
    select empno,ename,sal into eno,enam,salry from emp where empno>&no;
    dbms_output.put_line('Empno :' || eno || ' Emp Name :   ' || enam  || ' Salary :   ' || salry);    
    
exception
     when Toooooooo_many_rooooows then              --- handle the exception
         dbms_output.put_line('Fetching tooo many employees.');
 
     when others then
            v_error_code:=SQLCODE;
            v_error_msg :=SQLERRM;
           dbms_output.put_line('Plz contact Admin to resolve error with code ' || v_error_code || ' and msg ' ||  v_error_msg);         
end;
/

-----------------------------------------------------------------

Named  PLSQL Blocks a.k.a SUB PRograms

1) Procedure
2) Functions

3) Packages
4) Triggers

Procedures:
----------------
set serveroutput on
Modes in procedure:   IN , OUT, INOUT

create or replace procedure pro11(num in number)
as
begin
   dbms_output.put_line(' Time Now is :' || num);
end;
/

show errors;


execute pro11(2);
exec pro11(3)

create procedure pro12(num in number,enam out varchar2)
as
begin
   select ename into  enam from emp where empno=num;
   dbms_output.put_line(' Ename is :' || enam);
end pro12;
/
variable nam varchar2(20);
execute pro12(7369,:nam);
print nam;



create or replace procedure pro13(pnum in out varchar2)
as
begin
   pnum := '+91 '||substr(pnum,1,3) || ' - ' || substr(pnum,4,3) || ' - ' || substr(pnum,7) ;   
end pro13;
/

pnum =+91 984-567-1234
variable phnum varchar2(20);
begin
:phnum:='9845671234';
end;
/
variable phnum varchar2(20);
execute pro13(:phnum);
print phnum;

----------------------------------------------

Define procedure within a procedure
drop table mytracktime;
create table mytracktime(tno number(5),trackedon date);
select * from mytracktime;
create or replace procedure pro14(num in number,enam out varchar2)
as
   procedure tracktime is                                 -- defining a procedure
   begin
       insert into mytracktime values(mph210seq.nextval,sysdate);
   end;
begin
   select ename into  enam from emp where empno=num;
   tracktime;
   dbms_output.put_line(' Ename is :' || enam);
end pro14;
/
variable nam varchar2(20);
execute pro14(7499,:nam);
print nam;

create sequence mph210seq
  start with 1
  increment by 1
  nocycle
  nocache;

----------------------------------------------------------------------------------------------
Invoking/calling a procedure within a procedure:
----------------------------------------------------------------
create procedure pro1(num in number)
as
begin
     dbms_output.put_line('My Lucky Number :' || num);
end pro1;
/

create or replace procedure pro2(num in number,enam out varchar2)
as
begin
   select ename into  enam from emp where empno=num;
   dbms_output.put_line(' Ename is :' || enam);
   pro1(100);     -- invoking a procedure
   
exception
    when NO_DATA_FOUND then
         dbms_output.put_line('Error from Procedure . Employee Number Does Not Exist :( ');
end pro2;
/

variable nam varchar2(20);
execute pro2(7369,:nam);
print nam;

drop procedure pro1;
------------------------------------------------------------------

create or replace function tax(val  number)
return number
is
begin
    return (val*0.10);
end;
/

select sal,tax(sal) from emp;

Procedure                                         Function
DO NOT return any value             Do Return a value
Has 3 modes, in, out, inout           Has 1 mode, IN

create or replace function empfunc(eno in number)
return number
is
vsal emp.sal%type;
begin
     select sal into vsal from emp where empno=eno;
     return  vsal;  
end;
/

select empfunc(7788) from emp ;

Drop function empfunc;

-------------------------------------------------------
PACKAGES:

--> It will pack related procedures and functions together as a unit.
--> 2 sections
          i) the package specification --> have the proc / func declaration  ---> public in nature
          ii) the package body             --> have the proc /func  definition   ---> private in nature
--> the package spec and body shd be separatly created.
  
 create or replace package emppack
 as
      procedure pro12(num in number,enam out varchar2); 
      function tax(val in number) return number;
 end;
 /
 create or replace package body emppack
 as
    procedure pro12(num in number,enam out varchar2) is
    begin
     select ename into  enam from emp where empno=num;
      dbms_output.put_line(' Ename is :' || enam);
    end pro12;
    
    function tax(val in number) return number
    is
    begin
          return (val*0.10);
    end tax;
end emppack;
 /

variable nam varchar2(20);
execute emppack.pro12(7369,:nam);
print nam;
show errors;

select emppack.tax(sal) from emp;

drop package emppack;
drop package body emppack;
--------------------------------------------------

Eg 3: 		==> overloaded procedures
####

create or replace package emppack 
as
procedure empproc(eno in number,empname out varchar);	
procedure empproc;	
end emppack;
/

create or replace package body emppack as 

empname varchar2(20);
procedure empproc(eno in number,empname out varchar) is
begin
select ename into empname from employee2 where eid=eno;
end;

procedure empproc is
begin
dbms_output.put_line('Overloaded procedure inside the package');
end;


end emppack;

/

--------------------------------------------
Eg 4:		==> cursor inside a package
#####

CREATE OR REPLACE PACKAGE pack_cur
IS
CURSOR c1 IS SELECT eid FROM employee2 ORDER BY eid DESC;
PROCEDURE proc1_2rows;
PROCEDURE proc3_5rows;
END pack_cur;
/
CREATE OR REPLACE PACKAGE BODY pack_cur IS
v_empno NUMBER;
PROCEDURE proc1_2rows IS
BEGIN
OPEN c1;
LOOP
FETCH c1 INTO v_empno;
DBMS_OUTPUT.PUT_LINE('Id :' ||(v_empno));
EXIT WHEN c1%ROWCOUNT >= 2;
END LOOP;
END proc1_2rows;

PROCEDURE proc3_5rows IS
BEGIN
LOOP
FETCH c1 INTO v_empno;
DBMS_OUTPUT.PUT_LINE('Id :' ||(v_empno));
EXIT WHEN c1%ROWCOUNT >= 5;
END LOOP;
CLOSE c1;
END proc3_5rows;
END pack_cur;
/

EXECUTE pack_cur.proc1_2rows;
EXECUTE pack_cur.proc3_5rows;


variable nam varchar2(20);
execute emppack.empproc(02,:nam);
exec emppack.empproc;
print nam;


----------------------------------------------------
Triggers:
-------------

--What? A block which gets executed/called automatically when an event occurs
-- 2 types  
       i) Application trigger
                a) Statement level trigger
                b) Row level trigger
       ii) Database trigger
      iii) Instead of trigger  -- used with views  

CREATE [OR REPLACE ] TRIGGER trigger_name  
{BEFORE | AFTER | INSTEAD OF }  
{INSERT [OR] | UPDATE [OR] | DELETE}  
[OF col_name]  
ON table_name  
[REFERENCING OLD AS o NEW AS n]  
[FOR EACH ROW]  
WHEN (condition)   
DECLARE 
   Declaration-statements 
BEGIN  
   Executable-statements 
EXCEPTION 
   Exception-handling-statements 
END; 

stmt level trigger
create or replace trigger trig1
before insert on emp
begin
        dbms_output.put_line(' Welcome ');
end;
/
drop trigger trig1

insert into emp(empno,ename) values(8002,'Sakshi');
----------------------------------------------

create or replace trigger trig2
before update of sal on emp
FOR EACH ROW
when (new.sal  < old.sal)
begin
        dbms_output.put_line(' Do not decrease the salary ;(  ');
end;
/

update emp set sal=1500;
rollback;
----------------------------------------

Conditional Predicates:
create or replace trigger trig3
before insert or update of sal or delete on emp
begin
        if INSERTING THEN  
             dbms_output.put_line(' YOU ARE INSERTING ');
        elsif DELETING THEN  
             dbms_output.put_line(' YOU ARE DELETING ');
        elsif UPDATING('sal') THEN  
             dbms_output.put_line(' YOU ARE UPDATING SAL ');
        else
              dbms_output.put_line(' Do something  '); 
        end if;
end trig3;
/


delete from emp where empno=8002;
update emp set sal=1500 where empno=8001;
insert into emp(empno,ename) values(8002,'Sakshi');

--------------------------------------

instead of trigger
--------------------------

create table tab1(eno number, ename varchar2(10), did number(5));
create table tab2(dno number, dname varchar2(10));

create or replace view myview as select e.*,d.* from tab1 e , tab2 d where e.did=d.dno;

select * from myview;


create or replace trigger trig4
instead of   insert on myview
FOR EACH ROW
begin
        if INSERTING THEN  
             insert into tab1 values(:new.eno,:new.ename,:new.did);
             insert into tab2 values(:new.dno,:new.dname);
       end if;       
end trig4;
/

INSERT INTO MYVIEW VALUES(100,'DIVYA',1,1,'IT');


SELECT * FROM TAB1;
SELECT * FROM TAB2;
SELECT * FROM MYVIEW;
--------------------------------------------
Database trigger:
---------------------------
create table log_trig_table(user_id varchar2(20), log_date timestamp, action varchar2(30));

create or replace trigger logontrigger
after LOGON ON SCHEMA
begin
    insert into log_trig_table values(user,current_timestamp,'Logging ON');
end;
/

create or replace trigger logofftrigger
before LOGOFF ON SCHEMA
begin
    insert into log_trig_table values(user,current_timestamp,'Logging OFF');
end;
/
select * from log_trig_table



