package com.example.rppbaproject.Controllers;

import com.example.rppbaproject.Domain.Role;
import com.example.rppbaproject.Domain.User;
import com.example.rppbaproject.Repo.RoleRepo;
import com.example.rppbaproject.Repo.UserRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Admin {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @FXML
    private Button EditButton;

    @FXML
    private Button ViewButton;

    @FXML
    private TableView<User> TableVar;

    @FXML
    private TableColumn<User, Integer> id;

    @FXML
    private TableColumn<User, String> login;

    @FXML
    private TableColumn<User, String> name;

    @FXML
    private TableColumn<User, String> surname;

    @FXML
    private TableColumn<User, Role> role;

    @FXML
    private TextField idEdit;

    @FXML
    private TextField RoleEdit;

    ObservableList<User> observableList = FXCollections.observableArrayList();

    String roleName;

    @FXML
    private void handleAllUsersButton() {
        observableList.clear();
        observableList.addAll(userRepo.findAll());
        for (User user : observableList) {
            if(user.getRole()!=null){
                roleName=user.getRole().getName();
                user.setRoleName(roleName);
            }
        }
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            login.setCellValueFactory(new PropertyValueFactory<>("login"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
            role.setCellValueFactory(new PropertyValueFactory<>("roleName") );
            TableVar.setItems(observableList);
    }

    @FXML
    private void handleRoleButton() {
        User userForEditing=userRepo.findById(Integer.parseInt(idEdit.getText()));
        userForEditing.setRole(roleRepo.findByName(RoleEdit.getText()));

        userRepo.save(userForEditing);
        handleAllUsersButton();

    }
}
