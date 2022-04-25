package com.example.rppbaproject;

import com.example.rppbaproject.SpringPlusJavaFx.JavaFxApplicationSupport;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com/example/rppbaproject/Domain")
@SpringBootApplication
@ComponentScan({"com.example.rppbaproject.Controllers","com.example.rppbaproject.SpringPlusJavaFx","com.example.rppbaproject.Repo",
        "com.example.rppbaproject.Domain"})
public class RppbaprojectApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplicationSupport.class,args);
    }

}
