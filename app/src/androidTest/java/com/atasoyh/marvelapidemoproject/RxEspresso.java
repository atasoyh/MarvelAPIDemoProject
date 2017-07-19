package com.atasoyh.marvelapidemoproject;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.idling.CountingIdlingResource;

public final class RxEspresso {
    public static final String TAG = "RxEspresso";
    private static RxEspresso INSTANCE;

    private CountingIdlingResource countingIdlingResource;

    public static void increment() {
        get().countingIdlingResource.increment();
    }

    public static void decrement() {
        get().countingIdlingResource.decrement();
    }

    public static boolean isIdleNow() {
        return get().countingIdlingResource.isIdleNow();
    }

    private RxEspresso() {

        boolean debug = false;

        countingIdlingResource = new CountingIdlingResource(TAG, debug);
        Espresso.registerIdlingResources(countingIdlingResource);
    }

    private static RxEspresso get() {
        if (INSTANCE == null) {
            INSTANCE = new RxEspresso();
        }
        return INSTANCE;
    }

}