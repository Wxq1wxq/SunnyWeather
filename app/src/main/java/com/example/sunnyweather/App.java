package com.example.sunnyweather;

import android.app.Application;

import com.example.sunnyweather.db.DBManger;

import org.xutils.x;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DBManger.initDB(this);

    }
}
