package org.dataforum.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnOracle {
	public void SelectTable() {
		// 设定数据库驱动，数据库连接地址、端口、名称，用户名，密码
		String driverName = "oracle.jdbc.driver.OracleDriver";
		// String url = "jdbc:oracle:thin:@//10.46.101.196:1521/garland.org"; // 使用SERVICE_NAME进行链接
		String url = "jdbc:oracle:thin:@10.46.101.196:1521:garland"; //使用SID进行链接
		String user = "gl_sso"; // 为用户名
		String password = "Garland321sso"; // 密码
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 数据库连接对象
		Connection conn = null;
		try {
			// 反射Oracle数据库驱动程序类
			Class.forName(driverName);
			// 获取数据库连接
			conn = DriverManager.getConnection(url, user, password);
			// 输出数据库连接
			System.out.println(conn);
			// 定制sql命令
			String sql = "select table_name from user_tables";
			// 创建该连接下的PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			// 传递第一个参数值 root，代替第一个问号
			// pstmt.setString(1, "root");
			// 执行查询语句，将数据保存到ResultSet对象中
			rs = pstmt.executeQuery();
			// 将指针移到下一行，判断rs中是否有数据
			if (rs.next()) {
				// 输出查询结果
				System.out.println("查询到表名为【" + rs.getString("table_name") + "】");
			} else {
				// 输出查询结果
				System.out.println("未查询到相关信息");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	public static void main(String[] args) {
//		ConnOracle connoracle = new ConnOracle();
//		connoracle.SelectTable();
//	}
}