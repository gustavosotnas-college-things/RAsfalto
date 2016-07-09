package com.rasfalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClick$Login(View view)
    {
        Intent loginActivity = new Intent(this, LoginActivity.class);
        startActivity(loginActivity);
    }

    public void onClick$CreateAccount(View view){

        Intent cadastroActivity = new Intent(this, ChooseLoginActivity.class);
        startActivity(cadastroActivity);
    }
}
