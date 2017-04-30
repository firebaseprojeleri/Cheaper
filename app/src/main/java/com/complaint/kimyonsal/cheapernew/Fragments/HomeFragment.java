package com.complaint.kimyonsal.cheapernew.Fragments;

import android.app.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
 * Created by kimyonsal on 24.04.2017.
 */

public class HomeFragment extends Fragment {

    private ListView lv;
    private CustomLayoutAdapter adapter;
    private List<PostModel> dataPost;
    private PostModel model;
    public static FloatingActionButton fab;
    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preferences, container, false);
        lv = (ListView) view.findViewById(R.id.mainMenuList);
        fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               FragmentManager fm = getFragmentManager();
                OneriGonder oneriGonder = new OneriGonder();


                FragmentTransaction ft = fm.beginTransaction().addToBackStack("oneri");
                ft.replace(R.id.container, oneriGonder);
                ft.commit();
                fab.setVisibility(View.GONE);
            }
        });


        getData();

        adapter = new CustomLayoutAdapter((Activity) view.getContext(), dataPost);

        lv.setAdapter(adapter);
        return view;
    }



    public void getData() {
        dataPost = new ArrayList<>();

        DatabaseReference mRefTekno = FirebaseDatabase.getInstance().getReference().child("posts");
        Query query = mRefTekno.orderByChild("postKategori");
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

                adapter = new CustomLayoutAdapter((Activity)getActivity() , dataPost);


                adapter.notifyDataSetChanged();
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}
