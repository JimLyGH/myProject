--查看表名和表注释
select * from user_tab_comments where trim(comments) is not null and table_name like 'T5_%';


--查看产品划扣账号信息
select a.prod_code, a.prod_acct_type, a.acct_serno, sa.acct_no, sa.acct_nm, sa.open_bank_name
from t5_prod_pay_account a, t5_special_acct sa 
where a.acct_serno = sa.acct_serno and a.prod_code = 'LJCSCP001';


--添加字段的语法：
alter table tablename add (column datatype [default value][null/not null],….);
--例子:
alter table t7_insurer_acctno add insulocal varchar(5) not null;
--修改字段的语法：
alter table tablename modify (column datatype [default value][null/not null],….);
alter table TABLE_NAME rename column FIELD_NAME to NEW_FIELD_NAME;

--删除字段的语法：
alter table tablename drop (column);

--重命名表
ALTER TABLE table_name RENAME TO new_table_name;

--操作表主键
--删除主键
alter table t7_insurer_acctno drop primary key;
--新增主键
alter table t7_insurer_acctno add constraint t7_insurer_acctno_pk primary key(insuid, acct_type, insulocal);


--查看锁表情况
select lo.OS_USER_NAME, lo.ORACLE_USERNAME, s.sid, s.SERIAL#, 
		s.USERNAME, s.MACHINE, s.TERMINAL, s.TYPE, s.LOGON_TIME, uo.OBJECT_NAME
from v$locked_object lo, v$session s, user_objects uo
where lo.SESSION_ID = s.SID and lo.OBJECT_ID = uo.OBJECT_ID;
--解锁
alter system kill session 'sid,serial#';


--查询对公客户
select a.fnc_trans_acct_no, a.cust_no, a.acct_no, a.acct_nm, a.card_no, i.id_code
from t1_cust_fnc_acct a,t1_cust_info i
where a.fnc_trans_acct_no = i.main_trans_acct_no and i.cust_type='C' and a.acct_status = '0';

--新建视图
create or replace view t7_productinfo_view as select * from t7_productinfo;

--获取表的列明，以一行的形式呈现
select to_char(wm_concat(column_name))
from user_col_comments
where object_name = upper('t7_prodduct_info');

--create or replace view和create view区别
--create or replace view若数据库存在视图，则替换它，否则新建
--create view不进行判断，若存在视图，则报错

with a as (select * from sys_menu)
select * from a;

with n(a, b) as (select 1 as a, 2 as b from dual)
select a, b from n; 

--合计  rollup cube
select t.insutype, sum(t.premium)
from t7_app_h_trans t
group by rollup(t.insutype);

select t.insutype, sum(t.premium)
from t7_app_h_trans t
group by cube(t.insutype);

--导出表结构
select c.COLUMN_ID 序号, c.COLUMN_NAME 列名, c.DATA_TYPE 数据类型, c.DATA_LENGTH 长度, c.DATA_SCALE 小数位, 
       to_char(wm_concat(uc.constraint_type)) 主键,
       decode(c.NULLABLE, 'Y', '是', 'N', '否', '其他') 允许为空/*, c.DATA_DEFAULT 默认值*/, ucc.comments 说明
from user_tab_cols c
left join user_col_comments ucc on ucc.table_name = c.TABLE_NAME and ucc.column_name = c.COLUMN_NAME
left join user_cons_columns ucs on ucs.table_name = c.TABLE_NAME and ucs.column_name = c.COLUMN_NAME
left join user_constraints uc on uc.table_name = c.TABLE_NAME and uc.constraint_name = ucs.constraint_name
where lower(c.TABLE_NAME) = 't7_policyinfo'
group by c.COLUMN_ID, c.COLUMN_NAME, c.DATA_TYPE, c.DATA_LENGTH, c.DATA_SCALE, c.NULLABLE, ucc.comments
order by c.COLUMN_ID;

--row_number() over()用法
--解释：先根据moduleid分组,分组后的结果再根据paraid排序 
select *, row_number() over(partition by moduleid order by paramid) rank
from sys_param;


--拼接数据库序列化脚本
select 'create sequence ' || ds.sequence_name || 
       ' minvalue ' || ds.min_value ||
       ' maxvalue ' || ds.max_value ||
       ' start with ' || ds.last_number ||
       ' increment by ' || ds.increment_by ||
       decode(ds.cache_size, 0, ' nocache ', ' cache ' || ds.cache_size) ||
       decode(ds.cycle_flag, 'Y', ' cycle;')
from dba_sequences ds
where ds.sequence_owner = 'SIT';