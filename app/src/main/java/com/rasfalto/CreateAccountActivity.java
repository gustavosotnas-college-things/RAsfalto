package com.rasfalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rasfalto.service.AccountService;

public class CreateAccountActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener listener;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etEmail = (EditText) findViewById(R.id.email_cadastro);
        etPassword = (EditText) findViewById(R.id.senha_cadastro);

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

        String mEmail = etEmail.getText().toString();
        String mPass = etPassword.getText().toString();

        AccountService.createAccount(mEmail,mPass,mAuth,this);
    }

    /**
     * Função executada quando o usuário cria uma conta com sucesso.
     */
    public static void onAccountSuccess(CreateAccountActivity activity) {

        Intent backToStartActivity = new Intent(activity, StartActivity.class);
        activity.startActivity(backToStartActivity);
        activity.finish();
    }

}
