/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetiles;

import java.beans.EventHandler;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;
import thetiles.TilesLogic;

/**
 *
 * @author SHIVA
 */
public class FXMLDocumentController implements Initializable {

    private TilesLogic gl = new TilesLogic();
    private List<List<Integer>> game;
    private int moves = 0;
    private boolean enough = false;

    @FXML
    private Label C1;
    @FXML
    private Label C2;
    @FXML
    private Label C3;
    @FXML
    private Label C4;
    @FXML
    private Label C5;
    @FXML
    private Label C6;
    @FXML
    private Label C7;
    @FXML
    private Label C8;
    @FXML
    private Label C9;
    @FXML
    private Label C10;
    @FXML
    private Label C11;
    @FXML
    private Label C12;
    @FXML
    private Label C13;
    @FXML
    private Label C14;
    @FXML
    private Label C15;
    @FXML
    private Label C16;
    @FXML
    private Label move;
    @FXML
    private VBox mainpanel;
    @FXML
    private Label timer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = gl.shuffle();
        SetValues();
        timers.start();
    }

    Thread timers = new Thread(() -> {
        SimpleDateFormat df = new SimpleDateFormat("mm:ss");
        Calendar cal = Calendar.getInstance();
        try {
            Date mytime = df.parse("00:00");
            Date ini = mytime;
            cal.setTime(mytime);
        while (!enough) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                cal.setTime(ini);
            }
            cal.add(Calendar.SECOND, 1);
            Platform.runLater(() -> {
                timer.setText("   " + df.format(cal.getTime()));
            });
        }}
        catch (ParseException e) {
        }
    });

    void SetValues() {

        move.setText("Moves : " + String.valueOf(moves) + "  ");

        if (game.get(0).get(0) == 0) {
            C1.setStyle("-fx-background-color: #F5DEB3 ;");
            C1.setText("");
        } else {
            C1.setStyle("-fx-background-color: transparent ;");
            C1.setText(String.valueOf(game.get(0).get(0)));
        }

        if (game.get(0).get(1) == 0) {
            C2.setStyle("-fx-background-color: #F5DEB3 ;");
            C2.setText("");
        } else {
            C2.setStyle("-fx-background-color: transparent ;");
            C2.setText(String.valueOf(game.get(0).get(1)));
        }

        if (game.get(0).get(2) == 0) {
            C3.setStyle("-fx-background-color: #F5DEB3 ;");
            C3.setText("");
        } else {
            C3.setStyle("-fx-background-color: transparent ;");
            C3.setText(String.valueOf(game.get(0).get(2)));
        }

        if (game.get(0).get(3) == 0) {
            C4.setStyle("-fx-background-color: #F5DEB3 ;");
            C4.setText("");
        } else {
            C4.setStyle("-fx-background-color: transparent ;");
            C4.setText(String.valueOf(game.get(0).get(3)));
        }

        if (game.get(1).get(0) == 0) {
            C5.setStyle("-fx-background-color: #F5DEB3 ;");
            C5.setText("");
        } else {
            C5.setStyle("-fx-background-color: transparent ;");
            C5.setText(String.valueOf(game.get(1).get(0)));
        }

        if (game.get(1).get(1) == 0) {
            C6.setStyle("-fx-background-color: #F5DEB3 ;");
            C6.setText("");
        } else {
            C6.setStyle("-fx-background-color: transparent ;");
            C6.setText(String.valueOf(game.get(1).get(1)));
        }

        if (game.get(1).get(2) == 0) {
            C7.setStyle("-fx-background-color: #F5DEB3 ;");
            C7.setText("");
        } else {
            C7.setStyle("-fx-background-color: transparent ;");
            C7.setText(String.valueOf(game.get(1).get(2)));
        }

        if (game.get(1).get(3) == 0) {
            C8.setStyle("-fx-background-color: #F5DEB3 ;");
            C8.setText("");
        } else {
            C8.setStyle("-fx-background-color: transparent ;");
            C8.setText(String.valueOf(game.get(1).get(3)));
        }

        if (game.get(2).get(0) == 0) {
            C9.setStyle("-fx-background-color: #F5DEB3 ;");
            C9.setText("");
        } else {
            C9.setStyle("-fx-background-color: transparent ;");
            C9.setText(String.valueOf(game.get(2).get(0)));
        }

        if (game.get(2).get(1) == 0) {
            C10.setStyle("-fx-background-color: #F5DEB3 ;");
            C10.setText("");
        } else {
            C10.setStyle("-fx-background-color: transparent ;");
            C10.setText(String.valueOf(game.get(2).get(1)));
        }

        if (game.get(2).get(2) == 0) {
            C11.setStyle("-fx-background-color: #F5DEB3 ;");
            C11.setText("");
        } else {
            C11.setStyle("-fx-background-color: transparent ;");
            C11.setText(String.valueOf(game.get(2).get(2)));
        }

        if (game.get(2).get(3) == 0) {
            C12.setStyle("-fx-background-color: #F5DEB3 ;");
            C12.setText("");
        } else {
            C12.setStyle("-fx-background-color: transparent ;");
            C12.setText(String.valueOf(game.get(2).get(3)));
        }

        if (game.get(3).get(0) == 0) {
            C13.setStyle("-fx-background-color: #F5DEB3 ;");
            C13.setText("");
        } else {
            C13.setStyle("-fx-background-color: transparent ;");
            C13.setText(String.valueOf(game.get(3).get(0)));
        }

        if (game.get(3).get(1) == 0) {
            C14.setStyle("-fx-background-color: #F5DEB3 ;");
            C14.setText("");
        } else {
            C14.setStyle("-fx-background-color: transparent ;");
            C14.setText(String.valueOf(game.get(3).get(1)));
        }

        if (game.get(3).get(2) == 0) {
            C15.setStyle("-fx-background-color: #F5DEB3 ;");
            C15.setText("");
        } else {
            C15.setStyle("-fx-background-color: transparent ;");
            C15.setText(String.valueOf(game.get(3).get(2)));
        }

        if (game.get(3).get(3) == 0) {
            C16.setStyle("-fx-background-color: #F5DEB3 ;");
            C16.setText("");
        } else {
            C16.setStyle("-fx-background-color: transparent ;");
            C16.setText(String.valueOf(game.get(3).get(3)));
        }
    }

    @FXML
    private void operation(javafx.scene.input.KeyEvent event) {
        List<Integer>x = gl.findPos(game);
        switch (event.getCode()) {
            case UP:
                game = gl.upMove(game);
                break;
            case DOWN:
                game = gl.downMove(game);
                break;
            case LEFT:
                game = gl.leftMove(game);
                break;
            case RIGHT:
                game = gl.rightMove(game);
                break;
            default:
                return;
        }
        if(!x.equals(gl.findPos(game)))
            moves++;
        
        SetValues();
        if (gl.isWin(game)) {
            enough = true;
            Alert win = new Alert(Alert.AlertType.INFORMATION);
            win.setHeaderText("You Done it");
            win.setContentText("Required Moves : " + String.valueOf(moves) + "\nRequired Time : " + timer.getText());
            win.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK  || response == ButtonType.CLOSE) {
                    game = gl.shuffle();
                    moves = 0;
                    timers.interrupt();
                    enough = false;
                }
            });
        }
    }
    
}
