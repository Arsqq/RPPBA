package com.example.rppbaproject.Controllers;

import com.example.rppbaproject.Domain.EndProduct;
import com.example.rppbaproject.Repo.UserRepo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Authorization {


    @Value("classpath:/xml/Registration.fxml")
    private Resource registrationResource;

    @Value("classpath:/xml/Admin.fxml")
    private Resource adminResource;
    @Value("classpath:/xml/Dispatcher.fxml")
    private Resource DispatcherResource;
    @Value("classpath:/xml/Technologist.fxml")
    private Resource TechnologistResource;
    @Value("classpath:/xml/Master.fxml")
    private Resource MasterResource;

    @Autowired
    SupportController supportController;


    @Autowired
    UserRepo userRepo;


    @FXML
    private TextField loginAuthorizationField;

    @FXML
    private PasswordField passwordAuthorizationField;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton registrationButton;

    @FXML
    private JFXCheckBox passwordCheckBox;

    @FXML
    private void handleLoginButton() {
        switch (userRepo.findByLogin(loginAuthorizationField.getText()).getRole().getName()) {
            case ("Admin"):
                supportController.generateFXML(adminResource);
                break;
            case ("Dispatcher"):
                supportController.generateFXML(DispatcherResource);
                break;
            case ("Master"):
                supportController.generateFXML(MasterResource);
                break;
            case ("Technologist"):
                supportController.generateFXML(TechnologistResource);
                break;
            default:
                System.out.println("Error");
        }
    }

    @FXML
    private void handleRegistrationButton() {
        Stage stage = (Stage) registrationButton.getScene().getWindow();
        supportController.generateFXML(registrationResource);
        stage.close();

    }


}
