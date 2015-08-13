package com.appxperts.volleysingletonstudy;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by gufran on 8/13/15.
 */
public class VolleySingleton {

    private static VolleySingleton instance;

    private RequestQueue requestQueue;

    private VolleySingleton() {
    }

    public static VolleySingleton getInstance() {
        if (instance == null) {
            instance = new VolleySingleton();
            instance.requestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }


}
