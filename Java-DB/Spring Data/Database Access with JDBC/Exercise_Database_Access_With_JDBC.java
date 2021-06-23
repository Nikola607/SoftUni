package DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Exercise_Database_Access_With_JDBC {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Exercise: ");
        int exNum = Integer.parseInt(scan.nextLine());

        switch (exNum){
            case 1 -> ex_1();
        }
    }

    private static void ex_1() throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", getProperties());

        PreparedStatement stmt =
                connection.prepareStatement("SELECT v.`name`, COUNT(DISTINCT (mv.`minion_id`)) AS `minions_count` FROM `villains` AS v\n" +
                        "JOIN `minions_villains` AS mv ON v.`id` = mv.`villain_id`\n" +
                        "GROUP BY v.`name`\n" +
                        "HAVING `minions_count` > 15\n" +
                        "ORDER BY `minions_count` DESC;");

        ResultSet rs = stmt.executeQuery();

        rs.next();
        System.out.println(rs.getString("name") + " " + rs.getInt("minions_count"));
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
        return props;
    }
}
