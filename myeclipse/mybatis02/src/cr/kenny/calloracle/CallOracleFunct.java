package cr.kenny.calloracle;

import java.sql.*;

import cr.kenny.util.JdbcUtils;

/**
 * java调用Oracle函数
 * @author Administrator
 *
 */
public class CallOracleFunct {
   public static void main(String[] args) throws Exception {
	   //需求：查询7788号员工的姓名，职位，工资
	Connection connection=JdbcUtils.getConnection();
	String sql="{?=call findEmpNameAndJobAndSal(?,?,?)}"; //java掉Oracle函数的格式
	CallableStatement cStatement=connection.prepareCall(sql);
	 //注册第一个问号返回值类型
	cStatement.registerOutParameter(1, Types.VARCHAR);
	//为第二个问号注入值（in类型）
	cStatement.setInt(2, 7788);
	//注册第三个问号的返回值（out类型）
	cStatement.registerOutParameter(3, Types.VARCHAR);
	//注册第四个问号的返回值（out类型）
	cStatement.registerOutParameter(4, Types.INTEGER);
	cStatement.execute();
	 String name=cStatement.getString(1);
	 String job=cStatement.getString(3);
	 int sal=cStatement.getInt(4);
	 System.out.println("7788号员工的姓名为："+name+";"+"他的职位是："+job+";"+"工资为："+sal);
	cStatement.close();
	connection.close();
  }
}
