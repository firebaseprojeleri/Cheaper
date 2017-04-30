package com.complaint.kimyonsal.cheapernew.Models;

/**
 * Created by kimyonsal on 26.04.2017.
 */

public class UrunlerModel {
    public  String urunFiyat,urunMiktar,urunAdet,urunMarka,urunIcerik;

    public UrunlerModel() {
    }

    public UrunlerModel(String urunFiyat, String urunMiktar,
                        String urunAdet, String urunMarka, String urunIcerik) {
        this.urunFiyat = urunFiyat;
        this.urunMiktar = urunMiktar;
        this.urunAdet = urunAdet;
        this.urunMarka = urunMarka;
        this.urunIcerik = urunIcerik;
    }

}
