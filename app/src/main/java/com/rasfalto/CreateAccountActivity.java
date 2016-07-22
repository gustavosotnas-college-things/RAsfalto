package com.rasfalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rasfalto.controller.AccountController;

public class CreateAccountActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener listener;
    boolean success = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        mAuth = FirebaseAuth.getInstance();

        listener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    Log.d("autenticacao", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    Log.d("autenticacao", "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(listener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (listener != null) {
            mAuth.removeAuthStateListener(listener);
        }
    }

    public void onClick$signUp(View view) {

        EditText etEmail = (EditText) findViewById(R.id.emailcadastro);
        EditText etPassword = (EditText) findViewById(R.id.senhacadastro);
        String mEmail = etEmail.getText().toString();
        String mPass = etPassword.getText().toString();

        AccountController.createAccount(mEmail, mPass, mAuth, CreateAccountActivity.this);

        if (success) {
            Toast.makeText(this, R.string.toast_new_account_success, Toast.LENGTH_SHORT).show();

            Intent voltarATelaInicial = new Intent(this, StartActivity.class);
            startActivity(voltarATelaInicial);
            finish();
        }
        else {
            Toast.makeText(this, R.string.toast_new_account_failure, Toast.LENGTH_SHORT).show();
        }
    }
}
