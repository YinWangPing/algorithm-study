import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/27 21:50
 */

public class MysqlConnection {
    private static final String DATABASE_DRIVER="com.mysql.jdbc.Driver";
    private static final String DATABASE_URL="jdbc:mysql://192.168.0.108:3306/test";
    private static final String DATABASE_USER="root";
    private static final String DATABASE_PASSWORD="123456";
    public static void main(String[] args) throws Exception {
        Connection connection=null;//每一个Connection接口对象描述的就是一个用户连接
        Class.forName(DATABASE_DRIVER);//向容器之中加载数据库程序驱动
        connection= DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement=connection.createStatement();
        String sql="SELECT ID,NAME,AGE FROM `user` WHERE ID IN(1,2,3)";
        ResultSet rs=statement.executeQuery(sql);
        System.out.println(String.format("%s\t%s\t%s\t","id","name","age"));
        while(rs.next()) {
            int id=rs.getInt(1);
            String name=rs.getString(2);
            int age=rs.getInt(3);
            System.out.println(String.format("%d\t%s\t%d\t",id,name,age));
        }
        connection.close();
    }
}
