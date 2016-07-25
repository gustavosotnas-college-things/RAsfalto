package com.rasfalto;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rasfalto.service.LoginService;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener listener;
    private EditText etEmail;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.emailLogin);
        etPass = (EditText) findViewById(R.id.passwordLogin);

        mAuth = FirebaseAuth.getInstance();

        listener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("autenticacao", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("autenticacao", "onAuthStateChanged:signed_out");
                }
            }
        };

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(listener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (listener != null) {
            mAuth.removeAuthStateListener(listener);
        }
    }

    public void onClick$signIn(View view) {

        String mEmail = etEmail.getText().toString();
        String mPass = etPass.getText().toString();

        LoginService.loginAccount(mEmail, mPass, mAuth, this);
    }


}
