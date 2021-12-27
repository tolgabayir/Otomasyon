package com.example.demo.controller.login;

import com.example.demo.model.Personel;
import com.example.demo.model.authenticate.Authenticate;
import com.example.demo.model.database.Database;
import com.example.demo.view.homepage.HomePage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class HomePageController {
    @FXML
    private TextField login_email_textfield;
    @FXML
    private PasswordField login_password_passwordfield;
    @FXML
    private Button login_login_button;
    @FXML
    private Button login_register_button;
    @FXML
    void onClick_loginpage_login() throws SQLException {
        String email =login_email_textfield.getText();
        String sifre = login_password_passwordfield.getText();
        Authenticate.logIn("select * from personel where personelEmail='"+email+ "' and personelSifre='"+sifre+ "' ",login_login_button);
        ResultSet resultSet= Database.fromTable("personel","personelEmail",email);
        if (resultSet.next()){
            Personel.personelAd=resultSet.getString("personelAd");
            Personel.personelSoyad=resultSet.getString("personelSoyad");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Hatalı şifre ya da email.");
            alert.show();
        }
        System.out.println(Personel.personelSoyad);


       /* try {
            Statement stm = Objects.requireNonNull(Database.getConnection("")).createStatement();
            String sql = "select * from personel where personelEmail='"+email+ "' and personelSifre='"+sifre+ "'";
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                Stage stage = (Stage) login_login_button.getScene().getWindow();
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("/com/example/demo/otomasyon-view.fxml"));
                Stage registerPage = new Stage();
                registerPage.setScene(new Scene(fxmlLoader.load()));
                registerPage.show();
               ResultSet resultSet= Database.fromTable("personel","personelEmail",email);
               if (resultSet.next()){
                   Personel.personelAd=resultSet.getString("personelAd");
                   Personel.personelSoyad=resultSet.getString("personelSoyad");
               }

            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Hatalı şifre ya da email.");
                alert.show();
            }


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
*/
    }
    @FXML
    void onClick_loginpage_register() throws IOException {
        Stage stage = (Stage) login_register_button.getScene().getWindow();
        stage.close();
        URL fxmLocation = HomePage.class.getResource("/com/example/demo/register-view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmLocation);
        Stage registerPage = new Stage();
        registerPage.setScene(new Scene(fxmlLoader.load()));
        registerPage.show();
    }

}
