import org.eclipse.paho.client.mqttv3.MqttException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/** * Created by wallflower on 19/12/2016.
 */
public class SampleMain {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/my_db";
    private static final String user = "root";
    private static final String password = "4ndp5$$$";

    public static void main (String id,String loc,String type_calc,String time,Boolean confirmed) throws MqttException {
        //Publisher.main(text);
        //System.out.println("Success");
        String conf = String.valueOf(confirmed);//change from boolean to string

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Success Connection with the database");

            //STEP 4: Execute a query
            ////////insert queries
            System.out.println("Creating statement...");
            Statement stm = conn.createStatement();
            String sql1;
            sql1 = "INSERT INTO Measurements(TerminalName,Location,Type_Calc,Date_Time,Confirmed) VALUES ('"+id+"','"+loc+"','"+type_calc+"','"+time+"','"+conf+"')";
            stm.executeUpdate(sql1);
            //////////////////////////////////////
            System.out.println("Creating statement...");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Measurements";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String terminalname = rs.getString("TerminalName");
                String location = rs.getString("Location");
                String type_calculation = rs.getString("Type_Calc");
                String date_time= rs.getString("Date_Time");
                String confirmation= rs.getString("Confirmed");

                //Display values
                System.out.println("TerminalName: " + terminalname);
                System.out.println("Location: " + location);
                System.out.println("Type & Calculation: " + type_calculation);
                System.out.println("Date & Time: " + date_time);
                System.out.println("Confirmed: " + confirmation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
