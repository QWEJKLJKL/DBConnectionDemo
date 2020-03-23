import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoClassTwo {
    public static void main(String[] args) throws SQLException {
        String DBDRIVER = "org.postgresql.Driver";
        String DBURL = "jdbc:postgresql://mod-fund-databases.cs.bham.ac.uk:5432/jxq419";
        String USER = "jxq419";
        String PASSWORD = "960209";

        Connection dbCon;
        dbCon = DriverManager.getConnection(DBURL, USER, PASSWORD);
        System.out.println("done!");
    }
}
