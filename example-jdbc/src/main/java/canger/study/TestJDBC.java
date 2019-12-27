package canger.study;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TestJDBC {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Properties properties = getProperties();
//        Class.forName(properties.getProperty("jdbc.driverClassName"));
        Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
                properties.getProperty("jdbc.username"),
                properties.getProperty("jdbc.password"));

        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from computer_stu");
        while (resultSet.next()){
            System.out.print(resultSet.getString("id"));
            System.out.print(" ");
            System.out.print(resultSet.getString("name"));
            System.out.print(" ");
            System.out.print(resultSet.getString("score"));
            System.out.println();
        }

        statement.executeUpdate("update computer_stu set score='001' where id='1001'");
        Savepoint sp1 = connection.setSavepoint("sp1");
        statement.executeUpdate("update computer_stu set score='002' where id='1001'");
        Savepoint sp2 = connection.setSavepoint("sp2");
        statement.executeUpdate("update computer_stu set score='003' where id='1001'");

       // connection.rollback(sp2);
        connection.rollback(sp1);
       // connection.rollback();

        connection.releaseSavepoint(sp1);
        connection.releaseSavepoint(sp2);
        connection.commit();
        connection.close();
    }

    public static Properties getProperties() throws IOException {
        InputStream resourceAsStream =
                TestJDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        return properties;
    }
}
