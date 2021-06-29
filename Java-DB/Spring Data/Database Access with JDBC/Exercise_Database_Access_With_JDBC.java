package DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;

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
        System.out.println("Exercise: ");
        Scanner scan = new Scanner(System.in);

        int exNum = Integer.parseInt(scan.nextLine());

        switch (exNum) {
            case 1 -> ex_1();
            case 2 -> ex_2(scan);
            case 3 -> ex_3(scan);
            case 4 -> ex_4(scan);
            case 5 -> ex_5(scan);
            case 6 -> ex_6();
            case 7 -> ex_7(scan);
            case 8 -> ex_8(scan);
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
        System.out.println("Enter data: ");
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

    private static void ex_4(Scanner scan) throws SQLException {
        System.out.println("Enter country name: ");
        String countryName = scan.nextLine();

        PreparedStatement updateTowns = connection.prepareStatement("UPDATE `towns` SET `name`= UPPER(`name`) WHERE `country` = ?;");
        updateTowns.setString(1, countryName);

        int affectedRows = updateTowns.executeUpdate();

        if(affectedRows != 0){
            System.out.printf("%d towns were affected.\n", affectedRows);
        }else{
            System.out.println("No towns were affected.");
        }

        PreparedStatement getTowns = connection.prepareStatement("SELECT `name` FROM `towns` WHERE`country` = ?;");
        getTowns.setString(1, countryName);

        ResultSet rs = getTowns.executeQuery();
        while(rs.next()){
            System.out.print(rs.getString("name") + " ");
        }
    }

    private static void ex_5(Scanner scan) throws SQLException {
        System.out.println("Enter villain Id: ");
        int villainId = Integer.parseInt(scan.nextLine());

        String villainName = getEntityNameById("villains", villainId);

        if(villainName != null) {
            int affectedRolls = deleteMinionsByVillain(villainId);
            deleteEntityById("villains", villainId);
            System.out.printf("%s was deleted\n" +
                    "%d minions released\n", villainName, affectedRolls);
        }else{
            System.out.println("No such villain was found");
        }
    }

    private static void ex_6() throws SQLException {
        System.out.println("Print all minion names");

        PreparedStatement stmt = connection.prepareStatement("SELECT name FROM minions");

        ResultSet rs = stmt.executeQuery();

        List<String> minions = new ArrayList<>();
        while (rs.next()){
            minions.add(rs.getString("name"));
        }

        List<String> printMinions = new ArrayList<>();

        for (int i = 0; i < minions.size() / 2; i++) {
            printMinions.add(minions.get(i));
            printMinions.add(minions.get(minions.size() - 1 - i));
        }

        System.out.println(minions.size());
        System.out.println(printMinions.size());
        System.out.println(printMinions);
    }

    private static void ex_7(Scanner scan) throws SQLException {
        System.out.println("Increase minions age");
        int[] minionIds = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < minionIds.length; i++) {
            PreparedStatement lowerNames = connection.prepareStatement("UPDATE minions SET name = lower(name), age = age + 1 WHERE id = ?");

            lowerNames.setInt(1, minionIds[i]);
            lowerNames.execute();

            PreparedStatement getMinions  = connection.prepareStatement("SELECT name, age FROM minions");

            ResultSet rs3 = getMinions.executeQuery();

            while (rs3.next()) {
                System.out.println(rs3.getString("name") + " " + rs3.getInt("age"));
            }

        }
    }

    private static void ex_8(Scanner scan) throws SQLException {
        
    }

    private static String getEntityNameById(String entityName, int entityId) throws SQLException {
        String query = String.format("SELECT `name` FROM %s WHERE `id` = ?;", entityName);
        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, entityId);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            return rs.getString("name");
        }
            return null;
    }

    private static void deleteEntityById(String entityName, int villainId)throws SQLException {
        String query = String.format("DELETE FROM %s WHERE `id` = ?;", entityName);
        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, villainId);

        stmt.executeUpdate();
    }

    private static int deleteMinionsByVillain(int villainId) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM `minions_villains` WHERE `villain_id` = ?;");

        stmt.setInt(1, villainId);
        return stmt.executeUpdate();
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
        return props;
    }
}
