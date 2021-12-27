package com.example.demo.controller.register;

import com.example.demo.model.database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegisterViewController {
    @FXML
    private Button registerpage_registerbutton;
    @FXML
    private TextField registerpage_nametextfield;
    @FXML
    private TextField registerpage_surnametextfield;
    @FXML
    private TextField registerpage_emailtextfield;
    @FXML
    private PasswordField registerpage_password_passwordfield ;


    @FXML
    void onClickRegisterButton() throws SQLException {
        String name = registerpage_nametextfield.getText();
        String surname = registerpage_surnametextfield.getText();
        String email = registerpage_emailtextfield.getText();
        String password = registerpage_password_passwordfield.getText();
        //konrol işlemlerini yap..
        Database.insertTable("","INSERT INTO personel ( personelAd, personelSoyad, personelEmail, personelSifre )" +
                " values ( '"+name+"',"+" '"+surname+"', "+"'"+email+"', "+"'"+password+"') ");
    }
}
