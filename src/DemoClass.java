import java.sql.*;
import java.util.Properties;
// qjj
//qjj
//qjj
public class DemoClass {
    public static void main(String[] args) throws Exception {
//        Properties props = new Properties();
//        props.setProperty("username" ,"postgres");
//        props.setProperty("password","Qwejkljkl123,.");
//        props.setProperty("ssl","true");

        //创建DB连接的基本信息
        String url = "jdbc:postgresql://localhost/";
        String username = "postgres";
        String password = "960209";

//        String url = "jdbc:postgresql://mod-fund-databases.cs.bham.ac.uk:5432/jxq419";
//        String username = "jxq419";
//        String password = "960209";
        Class.forName("org.postgresql.Driver");
        System.out.println("connect successfully");
        //用String存储一条sql语句
        String query = "select * from user_info";
        //使用Connection接口创建连接
        Connection con = DriverManager.getConnection(url, username, password);

        //使用Statement创建sql语句
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);

        rs.next();//每当获取新队列时，需要使用rs.next()将指针移动到列名以下
        String name = rs.getString("last_name");
        System.out.println(name);

        //--------------------------------------------------------------------------------------------------------------
        PreparedStatement insertStatement = con
                .prepareStatement("INSERT INTO user_info (id_number,first_name,last_name) VALUES (?,?,?) ");
        {

            System.out.println("Connection established");

            insertStatement.setInt(1, 45);
            insertStatement.setString(2, "John");
            insertStatement.setString(3, "Smith");

            insertStatement.executeUpdate();

            insertStatement.setInt(1, 46);
            insertStatement.setString(2, "John");
            insertStatement.setString(3, "Anderson");

            insertStatement.executeUpdate();
        //--------------------------------------------------------------------------------------------------------------

        }
    }
}
