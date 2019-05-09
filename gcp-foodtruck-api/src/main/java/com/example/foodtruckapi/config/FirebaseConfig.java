package com.example.foodtruckapi.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    public Firestore initializeFireBase() throws Exception {

        /*
        *
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirestoreOptions options = new FirestoreOptions.newBuilder()
                .setCredentials(credentials)
                .setProjectId("")
                .build();
        FirebaseApp.initializeApp(options);
        *
        */

        InputStream serviceAccount = new FileInputStream("home/lucas.cardoso/Downloads/foodtruck-db-firebase-adminsdk-du2il-8290b4e6f8.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);

        return FirestoreClient.getFirestore();
    }
}
