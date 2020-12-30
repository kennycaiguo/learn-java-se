package com.kenny.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import org.springframework.stereotype.Component;

import com.kenny.entity.Emp;
import com.kenny.util.JdbcUtils;
import com.sun.jmx.snmp.Timestamp;
import com.sun.org.apache.bcel.internal.generic.NEW;
 
@Component(value="empDao")
public class EmpDao {
	//����Ա��
    public void Add(Emp emp) throws Exception{
    	QueryRunner qr=JdbcUtils.getQueryRunner();
    	String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
    	 
        //DateFormat df=new SimpleDateFormat("dd-M月-yy");
         
    	Object[] params={emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),new Timestamp(emp.getHiredate().getTime()),emp.getSal()
        ,emp.getComm(),emp.getEmpno()};
    	qr.update(sql,params);
    }
    
    public List<Emp> findAll() throws Exception{
    	QueryRunner runner=JdbcUtils.getQueryRunner();
    	String sql="select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp";
    	List<Emp> emps=runner.query(sql, new BeanListHandler<Emp>(Emp.class));
    	System.out.println(emps);
		return emps;
    	
    }
    
    @Test
    public void testFindAll() throws Exception{
    	List<Emp> list=new EmpDao().findAll();
    	for (Emp emp : list) {
			System.out.println(emp.getEmpno()+":" +emp.getEname()+":"+emp.getSal());
		}
    }
}
