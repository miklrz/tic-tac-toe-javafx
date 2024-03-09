package com.example.tictactoejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class HelloController {

    String nextSymbol = "x";
    String[][] arr = new String[3][3];

    boolean checkWin(String[][] arr){
        boolean flag = false;
        for (int y = 0; y < 3; ++y){
            for(int x = 1; x < 3; ++x){
                if(arr[x][y] != arr[x-1][y]) break;
                if(x == 2) return true;
            }
        }
        for (int x = 0; x < 3; ++x){
            for(int y = 1; y < 3; ++y){
                if(arr[x][y] != arr[x][y-1]) break;
                if(y == 2) return true;
            }
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

        if(nextSymbol == "x") nextSymbol = "o";
        else nextSymbol = "x";
    }
    @FXML
    void initialize(){

    }
}
