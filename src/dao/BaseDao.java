package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	private static String url = "jdbc:mysql://127.0.0.1:3306/library?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "123";
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getCon(){
		try{
			Connection con=DriverManager.getConnection(url,user,password);
			return con;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
