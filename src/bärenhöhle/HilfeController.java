/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bärenhöhle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gergö Szijarto
 */
public class HilfeController implements Initializable {

    @FXML
    private Button btnAight;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aightClicked(ActionEvent event) {
        closeWindow();
    }
    
    private void closeWindow() {
        final Stage stage = (Stage) btnAight.getScene().getWindow();
        stage.close();
    }
    
}
