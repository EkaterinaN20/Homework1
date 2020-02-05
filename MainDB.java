package Lesson_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class MainDB {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    static final String DATABASE_URL = "jdbc:mysql://localhost/";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static void main(String[] args) throws SQLException {
        try {
            createDB();
            insert();
            updateDB("Pupkin", "111");
            select();
            deleteDB();
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }

            disconnect();
        }

    }

    public static void readFile() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("update.txt");
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String[] mass = scanner.nextLine().split(" ");
            updateDB(mass[0], mass[1]);
        }
    }



    public static void createDB() throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Creating database...");
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = connection.createStatement();
            String sql = "CREATE DATABASE USERS";
            System.out.println("Database created successfully...");
            stmt.executeUpdate("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'user' text, 'password' password);");
            System.out.println("The table is created.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
public static void insert() throws SQLException {

       connection.setAutoCommit(true);
        for (int i = 0; i < 100; i++) {
            int a = 123 * i;
            stmt.executeUpdate("INSERT INTO users (user, password) values ('Jack " + i + "', " + a +")");
                     a++;
        }
    System.out.println("100 users with names Jack X with passwords x*123 are added into the database");

    }

    public static void updateDB(String user, String password) {
        try {
            stmt.executeUpdate("insert into users (user, password) values ('"+user+"', " + password +")");
            System.out.println("One user with special data has been added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void select () throws SQLException {
        System.out.println("Users with passwords containing '28' have been selected:");
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE password LIKE'%"+28+"%'");
        while (rs.next()) {
            String pass = rs.getString("user") + "    " + rs.getString("password");
            System.out.println(pass);
        }
    }

    public static void deleteDB() throws SQLException {
        String SQL = "DROP TABLE users";
        stmt.executeUpdate(SQL);
        System.out.println("The table has been deleted.");
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
