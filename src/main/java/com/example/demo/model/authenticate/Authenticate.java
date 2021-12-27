package com.example.demo.model.authenticate;

import com.example.demo.model.Personel;
import com.example.demo.model.database.Database;
import com.example.demo.view.homepage.HomePage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Authenticate {
    public static void logIn(String sqlCommand,Button button){
        try {
            Statement stm = Objects.requireNonNull(Database.getConnection("")).createStatement();
            ResultSet rs = stm.executeQuery(sqlCommand);
            if (rs.next()){
                Stage stage = (Stage) button.getScene().getWindow();
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("/com/example/demo/otomasyon-view.fxml"));
                Stage registerPage = new Stage();
                registerPage.setScene(new Scene(fxmlLoader.load()));
                registerPage.show();


            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Hatalı şifre ya da email.");
                alert.show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
