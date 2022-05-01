package com.example.rppbaproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Component
public class Technologist {
    @Value("classpath:/xml/Done.fxml")
    private Resource donePath;
    @Value("classpath:/xml/Route.fxml")
    private Resource routePath;
    @Value("classpath:/xml/Specification.fxml")
    private Resource specPath;

    @Autowired
    private SupportController supportController;

    @FXML
    private Button finalProduct;

    @FXML
    private Button route;

    @FXML
    private Button specification;

    @FXML
    void useFinalProduct() {
        supportController.generateFXML(donePath);
    }

    @FXML
    void useRoute() {
        supportController.generateFXML(routePath);
    }

    @FXML
    void useSpecification() {
        supportController.generateFXML(specPath);
    }

}
