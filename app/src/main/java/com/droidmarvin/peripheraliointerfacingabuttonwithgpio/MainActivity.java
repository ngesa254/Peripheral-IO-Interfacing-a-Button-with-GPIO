package com.droidmarvin.peripheraliointerfacingabuttonwithgpio;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.things.pio.PeripheralManagerService;

import sun.rmi.runtime.Log;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PeripheralManagerService service = new PeripheralManagerService();
        Log.d (TAG, "Available GPIO: " + service.getGpioList());

    }
}
