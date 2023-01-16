module com.example.sandcastle {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires jssc;


    opens com.example.sandcastle to javafx.fxml;
    exports com.example.sandcastle;
}