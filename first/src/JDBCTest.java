/**
 * Created by wallflower on 24/12/2016.
 */

import java.sql.Connection;
import java.sql.DriverManager;


class JDBCTest {

    private static final String url = "jdbc:mysql://localhost";

    private static final String user = "root";

    private static final String password = "4ndp5$$$";


    public static void main(String args[]) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}