package com.complaint.kimyonsal.cheapernew.Models;

import android.content.Context;

/**
 * Created by kimyonsal on 26.04.2017.
 */

public class PostModel {

    public String userID;
    public String postIsim, postIcerik,postKategori;
    //public String likeNumber,dislikeNumber;
    public String postUrunFiyat,postUrunMarka,postUrun,postUrunMiktar;
    public String profilPhotoUrl;
    private Context context;

    public PostModel() {
    }

    public PostModel(String userID, String postIsim, String postIcerik, String postKategori,
                     String  likeNumber, String dislikeNumber, String postUrunFiyat, String postUrunMarka,
                     String postUrun, String postUrunMiktar, String profilPhotoUrl, Context context) {

        this.userID = userID;
        this.postIsim = postIsim;
        this.postIcerik = postIcerik;
        this.postKategori = postKategori;
      //  this.likeNumber = likeNumber;
     //   this.dislikeNumber = dislikeNumber;
        this.postUrunFiyat = postUrunFiyat;
        this.postUrunMarka = postUrunMarka;
     //   this.postUrun = postUrun;
     //   this.postUrunMiktar = postUrunMiktar;
      //  this.profilPhotoUrl = profilPhotoUrl;
        this.context = context;
    }
}
