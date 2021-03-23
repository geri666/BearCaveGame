/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bärenhöhle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Gergö Szijarto
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button btnStart;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void startPressed(ActionEvent event) throws IOException {
        closeWindow();
        showPage("Spiel");
    }
    
    private void showPage(String pageNameString) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource(pageNameString + ".fxml"));
        Parent root1 = (Parent) fXMLLoader.load();
        Stage stage = new Stage();
        stage.setTitle(pageNameString);
        stage.setScene(new Scene(root1));
        stage.show();
    }
    
    private void closeWindow() {
        final Stage stage = (Stage) btnStart.getScene().getWindow();
        stage.close();
    }

    
    
    
}
