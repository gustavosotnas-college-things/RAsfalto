package com.rasfalto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Map;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText emailinsert;
    private EditText passwordinsert;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener listener;

    private String mEmail, mPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        inicializa();

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

    public void inicializa() {

        emailinsert = (EditText) findViewById(R.id.emailcadastro);
        passwordinsert = (EditText) findViewById(R.id.senhacadastro);
    }

    public void RealizarCadastro(View view) {

        mEmail = emailinsert.getText().toString();
        mPass = passwordinsert.getText().toString();

        Create(mEmail, mPass);
    }

    public void Create(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("sucesso", "createUserWithEmail:onComplete:" + task.isSuccessful());

                if (!task.isSuccessful()){
                    Toast.makeText(CreateAccountActivity.this, "Autenticação Falhou", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
