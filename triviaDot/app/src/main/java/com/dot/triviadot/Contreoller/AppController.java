package com.dot.triviadot.Contreoller;

import android.app.Application;
import android.nfc.Tag;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {
    public final String TAG = AppController.class.getSimpleName();
    private static AppController myInstance;
    private RequestQueue myRequestQueue;
    public static synchronized AppController getInstance()
    {
        return myInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myInstance = this;
    }
    public RequestQueue getMyRequestQueue()
    {
        if(myRequestQueue==null)
        {
            myRequestQueue = Volley.newRequestQueue(getApplicationContext());

        }
        return myRequestQueue;
    }
    public <T> void addToQueue(Request<T> req)
    {
        req.setTag(TAG);
        getMyRequestQueue().add(req);
    }

    public <T> void addToQueue(Request<T> req,String tag)
    {
        req.setTag(TextUtils.isEmpty(tag)? TAG: tag);
        getMyRequestQueue().add(req);
    }
    public void cancelPendingRequest(Object tag)
    {
        if(myRequestQueue!=null)
        {
            myRequestQueue.cancelAll(tag);
        }
    }

}
