package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.*;

public class Fatura implements FaturaIslemleri {
    public LocalDateTime tarih;
    public Double fiyat;
    public Map<String,Integer> sepet;
    

    public Fatura(LocalDateTime tarih, Double toplamFatura){
        this.tarih=tarih;
        this.fiyat=toplamFatura;
        this.sepet= new HashMap<>();

    }

    public Fatura(){
        super();
    }
    @Override
    public void checkExistorAddFatura(Urun urun){
        if (sepet.containsKey(urun.urunAd)) {
            sepet.put(urun.urunAd, sepet.get(urun.urunAd) + 1);
        } else {
            sepet.put(urun.urunAd, 1);
        };


    }


}
interface FaturaIslemleri {
    public void checkExistorAddFatura(Urun urun);
}