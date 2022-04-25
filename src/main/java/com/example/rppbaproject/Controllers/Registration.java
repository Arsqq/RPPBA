package com.example.rppbaproject.Controllers;

import com.example.rppbaproject.Domain.User;
import com.example.rppbaproject.Repo.UserRepo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class Registration {


    User user;

    @Autowired
    UserRepo userRepo;

    @Autowired
    SupportController supportController;


    @FXML
    private TextField loginTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button registrationButton;

    @FXML
    private PasswordField passwordTextField;

    @Value("classpath:/xml/Authorization.fxml")
    private Resource sceneResourceForAuthorization;

    @FXML
    void handleRegistrationButton() {
        Stage stage=(Stage) registrationButton.getScene().getWindow();
        supportController.generateFXML(sceneResourceForAuthorization);
        stage.close();
        user.setSurname(surnameTextField.getText());
        user.setName(nameTextField.getText());
        user.setPassword(passwordTextField.getText());
        user.setLogin(loginTextField.getText());
        userRepo.save(user);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("REGISTRATION INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText("YOU HAVE SUCCESSFULLY REGISTERED");
        alert.show();
    }

    @FXML
    void initialize() {

    }
}
