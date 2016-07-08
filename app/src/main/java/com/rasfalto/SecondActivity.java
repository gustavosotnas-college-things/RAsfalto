package com.rasfalto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imagem = (ImageView) findViewById(R.id.image);
        String url = "http://i.imgur.com/DvpvklR.png";
        Picasso.with(this).load(url).into(imagem);
    }

    @Override
    public boolean onOptionsItemSelected(Marker marker) {
        finish();

        //intent
    }
}
