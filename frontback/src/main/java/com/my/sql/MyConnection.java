package com.my.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
			Class.forName("oracle.jdbc.OracleDriver"); //1.JDBC 드라이버로드
		
		Connection conn=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe"; //인바운드설정되어있어야 다른호스트접속가능
		String user="hr";
		String password="hr";
		
			conn =DriverManager.getConnection(url,user,password); //2. DB연결
			System.out.println("DB와 연결 성공");
		return conn;

	}
	
	public static void close(ResultSet rs,Statement stmt, Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	

}
