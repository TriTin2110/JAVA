import java.sql.Connection;
import java.sql.DriverManager;

public class mainBai1 {
        public static void main(String[] args) {
                Connection connection = getConnnection();
                System.out.println(connection);
                closeConnection(connection);
        }

        public static Connection getConnnection() {
                Connection c = null;
                try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        String url = "jdbc:sqlserver://DESKTOP-9VT84F0\\SQLEXPRESS01:1433;databasename = JDBC";
                        String user = "sa";
                        String password = "nguyentritin123";
                        c = DriverManager.getConnection(url, user, password);
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                return c;
        }

        /**
         * closeConnection(Connection c)
         */
        public static void closeConnection(Connection c) {
                if (c != null) {
                        try {
                                c.close();
                        } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }

        }
}
