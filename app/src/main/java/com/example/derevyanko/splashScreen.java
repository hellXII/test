package com.example.derevyanko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class splashScreen extends Activity {
    private final int SPLASH_DISPLAY_LENGHT = 5000;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashScreen. this, MainActivity.class);
                splashScreen.this.startActivity(intent);
                splashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
