package utilities.actions;

import java.sql.*;

public class DBActions {
    private static Connection connection;
    static Process process;
    static String k8sDir = System.getProperty("user.home") + "\\k8s";
    static String tunnelingSessionCommand = "kubectl port-forward pod/haproxy-7b95555f97-kmgcs 1521:1521 -n de-enterprise-test";

    private static Connection openConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            boolean x = process.isAlive();
            System.out.println(x);
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:TEDORADB", "TED", "TED");

        } catch (ClassNotFoundException | SQLException e) {
            process.destroyForcibly();
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet selectSQLQuery(String query) {
        connection = openConnection();
        try {
            boolean x = process.isAlive();
            System.out.println(x);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next())
                System.out.println(rs.getInt(1) +
                        "  " +
                        rs.getString(2) +
                        "  " +
                        rs.getString(3));
            System.out.println(rs.getRow());
            closeConnection(connection);
            process.destroyForcibly();
            return rs;
        } catch (SQLException e) {
            closeConnection(connection);
            e.printStackTrace();
            System.out.println("Error: ColumnIndex is not valid; OR database access error occurs; " +
                    "OR this method is called on a closed result set.");
            return null;
        }
    }

    private static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
