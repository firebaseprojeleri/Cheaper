package com.complaint.kimyonsal.cheapernew.Activitiler;





import android.content.Intent;
import android.os.Bundle;


 import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.complaint.kimyonsal.cheapernew.Authentication.LoginActivity;
import com.complaint.kimyonsal.cheapernew.Fragments.GiyimKusam;
import com.complaint.kimyonsal.cheapernew.Fragments.MobilePaket;
import com.complaint.kimyonsal.cheapernew.Fragments.HomeFragment;
import com.complaint.kimyonsal.cheapernew.Fragments.Teknoloji;
import com.complaint.kimyonsal.cheapernew.Fragments.YemeIcme;
import com.complaint.kimyonsal.cheapernew.BaseAdapter.DrawerListAdapter;
import com.complaint.kimyonsal.cheapernew.Models.NavItem;

import com.complaint.kimyonsal.cheapernew.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity   {

    private static String TAG = MainActivity.class.getSimpleName();
    RelativeLayout mDrawerPane;
    ListView mDrawerList;
    private ActionBarDrawerToggle mdraDrawerToggle;
    private DrawerLayout mdraDrawerLayout;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        mNavItems.add(new NavItem("Home","Meet Up destination",R.drawable.ic_home_main));
        mNavItems.add(new NavItem("Teknoloji","Teknoloji ürünleri",R.drawable.ic_television));
        mNavItems.add(new NavItem("Giyim","Giyim Kuşam Ürümleri",R.drawable.ic_women_dress));
        mNavItems.add(new NavItem("Yeme İçne","Karnınızı doyurabileceğiniz mekanlar",R.drawable.ic_yeme_icme));
        mNavItems.add(new NavItem("Mobile Paket","Aradığınız mobile paketler",R.drawable.ic_mobile));

        mNavItems.add(new NavItem("Konaklama","Bu gün nerde kalabilirsiniz",R.drawable.ic_konaklama));
        mNavItems.add(new NavItem("Çıkış","Yine Bekleriz", R.drawable.ic_exit_to_app));


        //DrawerLayout
        mdraDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //Populate the navigation Drawer with options
        mDrawerPane= (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList= (ListView) findViewById(R.id.navList);
        DrawerListAdapter adapter = new DrawerListAdapter(this,mNavItems);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment= new HomeFragment();

        ft.replace(R.id.mainContent,
                fragment).commit();




    }

    private void selectItemFromDrawer(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        if (position==0) {

            Fragment fragment = new HomeFragment();
            ft = fm.beginTransaction().addToBackStack("Home");
            ft.replace(R.id.mainContent, fragment);
            ft.commit();
            setTitle(mNavItems.get(position).mTitle);
        }else if(position==1){
            Fragment fragment = new Teknoloji();

            ft = fm.beginTransaction().addToBackStack("Teknoloji");
            ft.replace(R.id.mainContent, fragment);
            ft.commit();

            setTitle(mNavItems.get(position).mTitle);

        }else if (position==2){
            Fragment fragment = new GiyimKusam();

            ft = fm.beginTransaction().addToBackStack("Giyim");
            ft.replace(R.id.mainContent, fragment);
            ft.commit();
            setTitle(mNavItems.get(position).mTitle);

        }else if(position==3){
            Fragment fragment = new YemeIcme();

            ft = fm.beginTransaction().addToBackStack("Yemek");
            ft.replace(R.id.mainContent, fragment);
            ft.commit();
            setTitle(mNavItems.get(position).mTitle);
        }else  if(position==4){
            Fragment fragment = new MobilePaket();

            ft = fm.beginTransaction().addToBackStack("MobilePaket");
            ft.replace(R.id.mainContent, fragment);
            ft.commit();
            setTitle(mNavItems.get(position).mTitle);
        }else if(position==5){

        } else if(position==6){
            mAuth = FirebaseAuth.getInstance();
            mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.classm));


            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        }









        //Cloe the drawer

        mdraDrawerLayout.closeDrawer(mDrawerPane);



    }

}
