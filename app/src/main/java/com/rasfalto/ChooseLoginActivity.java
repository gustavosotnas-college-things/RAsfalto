package com.rasfalto;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChooseLoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_login);
    }

    public void createUserLoginPassword(View view){

        Intent criarConta = new Intent(this, CreateAccountActivity.class);
        startActivity(criarConta);
    }
}
