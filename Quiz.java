package com.example.sakshiquiz.quiz;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by sakshiquiz on 5/11/2017.
 */

public class Quiz extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
