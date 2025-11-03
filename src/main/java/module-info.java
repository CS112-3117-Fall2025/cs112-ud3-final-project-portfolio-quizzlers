module com.example.quizzlers {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quizzlers to javafx.fxml;
    exports com.example.quizzlers;
}