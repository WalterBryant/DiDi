package com.didi.common;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {

    private static volatile MainApplication mApplicationInstance = null;

    public static MainApplication getApp() {
        return mApplicationInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


    @Override
    public void onCreate() {
        mApplicationInstance = this;
        super.onCreate();
    }
}
