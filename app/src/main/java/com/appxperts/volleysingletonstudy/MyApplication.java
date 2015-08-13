package com.appxperts.volleysingletonstudy;

import android.app.Application;
import android.content.Context;

/**
 * Created by gufran on 8/13/15.
 */
public class MyApplication extends Application {

    private static MyApplication appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    public static MyApplication getInstance() {
        return appInstance;
    }


    public static Context getAppContext() {
        return appInstance.getApplicationContext();
    }

}
