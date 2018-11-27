package org.dataforum.database;

import java.sql.CallableStatement; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.Types; 

/* 
 * 对应的存储过程 
 DROP PROCEDURE IF EXISTS `pro_num_user`; 
delimiter ;; 
CREATE PROCEDURE `pro_num_user`(IN user_name varchar(10) ,OUT count_num INT) 
    READS SQL DATA 
BEGIN 
    SELECT COUNT(*) INTO count_num FROM tab_user WHERE 'name'=user_name; 
END 
 ;; 
delimiter ; 
 */ 
public class ConnMySQL { 

    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
    public static final String URL = "jdbc:mysql://10.50.0.206:3306/gw_crm"; 
    public static final String USERNAME = "root"; 
    public static final String PASSWORD = "123"; 

     
    public static void callProcedure1() throws Exception 
    { 
        Class.forName(DRIVER_CLASS); 
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
        String sql = "{CALL proc_member_level(?,?)}"; //调用存储过程 
        CallableStatement cstm = connection.prepareCall(sql); //实例化对象cstm 
        //801012000602
        cstm.setString(1, "801015011524"); //存储过程输入参数 
        //cstm.setInt(2, 2); // 存储过程输入参数 
        cstm.registerOutParameter(2, Types.VARCHAR); // 设置返回值类型 即返回值 
        cstm.execute(); // 执行存储过程 
        System.out.println(cstm.getString(2)); 
        cstm.close(); 
        connection.close(); 
    } 
     
//    public static void callProcedure2() throws Exception 
//    { 
//        Class.forName(DRIVER_CLASS); 
//        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
//        String sql = "{CALL pro_number(?,?,?)}"; //调用存储过程 
//        CallableStatement cstm = connection.prepareCall(sql); //实例化对象cstm 
//        cstm.setInt(1, 2); // 存储过程输入参数 
//        cstm.setInt(2, 2); // 存储过程输入参数 
//        cstm.registerOutParameter(3, Types.INTEGER); // 设置返回值类型 即返回值 
//        cstm.execute(); // 执行存储过程 
//        System.out.println(cstm.getInt(3)); 
//        cstm.close(); 
//        connection.close(); 
//         
//    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnMySQL connmysql = new ConnMySQL();
		try {
			connmysql.callProcedure1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
