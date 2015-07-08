package com.example.ulabsrg.prototype.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public class MainThreadImpl implements MainThread {

    private Handler handler;

    MainThreadImpl() { this.handler = new Handler(Looper.getMainLooper()); }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
