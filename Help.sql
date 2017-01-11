--查看表名和表注释
select * from user_tab_comments where trim(comments) is not null and table_name like 'T5_%';


--查看产品划扣账号信息
select a.prod_code, a.prod_acct_type, a.acct_serno, sa.acct_no, sa.acct_nm, sa.open_bank_name
from t5_prod_pay_account a, t5_special_acct sa 
where a.acct_serno = sa.acct_serno and a.prod_code = 'LJCSCP001';


--添加字段的语法：
alter table tablename add (column datatype [default value][null/not null],….);


--修改字段的语法：
alter table tablename modify (column datatype [default value][null/not null],….);
alter table TABLE_NAME rename column FIELD_NAME to NEW_FIELD_NAME;


--删除字段的语法：
alter table tablename drop (column);


--重命名表
ALTER TABLE table_name RENAME TO new_table_name;


--查看锁表情况
select lo.OS_USER_NAME, lo.ORACLE_USERNAME, s.sid, s.SERIAL#, 
		s.USERNAME, s.MACHINE, s.TERMINAL, s.TYPE, s.LOGON_TIME, uo.OBJECT_NAME
from v$locked_object lo, v$session s, user_objects uo
where lo.SESSION_ID = s.SID and lo.OBJECT_ID = uo.OBJECT_ID;
--解锁
alter system kill session 'sid,serial#';




