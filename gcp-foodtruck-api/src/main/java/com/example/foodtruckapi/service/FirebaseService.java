package com.example.foodtruckapi.service;

import com.example.foodtruckapi.config.FirebaseConfig;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {

    @Autowired
    FirebaseConfig firebase;

    Firestore db;

    public FirebaseService() throws Exception {
        firebase = new FirebaseConfig();
        this.db = firebase.initializeFireBase();
    }

}
