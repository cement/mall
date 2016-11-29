package com.changqing.medication.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager {
	private static SQLiteOpenHelper _databaseHelper;
	private static DatabaseManager _instance;
	private SQLiteDatabase _database;
	private AtomicInteger _openCounter = new AtomicInteger();
	
	//"jdbc:sqlserver://localhost:1433;" + "databaseName=AdventureWorks;user=UserName;password=*****";
	public static Connection getConnection(String dbname){
		//"com.microsoft.sqlserver.jdbc.SQLServerDriver"
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";// 驱动
		String username="sa";// 用户名
		String password="storeoutdetailcq";// 密码
		String url = "jdbc:sqlserver://192.168.1.10;DatabaseName="+dbname;// SqlServer链接地址
		Connection connection = getConnection(driver,url,username,password);
		return connection;
		
	}
	public static Connection getConnection(String dbname,String username,String password){
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// 驱动
		String url = "jdbc:sqlserver://192.168.1.10;DatabaseName="+dbname;// SqlServer链接地址
		Connection connection = getConnection(driver,url,username,password);
		return connection;
		
	}
	public static Connection getConnection(){
		//com.microsoft.sqlserver.jdbc.SQLServerDriver
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";// 驱动
		String username="sa";// 用户名
		String password="storeoutdetailcq";// 密码
		String dbname="UDoDBCQ";
		//221.1.104.252:1433
		//192.168.0.123:1433
		//String url = "jdbc:sqlserver://192.168.0.123:1433;DatabaseName="+dbname;// SqlServer链接地址
		String connectionUrl="jdbc:sqlserver://192.168.0.123:1433;" + "databaseName=UDoDBCQ;user=sa;password=storeoutdetailcq";  
		  
		//String url = "jdbc:sqlserver://221.1.104.252:1433;DatabaseName="+dbname;// SqlServer链接地址
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(connectionUrl);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
	public static Connection getConnection(String driver,String url,String username,String password) {
        Connection conn = null;
         try {
             Class.forName(driver);//加载驱动类
             conn = DriverManager.getConnection(url, username, password);
         } catch (ClassNotFoundException e) {
             System.out.println("找不到驱动程序类 ，加载驱动失败！");
             e.printStackTrace();
         } catch (SQLException e) {
             System.out.println("数据库连接失败！");
             e.printStackTrace();
         }
         return conn;
     }
	public static Connection getConnection(String driver,String scheme, String host,String port,String dbname,String username,String password) {
		Connection conn = null;
		String url = scheme+"//"+host+":"+port+";"+"databaseName="+dbname;
		try {
			Class.forName(driver);//加载驱动类
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
		return conn;
	}
}