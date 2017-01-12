import org.eclipse.paho.client.mqttv3.MqttException;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.DriverManager;


/** * Created by wallflower on 19/12/2016.
 */
public class SampleMain {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/my_db";
    private static final String user = "root";
    private static final String password = "4ndp5$$$";

    public static void main (String id,String loc,String type_calc,String time) throws MqttException {
        //Publisher.main(text);
        //System.out.println("Success");

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Success Connection with the database");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Measures";
            //sql = "INSERT INTO Measures(TerminalName,Location,Type_Calc,Date_Time)VALUES ($[id],)";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String terminalname = rs.getString("TerminalName");
                String location = rs.getString("Location");
                String type_calculation = rs.getString("Type_Calc");
                String date_time= rs.getString("Date_Time");

                //Display values
                System.out.println("TerminalName: " + terminalname);
                System.out.println("Location: " + location);
                System.out.println("Type & Calculation: " + type_calculation);
                System.out.println("Date & Time: " + date_time);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
