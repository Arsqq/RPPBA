package com.example.rppbaproject.Controllers;


import com.example.rppbaproject.Domain.EndProduct;
import com.example.rppbaproject.Domain.User;
import com.example.rppbaproject.Repo.EndProductRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Done {

    @Autowired
    EndProductRepo endProductRepo;

    @FXML
    private TableView<EndProduct> TableVar;

    @FXML
    private TableColumn<EndProduct, Integer> id;

    @FXML
    private TableColumn<EndProduct, String> name;

    @FXML
    private TableColumn<EndProduct, Integer> quantity;

    @FXML
    private TableColumn<EndProduct, Integer> article;

    @FXML
    private Button update;

    ObservableList<EndProduct> observableList = FXCollections.observableArrayList();

    @FXML
    void updateButton() {
        observableList.clear();
        observableList.addAll(endProductRepo.findAll());

        id.setCellValueFactory(new PropertyValueFactory<EndProduct, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<EndProduct, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<EndProduct, Integer>("amount"));
        article.setCellValueFactory(new PropertyValueFactory<EndProduct, Integer>("vendorCode"));
        TableVar.setItems(observableList);
    }
}