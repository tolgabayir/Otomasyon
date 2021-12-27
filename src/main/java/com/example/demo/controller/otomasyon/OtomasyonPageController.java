package com.example.demo.controller.otomasyon;


import com.example.demo.model.*;
import com.example.demo.model.database.Database;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.time.LocalDateTime;


public class OtomasyonPageController {
    @FXML
    private ListView<String> otomasyonpage_faturalist;
    @FXML
    private Label otomasyonpage_toplamsabitlabel;
    @FXML
    private Label otomasyonpage_toplamlabel;
    @FXML
    private Button otomasyonpage_subutton;
    @FXML
    private Button otomasyonpage_caybutton;
    @FXML
    private Button otomasyonpage_filtrekahbutton;
    @FXML
    private Button otomasyonpage_hamburgerbutton;
    @FXML
    private Button otomasyonpage_pizzabutton;
    @FXML
    private Button otomasyonpage_ekmekkadbutton;
    @FXML
    private Button otomasyonpage_faturaOlusturbutton;
    @FXML
    private Button otomasyonpage_temizlebutton;


    static Double toplamFiyat = 0.00;

    Fatura fatura = new Fatura(LocalDateTime.now(),toplamFiyat);

    @FXML
    protected void onClickSuButton() {
        Su su = new Su();
        otomasyonpage_faturalist.getItems().add(su.urunAd+ " : "+ su.urunFiyat + " TL");
        toplamFiyat = toplamFiyat + su.urunFiyat;
        otomasyonpage_toplamlabel.setText((toplamFiyat + "0 TL"));
        fatura.checkExistorAddFatura(su);


    }

    @FXML
    void onClickCayButton() {
        Cay cay = new Cay();
        otomasyonpage_faturalist.getItems().add(cay.urunAd + " : " + cay.urunFiyat + " TL");
        toplamFiyat = toplamFiyat + cay.urunFiyat;
        otomasyonpage_toplamlabel.setText(toplamFiyat + "0 TL");
        fatura.checkExistorAddFatura(cay);

    }

    @FXML
    void onClickFiltrekahButton() {
        FiltreKahve filtreKahve = new FiltreKahve();
        otomasyonpage_faturalist.getItems().add(filtreKahve.urunAd + " : " + filtreKahve.urunFiyat + " TL");
        toplamFiyat = toplamFiyat + filtreKahve.urunFiyat;
        otomasyonpage_toplamlabel.setText(toplamFiyat + "0 TL");
        fatura.checkExistorAddFatura(filtreKahve);


    }

    @FXML
    void onClickHamburgerButton() {
        Hamburger hamburger = new Hamburger();
        otomasyonpage_faturalist.getItems().add(hamburger.urunAd + " : " + hamburger.urunFiyat + " TL");
        toplamFiyat = toplamFiyat + hamburger.urunFiyat;
        otomasyonpage_toplamlabel.setText(toplamFiyat + "0 TL");
        fatura.checkExistorAddFatura(hamburger);

    }

    @FXML
    void onClickPizzaButton() {
        Pizza pizza = new Pizza();
        otomasyonpage_faturalist.getItems().add(pizza.urunAd + " : " + pizza.urunFiyat + " TL");
        toplamFiyat = toplamFiyat + pizza.urunFiyat;
        otomasyonpage_toplamlabel.setText(toplamFiyat + "0 TL");
        fatura.checkExistorAddFatura(new Pizza());

    }

    @FXML
    void onClickEkmekkadButton() {
        EkmekKadayifi ekmekKadayifi = new EkmekKadayifi();
        otomasyonpage_faturalist.getItems().add(ekmekKadayifi.urunAd + " : " + ekmekKadayifi.urunFiyat + " TL");
        toplamFiyat = toplamFiyat + ekmekKadayifi.urunFiyat;
        otomasyonpage_toplamlabel.setText(toplamFiyat + "0 TL");
        fatura.checkExistorAddFatura(new EkmekKadayifi());

    }

    @FXML
    void onClickFaturaOlusturButton() throws Exception {
        fatura.tarih= LocalDateTime.now();
        fatura.fiyat=toplamFiyat;
        System.out.println("Fatura Ürünler: "+fatura.sepet);
        System.out.println("Fatura Fiyat: "+fatura.fiyat);
        System.out.println("Fatura Tarihi: "+fatura.tarih);
        System.out.println("Personel: "+Personel.personelAd+" "+Personel.personelSoyad);


        Database.insertTable("","insert into fatura ( tarih, fiyat)"+
                " values ('"+fatura.tarih+"',"+" '"+ fatura.fiyat+"') ");



    }
    @FXML
    void onClickTemizleButton(){
        otomasyonpage_faturalist.getItems().clear();
        toplamFiyat=0.0;
        otomasyonpage_toplamlabel.setText(" ");
    }

}

