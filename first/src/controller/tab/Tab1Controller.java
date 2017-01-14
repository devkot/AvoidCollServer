package controller.tab;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Tab1Controller {

    private MainController main;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/my_db";
    private static final String user = "root";
    private static final String password = "4ndp5$$$";

    @FXML public Label lbl1;
    @FXML private TextField txt1;
    @FXML private Button btn1Save;
    @FXML private Button btn1Send;
    private PreparedStatement preparedStatement;
    private String query = " ";
    private TextArea ta = new TextArea();

    @FXML private void btn1SaveClicked(ActionEvent event) {
        System.out.println("Btn 1 save clicked");

        lbl1.setText(txt1.getText());


        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Laoded");

            //Open a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Success Connection with the database");

            // Execute a query
            /*System.out.println("Creating statement...");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Measurements";
            ResultSet rs = stmt.executeQuery(sql);
            */
            //String queryString = "select" + query + "where" + where.getText ();
            //ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Creating statement...");
            String queryString = "SELECT * FROM Measurements  WHERE Confirmed = ?  " ;
            preparedStatement = conn.prepareStatement(queryString);
            preparedStatement.setString(1,txt1.getText());
            ResultSet rs = preparedStatement.executeQuery();

            /*String queryString = "select" + query + "where" + txt1.getText ();
            preparedStatement = conn.prepareStatement (queryString);
            preparedStatement.setString(1,txt1.getText());
            ResultSet rs = preparedStatement.executeQuery ( );*/

            while (rs.next()) {

                //System.out.println("mpikeeeee");

                //Retrieve by column name
                String terminalname = rs.getString("TerminalName");
                String location = rs.getString("Location");
                String type_calculation = rs.getString("Type_Calc");
                String date_time = rs.getString("Date_Time");
                String confirmation = rs.getString("Confirmed");


                //String finalstring = filter(terminalname) + filter(location) + filter(type_calculation) + filter(date_time) + filter(confirmation);
                //ta.setText(finalstring);

                //Display values
                System.out.format("%s, %s, %s, %s, %s\n", terminalname, location, type_calculation, date_time, confirmation);
                /*System.out.println("TerminalName: " + terminalname);
                System.out.println("Location: " + location);
                System.out.println("Type & Calculation: " + type_calculation);
                System.out.println("Date & Time: " + date_time);
                System.out.println("Confirmed: " + confirmation);*/
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void init(MainController mainController) {
        main = mainController;
    }
}