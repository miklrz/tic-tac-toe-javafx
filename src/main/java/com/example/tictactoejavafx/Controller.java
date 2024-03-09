package com.example.tictactoejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Controller {

    String nextSymbol = "x";

    @FXML
    private Text winnerText;

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    ArrayList<Button> buttons;
    String[][] arr = new String[3][3];
    boolean checkWin(String[][] arr){
        if((Objects.equals(arr[0][0], arr[0][1]) && Objects.equals(arr[0][0], arr[0][2]) &&arr[0][0] !=null)||(Objects.equals(arr[1][0], arr[1][1]) && Objects.equals(arr[1][0], arr[1][2]) &&arr[1][1] !=null)||(Objects.equals(arr[2][0], arr[2][1]) && Objects.equals(arr[2][0], arr[2][2]) &&arr[2][2] !=null)){
            return true;
        }
        if((Objects.equals(arr[0][0], arr[1][0]) && Objects.equals(arr[0][0], arr[2][0]) &&arr[0][0] !=null)||(Objects.equals(arr[0][1], arr[1][1]) && Objects.equals(arr[0][1], arr[2][1]) &&arr[1][1] !=null)||(Objects.equals(arr[0][2], arr[1][2]) && Objects.equals(arr[0][2], arr[2][2]) &&arr[2][2] !=null)){
            return true;
        }
        return (Objects.equals(arr[0][0], arr[1][1]) && Objects.equals(arr[0][0], arr[2][2]) && arr[0][0] != null) || (Objects.equals(arr[0][2], arr[1][1]) && Objects.equals(arr[0][2], arr[2][0]) && arr[0][2] != null);
    }

    boolean checkDraw(String[][] arr){
        for(String[] i : arr){
            for(String j : i){if (j==null)return false;}
        }
        return true;
    }

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        btn.setText(nextSymbol);
        btn.setDisable(true);
        int x = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);
        int y = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        arr[x][y] = nextSymbol;
        if(checkWin(arr)) {
            winnerText.setText(nextSymbol.toUpperCase() + " Won!");
            buttons.forEach(this::setDisable);
            nextSymbol = "x";
            return;
        }
        if(checkDraw(arr)){
            winnerText.setText("Draw!");
            buttons.forEach(this::setDisable);
            nextSymbol = "x";
            return;
        }
        if(Objects.equals(nextSymbol, "x")) nextSymbol = "o";
        else nextSymbol = "x";
    }

    @FXML
    void resetButton() {
        winnerText.setText("");
        buttons.forEach(this::resetButtons);
        arr = new String[3][3];
    }

    void resetButtons(Button btn){
        btn.setDisable(false);
        btn.setText("");
    }

    void setDisable(Button btn){
        btn.setDisable(true);
    }

    @FXML
    void initialize(){
        buttons = new ArrayList<>( Arrays.asList(button00,button01,button02,button10,button11,button12,button20,button21, button22));
    }
}
