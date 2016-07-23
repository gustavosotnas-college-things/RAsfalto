package com.rasfalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RAsfaltoActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasfalto);
    }

    public void onClick$viewBuraco(View view) {
        Intent verDetalhesBuraco = new Intent(this, BuracoActivity.class);
        startActivity(verDetalhesBuraco);
    }
}
