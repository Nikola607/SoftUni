package DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Exercise_Database_Access_With_JDBC {
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", getProperties());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Exercise: ");
        int exNum = Integer.parseInt(scan.nextLine());

        switch (exNum) {
            case 1 -> ex_1();
            case 2 -> ex_2(scan);
            case 3 -> ex_3(scan);
        }
    }

    private static void ex_1() throws SQLException {
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

    private static void ex_2(Scanner scan) throws SQLException {
        PreparedStatement stmt =
                connection.prepareStatement("SELECT v.`id`, v.`name` AS `villain_name`, m.`name`, m.`age` FROM `villains` AS v\n" +
                        "JOIN `minions_villains` AS mv ON v.`id` = mv.`villain_id`\n" +
                        "JOIN `minions` AS  m on mv.`minion_id` = m.`id`\n" +
                        "WHERE v.`id` = ?;");
        System.out.println("Enter villain id: ");

        int villainID = Integer.parseInt(scan.nextLine());

        stmt.setInt(1, villainID);

        ResultSet rs = stmt.executeQuery();
        int counter = 1;

        if (rs.next()) {
            System.out.println("Villain: " + rs.getString("villain_name"));
            rs.next();

            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.printf("%d. %s %d\n", counter++,
                        rs.getString("name"),
                        rs.getInt("age"));
            }
        }else{
            System.out.printf("No villain with ID %d exists in the database.\n", villainID);
        }
    }

    private static void ex_3(Scanner scan) throws SQLException {
        String[] minionData = scan.nextLine().split("\\s+");
        String[] villain = scan.nextLine().split("\\s+");

        String minionName = minionData[1];
        String minionAge = minionData[2];
        String minionTown = minionData[3];

        String villainName = villain[1];

        PreparedStatement villainStmt = connection.prepareStatement("SELECT `name` FROM villains\n" +
                "WHERE name = ?;");
        villainStmt.setString(1, villainName);

        PreparedStatement townStmt = connection.prepareStatement("SELECT `name` FROM towns\n" +
                "WHERE name = ?;");
        townStmt.setString(1, minionTown);

        PreparedStatement minionStmt = connection.prepareStatement("SELECT `name` FROM villains\n" +
                "WHERE name = ?;");
        minionStmt.setString(1, minionName);

        ResultSet rs = villainStmt.executeQuery();
        if(!rs.next()){
            System.out.printf("Villain %s was added to the database.\n", villainName);

            PreparedStatement insertVillain = connection.prepareStatement("INSERT INTO villains(name, evilness_factor) VALUES (?, 'evil');");
            insertVillain.setString(1, villainName);

            insertVillain.execute();
        }

        rs = townStmt.executeQuery();
        if(!rs.next()){
            System.out.printf("Town %s was added to the database.", minionTown);

            PreparedStatement insertTown = connection.prepareStatement("INSERT INTO towns(name) VALUES (?);");
            insertTown.setString(1, minionTown);
            insertTown.execute();
        }
        rs = minionStmt.executeQuery();
        if(!rs.next()){
            PreparedStatement stmt2 =
                    connection.prepareStatement("INSERT INTO minions (name, age, town_id)  VALUES (?, ?, ?)");

            PreparedStatement stsad =
                    connection.prepareStatement("SELECT id FROM towns WHERE name = ?");

            stsad.setString(1, minionTown);
            ResultSet id = stsad.executeQuery();

            id.next();
            int townId = id.getInt(1);

            stmt2.setString(1, minionName);
            stmt2.setString(2, minionAge);
            stmt2.setInt(3, townId);

            stmt2.execute();
            System.out.println("Minion " + minionName + " was added to db.");
        }

        PreparedStatement addMinionToVillain = connection.prepareStatement("INSERT INTO minions_villains(minion_id, villain_id) VALUES (?, ?);");

        PreparedStatement getMinionId = connection.prepareStatement("SELECT `id` FROM `minions`" +
                "WHERE `name` = ?");
        getMinionId.setString(1, minionName);

        rs = getMinionId.executeQuery();
        rs.next();

        int minionId = rs.getInt(1);

        PreparedStatement getVillainId = connection.prepareStatement("SELECT `id` FROM `villains`" +
                "WHERE `name` = ?");
        getVillainId.setString(1, villainName);

        rs = getVillainId.executeQuery();
        rs.next();

        int villainId = rs.getInt(1);

        addMinionToVillain.setInt(1, minionId);
        addMinionToVillain.setInt(2, villainId);
        addMinionToVillain.execute();
        System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
        return props;
    }
}
