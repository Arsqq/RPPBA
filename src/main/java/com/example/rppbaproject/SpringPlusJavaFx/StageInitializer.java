package com.example.rppbaproject.SpringPlusJavaFx;

import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class StageInitializer implements ApplicationListener<JavaFxApplicationSupport.StageReadyEvent> {


    @Value("classpath:/xml/Authorization.fxml")
    private Resource sceneResourceForRegistration;

    private final ApplicationContext springContext;





    private final String applicationTitle;
    Parent parent;


    @Override
    public void onApplicationEvent(JavaFxApplicationSupport.StageReadyEvent event)
    {

        try {
            FXMLLoader fxmlLoader= new FXMLLoader(sceneResourceForRegistration.getURL());

            fxmlLoader.setControllerFactory(springContext::getBean);
            parent=fxmlLoader.load();
            Stage stage=event.getStage();
            Scene scene=new Scene(parent);
            stage.setScene(scene);
            stage.setTitle(applicationTitle);
            stage.centerOnScreen();
            stage.show();
            stage.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public StageInitializer(ApplicationContext springContext, @Value("${spring.application.ui.title}") String applicationTitle)
    {
        this.springContext = springContext;
        this.applicationTitle=applicationTitle;
    }
}
