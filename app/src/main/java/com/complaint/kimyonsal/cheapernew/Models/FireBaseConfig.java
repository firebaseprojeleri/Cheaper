package com.complaint.kimyonsal.cheapernew.Models;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kimyonsal on 26.04.2017.
 */

public class FireBaseConfig {


    public static FirebaseUser mUser;
    public static FirebaseDatabase mDatabase ;
    public static DatabaseReference mDatabaseReference ;
    public static FirebaseAuth mAuth ;
    public static FirebaseAuth.AuthStateListener mAuthStateListener;

}
