package com.complaint.kimyonsal.cheapernew.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.complaint.kimyonsal.cheapernew.Models.PostModel;
import com.complaint.kimyonsal.cheapernew.Models.UrunlerModel;
import com.complaint.kimyonsal.cheapernew.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimyonsal on 26.04.2017.
 */

public class OneriGonder extends Fragment {


    private EditText edt_icerik,edt_baslik, edt_urunmagaza,edt_urunfiyat;


    ArrayList<String> spinnerArray = new ArrayList<String>();
    private Spinner secenekler;
    private String secilen;

    private View vi;



    private Button kombinle;


    private String _urunAdet,_urunMiktar,_urunFiyat,_urunMarka,_urunBaslik,_urunIcerik,_urunKategori;
    private  DatabaseReference mDatabaseReference;


    public List<UrunlerModel> urunlerModelList = new ArrayList<UrunlerModel>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vi = inflater.inflate(R.layout.fragment_gonder, container, false);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();




        edt_icerik= (EditText) vi.findViewById(R.id.edtOneriIcerik);
        edt_baslik = (EditText) vi.findViewById(R.id.edtOneriBaslik);



        edt_urunfiyat= (EditText) vi.findViewById(R.id.urunFiyat);
        edt_urunmagaza= (EditText) vi.findViewById(R.id.etMagaza);


        kombinle= (Button) vi.findViewById(R.id.btnKombinle);





        spinnerArray.add("Teknoloji");
        spinnerArray.add("Giyim");
        spinnerArray.add("Yeme-Icme");
        spinnerArray.add("Mobile Paket");

        secenekler = (Spinner) vi.findViewById(R.id.spinner);
        ArrayAdapter spinnerAdapter = new ArrayAdapter(vi.getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        secenekler.setAdapter(spinnerAdapter);

        secenekler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                secilen= (String) parent.getItemAtPosition(position);
                Toast.makeText(getView().getContext(), secilen, Toast.LENGTH_SHORT).show();
                edt_baslik.setText("");
                edt_icerik.setText("");
                edt_urunmagaza.setText("");
                edt_urunfiyat.setText("");


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







        kombinle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getView().getContext(),secilen,Toast.LENGTH_LONG).show();


                _urunIcerik = edt_icerik.getText().toString();
                _urunBaslik = edt_baslik.getText().toString();
                _urunFiyat=edt_urunfiyat.getText().toString();
                _urunMarka=edt_urunmagaza.getText().toString();





                PostModel mpostModel = new PostModel();
                mpostModel.postKategori=secilen;
                mpostModel.postUrunFiyat=_urunFiyat;
                mpostModel.postIcerik =_urunIcerik;
                mpostModel.postIsim =_urunBaslik;
                mpostModel.postUrunMarka=_urunMarka; //magaza





                mpostModel.userID= FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
                Toast.makeText(getView().getContext(),mpostModel.userID,Toast.LENGTH_LONG).show();



                mDatabaseReference.child("posts").push().setValue(mpostModel);



            }
        });




        return vi;
    }





}
