/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bärenhöhle;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gergö Szijarto
 */
public class FXMLTippController implements Initializable {

    @FXML
    private Text lblTipp;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // update so it shows tip 1 then 2 then 3 then show no more tips left

        Random rand = new Random();
        int r = rand.nextInt(3);
        switch (r) {
            case 0:
                lblTipp.setText("Die Anzahl ungerader oder gerader Würfel könnten vielleicht die Anzahl Bärenhöhlen sein.");
                break;
            case 1:
                lblTipp.setText("Wie alles im Leben haben auch Würfel eine Kehrseite.");
                break;
            case 2:
                lblTipp.setText("Es können keine Bären ausserhalb einer Bärenhöhle sein.");
                break;

        }
    }

    @FXML
    private void closeTipp(ActionEvent event) {
        final Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

}
