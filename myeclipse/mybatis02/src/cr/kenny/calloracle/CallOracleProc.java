package cr.kenny.calloracle;

import java.sql.*;

import cr.kenny.util.JdbcUtils;

/**
 * java调用Oracle存储过程
 * @author Administrator
 *
 */
public class CallOracleProc {
   public static void main(String[] args) throws Exception {
	Connection connection=JdbcUtils.getConnection();
	String sql="{call get_rax(?,?)}";//java调用过程的语法:"{call 过程名(参数1,参数2,...)}"
	CallableStatement cStatement=connection.prepareCall(sql);
	//System.out.println(connection);
	//为in类的问号设置值
	cStatement.setInt(1, 7000);
	//为out类型的参数注册输出类型
	cStatement.registerOutParameter(2, Types.INTEGER);
	//执行调用过程
	cStatement.execute();
	//接受返回值，即这里的第二个？
	int result=cStatement.getInt(2);
	System.out.println("7000元工资应交"+result+"元税");
	cStatement.close();
	connection.close();
  }
}
