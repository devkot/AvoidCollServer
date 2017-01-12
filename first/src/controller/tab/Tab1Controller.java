/*
 * Created by wallflower on 9/1/2017.


package controller.tab;

import controller.MainController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Tab1Controller {

    private MainController main;

    @FXML
    public Label lbl1;
    @FXML
    private TextField txt1;
    @FXML
    private Button btn1Save;
    @FXML
    private Button btn1Send;

    @FXML
    public void btn1SaveClicked(ActionEvent event) extends Application

    {
        System.out.println("Btn 1 save clicked");


        lbl1.setText(txt1.getText());

        TextField txt = new TextField();
        txt.setPromptText("Search");
        txt.textProperty().addListener(
                new ChangeListener() {
                    public void changed(ObservableValue observable, Object oldVal, Object newVal) {
                        handleSearchByKey2((String) oldVal, (String) newVal);
                    }
                });


    /*@FXML private void btn1SendClicked(ActionEvent event) {
        System.out.println("Btn 1 send clicked");
        // Send text from txt1 to lbl2 on Tab 2
        main.setTab2LabelText(txt1.getText());
    }

    public void init(MainController mainController) {
        main = mainController;
    }




    public void handleSearchByKey2(String oldVal, String newVal) {

        ///////////////////////////////////////

        ObservableList<String> entries = FXCollections.observableArrayList();
        ListView list = new ListView();

        //////////////////////////////
        // If the number of characters in the text box is less than last time
        // it must be because the user pressed delete
        if (oldVal != null && (newVal.length() < oldVal.length())) {
            // Restore the lists original set of entries
            // and start from the beginning
            list.setItems(entries);
        }

        // Break out all of the parts of the search text
        // by splitting on white space
        String[] parts = newVal.toUpperCase().split(" ");

        // Filter out the entries that don't contain the entered text
        ObservableList<String> subentries = FXCollections.observableArrayList();
        for (Object entry : list.getItems()) {
            boolean match = true;
            String entryText = (String) entry;
            for (String part : parts) {
                // The entry needs to contain all portions of the
                // search string *but* in any order
                if (!entryText.toUpperCase().contains(part)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                subentries.add(entryText);
            }
        }
        list.setItems(subentries);
    }
}
}
*/

package controller.tab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import controller.MainController;

public class Tab1Controller {

    private MainController main;

    @FXML public Label lbl1;
    @FXML private TextField txt1;
    @FXML private Button btn1Save;
    @FXML private Button btn1Send;

    @FXML private void btn1SaveClicked(ActionEvent event) {
        System.out.println("Btn 1 save clicked");

        lbl1.setText(txt1.getText());
    }



    public void init(MainController mainController) {
        main = mainController;
    }
}