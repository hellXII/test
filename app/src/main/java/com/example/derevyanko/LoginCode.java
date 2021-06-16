package com.example.derevyanko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class LoginCode extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_code);
        String User;
        TextView userName = (TextView) findViewById(R.id.loginCodeUser);


        GridView gridView = (GridView) findViewById(R.id.gvCode);
        gridView.setAdapter(new CodeAdapter(this));

        User=getIntent().getExtras().getString("user");
        userName.setText(User);
    }

    public void onClick(View view){
        Intent intent = new Intent(LoginCode.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick1(View view){
        Intent intent = new Intent(LoginCode.this, MainScreen.class);
        startActivity(intent);
    }
}
