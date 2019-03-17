package com.example.projectfragment;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    private static final String TAG = "ApplicationClass";
    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
        people = new ArrayList<Person>();

        people.add(new Person("Shubham", "8650999992"));
        people.add(new Person("Mayank", "7060155774"));
        people.add(new Person("Rishabh", "8979434040"));



    }
}
