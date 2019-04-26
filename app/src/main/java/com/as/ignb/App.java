package com.as.ignb;

import android.annotation.SuppressLint;
import android.content.Context;

import com.as.ignb.the_library.application.baseapp;

import okhttp3.OkHttpClient;


/**
 * -----------------------------
 * Created by zqf on 2018/12/26.
 * ---------------------------
 */
@SuppressLint("Registered")
public class App extends baseapp {


    public static final String SPNAME = "spname";
    private static App sInstance;

    public static App getInstance() {
        return sInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void initThirdParty() {
        sInstance = this;



    }
}
