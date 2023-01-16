package com.example.sandcastle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.Parent;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.io.IOException;
import java.sql.*;

import java.sql.*;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import static com.example.sandcastle.Main.hideWindow;

public class Controller {
    @FXML
    private Button cancelButton, temperatureButton, employeesButton, phMeterButton, floodGateButton, dashboardButton;
    @FXML
    private Button cloudinessButton, floodGateOpen, floodGateClose;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordPasswordField;

    // window na login scherm, dashboard scherm
    public void switchToScene2(Stage stage2) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("homeScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1315, 810);
        stage2.setTitle("Control Panel");
        stage2.setScene(scene);
        stage2.show();
    }

    public void handleDashboardScene() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        Stage window = (Stage) dashboardButton.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 810));
    }

    public void handleTemp() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("temperatureScene.fxml"));
        Stage window = (Stage) temperatureButton.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 810));
    }

    public void handleEmployees() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("employeesScene.fxml"));
        Stage window = (Stage) employeesButton.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 810));
    }
    public void handlePHMeter() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("phMeterScene.fxml"));
        Stage window = (Stage) phMeterButton.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 810));
    }
    public void handleCloudiness() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("cloudinessScene.fxml"));
        Stage window = (Stage) cloudinessButton.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 810));
    }
    public void handleFloodGate() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("floodGateScene.fxml"));
        Stage window = (Stage) floodGateButton.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 810));
    }


    public void loginButtonOnAction(ActionEvent e) {

        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            // loginMessageLabel.setText("Incorrect username or password!");
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select count(1) from UserAccounts where username = '" + usernameTextField.getText() + "' and password = '" + passwordPasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            Main m = new Main();

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Welcome!");
                    hideWindow();
                    switchToScene2(new Stage());
                } else {
                    loginMessageLabel.setText("Invalid Login. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

