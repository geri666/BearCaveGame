/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bärenhöhle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Gergö Szijarto
 */
public class SpielController implements Initializable {

    @FXML
    private MenuItem menuExit;
    @FXML
    private MenuItem menuHelp;
    @FXML
    private ImageView imgView1;
    @FXML
    private ImageView imgView4;
    @FXML
    private ImageView imgView2;
    @FXML
    private ImageView imgView5;
    @FXML
    private ImageView imgView3;
    @FXML
    private ImageView imgView6;
    @FXML
    private TextField txtFieldBears;
    @FXML
    private TextField txtFieldCaves;
    @FXML
    private Button btnCheck;

    @FXML
    private Button btnNewRoll;
    @FXML
    private MenuItem menuTipp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        play();
    }

    @FXML
    private void gameExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void askedForHelp(ActionEvent event) throws IOException {
        showPage("Hilfe");
    }

    private void showPage(String pageNameString) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource(pageNameString + ".fxml"));
        Parent root1 = (Parent) fXMLLoader.load();
        Stage stage = new Stage();
        stage.setTitle(pageNameString);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    ArrayList<Integer> allNumbers = new ArrayList<>();

    Wuerfel w1 = new Wuerfel();
    Wuerfel w2 = new Wuerfel();
    Wuerfel w3 = new Wuerfel();
    Wuerfel w4 = new Wuerfel();
    Wuerfel w5 = new Wuerfel();
    Wuerfel w6 = new Wuerfel();

    private void roll() {
        w1.wuerfle();
        imgView1.setImage(new Image("Pictures/" + w1.getAugen() + ".png"));
        allNumbers.add(w1.getAugen());
        w2.wuerfle();
        imgView2.setImage(new Image("Pictures/" + w2.getAugen() + ".png"));
        allNumbers.add(w2.getAugen());
        w3.wuerfle();
        imgView3.setImage(new Image("Pictures/" + w3.getAugen() + ".png"));
        allNumbers.add(w3.getAugen());
        w4.wuerfle();
        imgView4.setImage(new Image("Pictures/" + w4.getAugen() + ".png"));
        allNumbers.add(w4.getAugen());
        w5.wuerfle();
        imgView5.setImage(new Image("Pictures/" + w5.getAugen() + ".png"));
        allNumbers.add(w5.getAugen());
        w6.wuerfle();
        imgView6.setImage(new Image("Pictures/" + w6.getAugen() + ".png"));
        allNumbers.add(w6.getAugen());
        System.out.println(allNumbers.toString());

    }

    private void play() {
        allNumbers.clear();
        anzahlBaerenhoehlen = 0;
        anzahlBaeren = 0;
        txtFieldBears.clear();
        txtFieldCaves.clear();
        roll();
        rechnen();
    }

    private int anzahlBaeren;
    private int anzahlBaerenhoehlen;

    private int anzahlBaerenGuess;
    private int anzahlBaerenhoehlenGuess;

    private int fehlVersuche = 0;

    @FXML
    private void checkNumbess(ActionEvent event) throws IOException {
        String anzBaerenString = txtFieldBears.getText();
        String anzHoehlenString = txtFieldCaves.getText();
        boolean numbersFine = false;

        while (!numbersFine) {
            try {

                anzahlBaerenGuess = Integer.parseInt(anzBaerenString);
                anzahlBaerenhoehlenGuess = Integer.parseInt(anzHoehlenString);

                if (anzahlBaeren == anzahlBaerenGuess && anzahlBaerenhoehlen == anzahlBaerenhoehlenGuess) {
                    JOptionPane.showMessageDialog(null,
                            "Super! Sie haben die Anzahl Bären und Anzahl Bärenhöhlen erfolgreich herausgefunden.",
                            "Gratulation!",
                            JOptionPane.INFORMATION_MESSAGE);
                    play();

                } else {
                    fehlVersuche++;
                    System.out.println(fehlVersuche);
                    JOptionPane.showMessageDialog(null,
                            "Ihr Versuch war nicht richtig. Probieren Sie nochmal.",
                            "Leider falsch!",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                if (fehlVersuche == 15
                        || fehlVersuche == 30
                        || fehlVersuche == 45) {
                    showPage("FXMLTipp");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Bitte geben Sie nur Zahlen ein!",
                        "Warnung!",
                        JOptionPane.WARNING_MESSAGE);
                
                break;
            }

            numbersFine = true;

        }

    }

    private void rechnen() {
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        for (int i = 0; i < allNumbers.size(); i++) {
            if (allNumbers.get(i) % 2 == 0) {
            } else {
                anzahlBaerenhoehlen++;
                oddNumbers.add(i + 1);
                anzahlBaeren = anzahlBaeren + getOtherSide(allNumbers.get(i));
            }
        }

        System.out.println("Anzahl Bären: " + anzahlBaeren);
        System.out.println("Anzahl Bärenhöhlen: " + anzahlBaerenhoehlen);

    }

    @FXML
    private void newRoll(ActionEvent event) throws InterruptedException {
        play();
    }

    private int getOtherSide(int num) {
        return 7 - num;
    }

    @FXML
    private void tippRequested(ActionEvent event) throws IOException {
        showPage("FXMLTipp");
    }

}
