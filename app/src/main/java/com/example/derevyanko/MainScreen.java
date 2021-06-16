package com.example.derevyanko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
    }

    public void onClick(View view){
        Intent intent = new Intent(MainScreen.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick1(View view){
        Intent intent = new Intent(MainScreen.this, recipes.class);
        startActivity(intent);
    }
}
