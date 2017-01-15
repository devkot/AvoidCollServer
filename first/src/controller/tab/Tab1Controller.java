package controller.tab;

import controller.MainController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

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

    @FXML public Label lblx,lbl1,lbl2,lbl3,lbl4;
    @FXML private TextField txt1,txt2,txt3,txt4,txt5;
    @FXML private Button btn1Save;
    @FXML private Button btn1Send;
    private PreparedStatement preparedStatement;
    //private String query = " ";
    //private TextArea ta = new TextArea();


    @FXML private void btn1SaveClicked(ActionEvent event) {
        System.out.println("Btn 1 save clicked");

        ObservableList<ObservableList> data;
        TableView tableview = new TableView();

        data = FXCollections.observableArrayList();
        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Laoded");

            //Open a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Success Connection with the database");

            // Execute queries

                /*System.out.println("Creating statement1...");
                String queryString1 = "SELECT * FROM Measurements  WHERE TerminalName = ?  ";
                preparedStatement = conn.prepareStatement(queryString1);
                preparedStatement.setString(1, txt1.getText());
                ResultSet rs1 = preparedStatement.executeQuery();
                while (rs1.next())
                {
                    //Retrieve by column name
                    String terminalname = rs1.getString("TerminalName");
                    String location = rs1.getString("Location");
                    String type_calculation = rs1.getString("Type_Calc");
                    String date_time = rs1.getString("Date_Time");
                    String confirmation = rs1.getString("Confirmed");
                    //Display values
                    System.out.format("%s, %s, %s, %s, %s\n", terminalname, location, type_calculation, date_time, confirmation);
                }

                System.out.println("Creating statement2...");
                String queryString2 = "SELECT * FROM Measurements  WHERE Location = ?  ";
                preparedStatement = conn.prepareStatement(queryString2);
                preparedStatement.setString(1, txt2.getText());
                ResultSet rs2 = preparedStatement.executeQuery();
            while (rs2.next())
            {
                //Retrieve by column name
                String terminalname = rs2.getString("TerminalName");
                String location = rs2.getString("Location");
                String type_calculation = rs2.getString("Type_Calc");
                String date_time = rs2.getString("Date_Time");
                String confirmation = rs2.getString("Confirmed");
                //Display values
                System.out.format("%s, %s, %s, %s, %s\n", terminalname, location, type_calculation, date_time, confirmation);
            }

             System.out.println("Creating statement3...");
                String queryString3 = "SELECT * FROM Measurements  WHERE Type_Calc = ?  ";
                preparedStatement = conn.prepareStatement(queryString3);
                preparedStatement.setString(1, txt3.getText());
                ResultSet rs3 = preparedStatement.executeQuery();
            while (rs3.next())
            {
                //Retrieve by column name
                String terminalname = rs3.getString("TerminalName");
                String location = rs3.getString("Location");
                String type_calculation = rs3.getString("Type_Calc");
                String date_time = rs3.getString("Date_Time");
                String confirmation = rs3.getString("Confirmed");
                //Display values
                System.out.format("%s, %s, %s, %s, %s\n", terminalname, location, type_calculation, date_time, confirmation);
            }*/

            System.out.println("Creating statement4...");
            String queryString4 = "SELECT * FROM Measurements  WHERE Date_Time = ?  ";
            preparedStatement = conn.prepareStatement(queryString4);
            preparedStatement.setString(1, txt4.getText());
            ResultSet rs4 = preparedStatement.executeQuery();

            for (int i = 0; i < rs4.getMetaData().getColumnCount(); i++) {

                //We are using non property style for making dynamic table

                final int j = i;

                TableColumn col = new TableColumn(rs4.getMetaData().getColumnName(i + 1));
                //noinspection Convert2Lambda
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>()
                {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }

                });

                tableview.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");

            }

            while (rs4.next()) {
                //Iterate Row

                ObservableList<String> row = FXCollections.observableArrayList();

                for (int i = 1; i <= rs4.getMetaData().getColumnCount(); i++) {

                    //Iterate Column

                    row.add(rs4.getString(i));

                }

                System.out.println("Row [1] added " + row);
                data.add(row);


            }
            //FINALLY ADDED TO TableView

            tableview.setItems(data);

            //Retrieve by column name
            String terminalname = rs4.getString("TerminalName");
            String location = rs4.getString("Location");
            String type_calculation = rs4.getString("Type_Calc");
            String date_time = rs4.getString("Date_Time");
            String confirmation = rs4.getString("Confirmed");
            //Display values
            System.out.format("%s, %s, %s, %s, %s\n", terminalname, location, type_calculation, date_time, confirmation);





              /*  System.out.println("Creating statement5...");
                String queryString5 = "SELECT * FROM Measurements  WHERE Confirmed = ?  ";
                preparedStatement = conn.prepareStatement(queryString5);
                preparedStatement.setString(1, txt5.getText());
                ResultSet rs5 = preparedStatement.executeQuery();
            while (rs5.next())
            {
                //Retrieve by column name
                String terminalname = rs5.getString("TerminalName");
                String location = rs5.getString("Location");
                String type_calculation = rs5.getString("Type_Calc");
                String date_time = rs5.getString("Date_Time");
                String confirmation = rs5.getString("Confirmed");
                //Display values
                System.out.format("%s, %s, %s, %s, %s\n", terminalname, location, type_calculation, date_time, confirmation);
            }*/


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }



    public void init(MainController mainController) {main = mainController;}
}