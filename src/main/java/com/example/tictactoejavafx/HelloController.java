package com.example.tictactoejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.Objects;

public class HelloController {

    String nextSymbol = "x";
    String[][] arr = new String[3][3];
    boolean checkWin(String[][] arr){
        if((arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2]&&arr[0][0] !=null)||(arr[1][0] == arr[1][1] && arr[1][0] == arr[1][2]&&arr[1][1] !=null)||(arr[2][0] == arr[2][1] && arr[2][0] == arr[2][2]&&arr[2][2] !=null)){
            return true;
        }
        if((arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0]&&arr[0][0] !=null)||(arr[0][1] == arr[1][1] && arr[0][1] == arr[2][1]&&arr[1][1] !=null)||(arr[0][2] == arr[1][2] && arr[0][2] == arr[2][2]&&arr[2][2] !=null)){
            return true;
        }
        if((arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] && arr[0][0] !=null) || (arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0] &&arr[0][2]!=null)){
            return true;
        }
        return false;
    }
    @FXML
    void onHelloButtonClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        btn.setText(nextSymbol);
        int x = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);
        int y = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        arr[x][y] = nextSymbol;
        if(checkWin(arr)) System.out.println("win");
        if(nextSymbol == "x") nextSymbol = "o";
        else nextSymbol = "x";
    }
    @FXML
    void initialize(){

    }
}
