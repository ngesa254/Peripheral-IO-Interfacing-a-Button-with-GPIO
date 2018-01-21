package com.droidmarvin.peripheraliointerfacingabuttonwithgpio;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManagerService;

import java.io.IOException;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private static final String GREEN_LED_PIN = "BCM19";

    private Gpio mButtonGio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PeripheralManagerService service = new PeripheralManagerService();
        //Log.d (TAG, "Available GPIO: " + service.getGpioList());

        try {
            //Create Button GPIO connection
            mButtonGio = service.openGpio(GREEN_LED_PIN);
            // Configure Button as an input && Enable edge trigger events
            mButtonGio.setDirection(Gpio.DIRECTION_IN);
            mButtonGio.setEdgeTriggerType(Gpio.ACTIVE_LOW);
        }catch (IOException e){
            throw new IllegalStateException(mButtonGio +"error opening the button",e);
        }

    }

    //Close Button GPIO connection.
    @Override
    protected void onDestroy() {
        try {
            mButtonGio.close();
        }catch (IOException e){
            throw new IllegalStateException (mButtonGio+"error closing the bus", e);
        }
        super.onDestroy();
    }
}
