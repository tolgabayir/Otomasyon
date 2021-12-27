module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;


    exports com.example.demo;
    opens com.example.demo to javafx.fxml;

    exports com.example.demo.view.homepage;
    opens com.example.demo.view.homepage to javafx.fxml;
    exports com.example.demo.view.otomasyonpage;
    opens com.example.demo.view.otomasyonpage to javafx.fxml;
    exports com.example.demo.view.registerpage;
    opens com.example.demo.view.registerpage to javafx.fxml;


    exports com.example.demo.controller.login;
    opens com.example.demo.controller.login to javafx.fxml;
    exports com.example.demo.controller.otomasyon;
    opens com.example.demo.controller.otomasyon to javafx.fxml;
    exports com.example.demo.controller.register;
    opens com.example.demo.controller.register to javafx.fxml;


}