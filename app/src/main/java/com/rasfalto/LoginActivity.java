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

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener listener;
    boolean sucess = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        EditText etEmail = (EditText) findViewById(R.id.emailLogin);
        EditText etPassword = (EditText) findViewById(R.id.passwordLogin);
        String mEmail = etEmail.getText().toString();
        String mPass = etPassword.getText().toString();

        /*AccountController.loginAccount(mEmail,mPass,mAuth,LoginActivity.this);

        if(isLoginValid(mEmail, mPass)){

            boolean success = AccountController.loginAccount(mEmail, mPass, mAuth, LoginActivity.this);

            if (success) {
                Toast.makeText(this, R.string.account_login_success, Toast.LENGTH_SHORT).show();
                Intent loginActivity = new Intent(this, RAsfaltoActivity.class);
                startActivity(loginActivity);
                finish();
            }
            else {
                Toast.makeText(this, R.string.account_login_failure, Toast.LENGTH_SHORT).show();
                //Intent voltaParaTelaInicial = new Intent(this, StartActivity.class);
                //startActivity(voltaParaTelaInicial);
            }

        }
        else {
            Toast.makeText(this, R.string.account_login_empty, Toast.LENGTH_SHORT).show();
        }*/
    }

    private boolean isLoginValid(String email, String password) {
        return ((email != "")||(email != null))||((password != "")||(password != null)||(password.length() < 6));
    }
}
