package com.example.rppbaproject.Controllers;

import com.example.rppbaproject.Domain.EndProduct;
import com.example.rppbaproject.Domain.Raw;
import com.example.rppbaproject.Repo.RawRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class Specification {

    @Autowired
    RawRepo rawRepo;

    @FXML
    private ImageView del;

    @FXML
    private Button EditButton;

    @FXML
    private TextField NameEdit;

    @FXML
    private TableView<Raw> TableVar;

    @FXML
    private TextField TypeEdit;

    @FXML
    private TableColumn<EndProduct, Integer> id;

    @FXML
    private TextField idEdit;

    @FXML
    private TableColumn<EndProduct, String> name;

    @FXML
    private TableColumn<EndProduct, Integer> quantity;

    @FXML
    private TextField quantityEdit;

    @FXML
    private Button refresh;

    ObservableList<Raw> observableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<EndProduct, Integer> type;

    @FXML
    void deleteSome() {
        Raw rawForEdit = rawRepo.findById(Integer.valueOf(idEdit.getText()));
        rawRepo.delete(rawForEdit);
        refreshAll();
    }

    @FXML
    void editSome() {
        Raw rawForEdit = rawRepo.findById(Integer.parseInt(idEdit.getText()));
        if (NameEdit.getText().equals("")) {
            rawForEdit.setName(rawForEdit.getName());
        } else
            rawForEdit.setName(NameEdit.getText());

        if (TypeEdit.getText().equals("")) {
            rawForEdit.setParametr(rawForEdit.getParametr());
        } else
            rawForEdit.setParametr(TypeEdit.getText());

        if (quantityEdit.getText().equals(""))
            rawForEdit.setAmount(rawForEdit.getAmount());
        else
            rawForEdit.setAmount(Integer.valueOf(quantityEdit.getText()));

        rawRepo.save(rawForEdit);
        refreshAll();
    }

    @FXML
    void refreshAll() {
        observableList.clear();
        observableList.addAll(rawRepo.findAll());

        id.setCellValueFactory(new PropertyValueFactory<EndProduct, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<EndProduct, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<EndProduct, Integer>("amount"));
        type.setCellValueFactory(new PropertyValueFactory<EndProduct, Integer>("parametr"));
        TableVar.setItems(observableList);
    }

}
