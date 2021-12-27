package com.example.demo.model;

public abstract class Urun {
    public final String urunAd;
    public final Double urunFiyat;
    Urun(String urunAd,Double urunFiyat){
        this.urunAd=urunAd;
        this.urunFiyat=urunFiyat;
    }
}

