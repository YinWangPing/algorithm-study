package study.数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mysql连接 {
    private static final String DATABASE_DRIVER="com.mysql.jdbc.Driver";
    private static final String DATABASE_URL="jdbc:mysql://localhost:3306/test";
    private static final String DATABASE_USER="root";
    private static final String DATABASE_PASSWORD="123456";
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Connection connection=null;//每一个Connection接口对象描述的就是一个用户连接
        Class.forName(DATABASE_DRIVER);//向容器之中加载数据库程序驱动
        connection= DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement=connection.createStatement();
        String sql="SELECT id,name FROM student WHERE id IN(1,2)";
        ResultSet rs=statement.executeQuery(sql);
        while(rs.next()) {
            int id=rs.getInt(1);
            String name=rs.getString(2);
            System.out.println("id***"+id+",name***"+name);
        }
        connection.close();
    }
}
