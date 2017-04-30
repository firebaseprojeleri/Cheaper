package com.complaint.kimyonsal.cheapernew.Activitiler;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.complaint.kimyonsal.cheapernew.R;

/**
 * Created by kimyonsal on 30.04.2017.
 */

public class Detaylar  extends AppCompatActivity {

    public String keepTitle, keepContent, keepCost, keepMarka, keepCategory, keepShopName;

    public static final int DEFAULT_MSG_LENGTH_LIMIT = 1000;

    private TextView edtBaslik, edtIcerik, edtUcret, edtMarka;

    private Toolbar toolbar;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle extra = this.getIntent().getExtras();
        edtBaslik = (TextView) findViewById(R.id.detailsTitle);
        edtIcerik = (TextView) findViewById(R.id.detailContent);
        edtUcret = (TextView) findViewById(R.id.detailsCost);
        edtMarka = (TextView) findViewById(R.id.detailsMarka);


        toolbar = (Toolbar) findViewById(R.id.toolbar);


        keepTitle = extra.getString("baslik").toString() + "";
        keepContent = extra.getString("icerik").toString() + "";
        keepCost = extra.get("fiyat").toString();
        keepMarka = extra.get("magaza").toString();


        edtBaslik.setText(keepTitle);
        edtIcerik.setText(keepContent);
        edtUcret.setText(keepCost);
        edtMarka.setText(keepMarka);

    }
}
