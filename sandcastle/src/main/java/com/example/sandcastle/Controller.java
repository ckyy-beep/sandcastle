package com.example.sandcastle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.Node;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import static com.example.sandcastle.Main.hideWindow;

public class Controller {
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    ActionEvent actionEvent;

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordPasswordField;

    public void switchToScene2(Stage stage2) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("homeScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1315, 810);
        stage2.setTitle("Control Panel");
        stage2.setScene(scene);
        stage2.show();
    }

    public void loginButtonOnAction(ActionEvent e)
    {

        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false)
        {
            // loginMessageLabel.setText("Incorrect username or password!");
            validateLogin();
        }
        else
        {
            loginMessageLabel.setText("Please enter username and password.");
        }

    }

    public void cancelButtonOnAction(ActionEvent e)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void validateLogin()
    {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select count(1) from UserAccounts where username = '" + usernameTextField.getText() + "' and password = '" + passwordPasswordField.getText() + "'";

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            Main m = new Main();

            while (queryResult.next())
            {
                if (queryResult.getInt(1) == 1)
                {
                    loginMessageLabel.setText("Welcome!");
                    //m.changeScene("homeScreen.fxml");
                    //((Node)actionEvent.getSource()).getScene().getWindow().hide();
                    hideWindow();
                    switchToScene2(new Stage());
                }
                else
                {
                    loginMessageLabel.setText("Invalid Login. Please try again.");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}