package com.droidmarvin.peripheraliointerfacingabuttonwithgpio;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.things.pio.PeripheralManagerService;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PeripheralManagerService service = new PeripheralManagerService();
        Log.d (TAG, "Available GPIO: " + service.getGpioList());

    }
}
