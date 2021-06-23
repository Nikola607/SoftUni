package DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Lab_Database_Access_With_JDBC {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Exercise: ");
        int exNum = Integer.parseInt(scan.nextLine());

        switch (exNum) {
            case 1 -> ex_1(scan);
            case 2 -> ex_2(scan);
        }
    }

    private static void ex_1(Scanner scan) throws SQLException {
        System.out.println("Enter salary: ");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", getProperties());

        PreparedStatement stmt =
                connection.prepareStatement("SELECT `first_name`, `last_name`FROM `employees`WHERE `salary` > ?");
        double salary = Double.parseDouble(scan.nextLine());
        stmt.setDouble(1, salary);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("first_name")
                    + " " + rs.getString("last_name"));
        }
    }

    private static void ex_2(Scanner scan) throws SQLException {
        System.out.println("Enter username: ");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", getProperties());

        PreparedStatement stmt =
                connection.prepareStatement("SELECT u.`user_name`, u.`first_name`, u.`last_name`, " +
                        "COUNT(us.`user_id`) AS `count_games` FROM users_games AS us " +
                        "JOIN `users` AS u ON u.`id` = us.`user_id` WHERE u.`user_name` = ?");

        String name = scan.nextLine();

        stmt.setString(1, name);

        ResultSet rs = stmt.executeQuery();

        rs.next();
        if(rs.getString("user_name") != null) {
            System.out.println("User: " + rs.getString("user_name") + "\n"
                    + rs.getString("first_name") + " " + rs.getString("last_name")
                    + " has played " + rs.getInt("count_games"));
        }else{
            System.out.println("No such user exists");
        }
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
        return props;
    }
}


