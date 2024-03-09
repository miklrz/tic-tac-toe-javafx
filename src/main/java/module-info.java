module com.example.tictactoejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tictactoejavafx to javafx.fxml;
    exports com.example.tictactoejavafx;
}