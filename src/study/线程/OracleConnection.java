package study.线程;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/8 21:41
 */

public class OracleConnection {
    private static final String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String DATABASE_USER = "ywp";
    private static final String DATABASE_PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        int currentPage=2;//设置当前页
        int columnSize=5;//设置每页显示的列数
        String keyWord="ds";//设置模糊查询关键字
        Connection connection = null;// 每一个Connection接口对象描述的就是一个用户连接
        Class.forName(DATABASE_DRIVER);// 向容器之中加载数据库程序驱动
        connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

//		 插入操作
		 String sql = "INSERT INTO \"student\"(\"id\",\"name\") VALUES(?,?)";
		 PreparedStatement statement=connection.prepareStatement(sql);
		 statement.setInt(1, 4);
		 statement.setString(2, "wererw");
		 int count =statement.executeUpdate();
		 System.out.println(count);

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

////		 分页查询操作
//        String sql="SELECT * FROM(SELECT \"id\",\"name\",ROWNUM rn FROM \"student\" WHERE \"name\" LIKE ? AND ROWNUM<=?) WHERE rn>?";
//        PreparedStatement statement=connection.prepareStatement(sql);
//        statement.setString(1, "%"+keyWord+"%");
//        statement.setInt(2,currentPage*columnSize);
//        statement.setInt(3,(currentPage-1)*columnSize);
//        ResultSet rs = statement.executeQuery();
//        while (rs.next()) {
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            System.out.println("id***" + id + ",name***" + name);
//        }
//        connection.close();
    }
}