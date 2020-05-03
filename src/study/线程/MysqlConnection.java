package study.线程;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/9 14:49
 */

public class MysqlConnection {
    private static final String DATABASE_DRIVER="com.mysql.jdbc.Driver";
    private static final String DATABASE_URL="jdbc:mysql://192.168.0.102:3306/test";
    private static final String DATABASE_USER="root";
    private static final String DATABASE_PASSWORD="123456";

    public static void main(String[] args) throws Exception {
        int currentPage=2;//设置当前页
        int columnSize=5;//设置每页显示的列数
        String keyWord="dc";//设置模糊查询关键字
        Connection connection = null;// 每一个Connection接口对象描述的就是一个用户连接
        Class.forName(DATABASE_DRIVER);// 向容器之中加载数据库程序驱动
        connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

////		 插入操作
//        for (int i = 0; i <50 ; i++) {
//            String sql = "INSERT INTO student(id,name) VALUES(?,?)";
//            PreparedStatement statement=connection.prepareStatement(sql);
//            statement.setInt(1, i+1);
//            statement.setString(2, "adc"+i);
//            int count =statement.executeUpdate();
//            System.out.println(count);
//        }


//		更新操作
//		String sql = "UPDATE \"student\" SET \"id\" = ?,\"name\" = ? WHERE \"id\" = ?";
//		PreparedStatement statement = connection.prepareStatement(sql);
//		statement.setInt(1, 4);
//		statement.setString(2, "张三");
//		statement.setInt(3, 4);
//		int count = statement.executeUpdate();
//		System.out.println(count);

//		刪除操作
//		String sql = "DELETE FROM \"student\" WHERE \"id\"=?";
//		PreparedStatement statement = connection.prepareStatement(sql);
//		statement.setInt(1, 4);
//		int count = statement.executeUpdate();
//		System.out.println(count);

//		 查询操作
//		 String sql="SELECT \"id\",\"name\" FROM \"student\" WHERE \"id\"
//		 IN(1,2,3,4)";
//		 PreparedStatement statement=connection.prepareStatement(sql);
//		 ResultSet rs = statement.executeQuery();
//		 while (rs.next()) {
//		 int id = rs.getInt(1);
//		 String name = rs.getString(2);
//		 System.out.println("id***" + id + ",name***" + name);
//		 }

//		 分页查询操作
        String sql="SELECT id,name FROM student WHERE name LIKE ? LIMIT ?,?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1, "%"+keyWord+"%");
        statement.setInt(2,(currentPage-1)*columnSize);
        statement.setInt(3,columnSize);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            System.out.println(String.format("%s\t%s","id:"+id,"name:"+name));
        }
        connection.close();
    }
}
