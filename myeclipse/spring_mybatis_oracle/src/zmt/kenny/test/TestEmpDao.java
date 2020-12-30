package zmt.kenny.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zmt.kenny.dao.EmpDao;
import zmt.kenny.entity.Emp;

public class TestEmpDao {
  /* @Test //单独测试mybatis
   public void testAdd() throws Exception{
	   EmpDao empDao=new EmpDao();
	   empDao.add(new Emp(1,"操逼",800D,"男"));
   }*/
	
   @Test //测试spring整合mybatis
   public void testAdd2() throws Exception{
	   ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
	   EmpDao empDao = (EmpDao) ac.getBean("empDao");
	   empDao.add(new Emp(2,"操逼",800D,"男"));
   }
}
