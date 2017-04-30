package com.complaint.kimyonsal.cheapernew.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.complaint.kimyonsal.cheapernew.Activitiler.Detaylar;
import com.complaint.kimyonsal.cheapernew.BaseAdapter.CustomLayoutAdapter;
import com.complaint.kimyonsal.cheapernew.Models.PostModel;
import com.complaint.kimyonsal.cheapernew.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kimyonsal on 26.04.2017.
 */

public class Konaklama extends Fragment{
    private ListView lv;
    private CustomLayoutAdapter adapter;
    private List<PostModel> dataPost;
    private PostModel model;

    public Konaklama() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_konaklama, container, false);
        lv = (ListView) vi.findViewById(R.id.listKonaklama);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                String icerik = dataPost.get(position).postIcerik;
                String baslik = dataPost.get(position).postIsim;
                String fiyat = dataPost.get(position).postUrunFiyat;
                String magaza = dataPost.get(position).postUrunMarka;

                bundle.putString("icerik", icerik);
                bundle.putString("baslik", baslik);
                bundle.putString("fiyat", fiyat);
                bundle.putString("magaza", magaza);
                Intent i = new Intent(getActivity(), Detaylar.class);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        //  MainActivity.fab.show();

        getData();

        adapter = new CustomLayoutAdapter((Activity) vi.getContext(), dataPost);

        lv.setAdapter(adapter);
        return vi;
    }

    public void getData() {
        dataPost = new ArrayList<>();

        DatabaseReference mRefTekno = FirebaseDatabase.getInstance().getReference().child("posts");
        Query query = mRefTekno.orderByChild("postKategori").equalTo("Konaklama");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapTekno : dataSnapshot.getChildren()) {
                    model = new PostModel();
                    model.postIsim = dataSnapTekno.child("postIsim").getValue().toString();
                    model.postIcerik = dataSnapTekno.child("postIcerik").getValue().toString();
                    model.postUrunMarka = dataSnapTekno.child("postUrunMarka").getValue().toString();
                    model.postUrunFiyat = dataSnapTekno.child("postUrunFiyat").getValue().toString();


                    dataPost.add(model);

                    Collections.reverse(dataPost);

                }

                adapter = new CustomLayoutAdapter((Activity) getActivity(), dataPost);


                adapter.notifyDataSetChanged();
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
