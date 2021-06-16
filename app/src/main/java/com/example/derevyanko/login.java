package com.example.derevyanko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class login extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        String user;
    }

    public void onClick(View View){
        EditText loginUserName = (EditText) findViewById(R.id.loginUserName);
        Intent intent = new Intent(login.this, LoginCode.class);
        intent.putExtra("user", loginUserName.getText().toString());
        startActivity(intent);
    }
}
