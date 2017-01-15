/**
 * Created by wallflower on 9/1/2017.
 */
package controller.tab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import controller.MainController;

public class Tab2Controller {

    private MainController main;
    private static float pareAccel=0;
    private static float pareLight=0;
    private static float pareProx=0;
    @FXML public Label lbl2;
    @FXML private TextField txt2,txt21,txt211;
    @FXML private Button btn2Save;
    @FXML private Button btn2Load;

    @FXML private void btn2SaveClicked(ActionEvent event) {
        System.out.println("Btn 2 save clicked");

        //lbl2.setText(txt2.getText());
        pareAccel =Float.valueOf(txt2.getText());
        pareLight =Float.valueOf(txt21.getText());
        pareProx =Float.valueOf(txt211.getText());


    }
    @FXML public float GetAccThresh(){
        return pareAccel;
    }
    @FXML public float GetLightThresh(){
        return pareLight;
    }
    @FXML public float GetProxThresh(){
        return pareProx;
    }

    @FXML private void btn2LoadClicked(ActionEvent event) {
        System.out.println("Btn 2 load clicked");
        lbl2.setText(main.loadLblTextFromTab1());
    }

    public void init(MainController mainController) {
        main = mainController;
    }
}