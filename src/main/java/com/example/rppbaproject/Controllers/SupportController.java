package com.example.rppbaproject.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SupportController {

    private final ApplicationContext springContext;


    public void  generateFXML(Resource sceneResource) {
        try {
            FXMLLoader loader = new FXMLLoader(sceneResource.getURL());
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SupportController(ApplicationContext springContext)
    {
        this.springContext=springContext;
    }
}
