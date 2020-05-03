package study.线程;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/27 21:45
 */

public class MyDataSource implements DataSource {
    private static final String DATABASE_DRIVER="com.mysql.jdbc.Driver";
    private static final String DATABASE_URL="jdbc:mysql://192.168.0.107:3306/test";
    private static final String DATABASE_USER="root";
    private static final String DATABASE_PASSWORD="123456";
    LinkedList<Connection> dataSource=new LinkedList<Connection>();
    public MyDataSource() throws ClassNotFoundException, SQLException {
        for (int i = 0; i <10 ; i++) {
            Class.forName(DATABASE_DRIVER);//向容器之中加载数据库程序驱动
            Connection connection= DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            dataSource.add(connection);
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        Connection connection=dataSource.removeFirst();
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
    public void releaseConnection(Connection connection){
        dataSource.add(connection);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MyDataSource dataSource=new MyDataSource();
        Connection connection =dataSource.getConnection();
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
        rs.close();
        statement.close();
        dataSource.releaseConnection(connection);
    }
}
