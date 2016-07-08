package com.rasfalto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText emailinsert;
    private EditText passwordinsert;

    private Firebase firebase;

    private String mEmail, mPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        firebase = new Firebase("https://Rasfalto.firebaseio.com");

        inicializa();
    }

    public void inicializa(){

        emailinsert = (EditText) findViewById(R.id.emailcadastro);
        passwordinsert = (EditText) findViewById(R.id.senhacadastro);
    }

    public void RealizarCadastro(View view) {

        mEmail = emailinsert.getText().toString();
        mPass = passwordinsert.getText().toString();

        Create(mEmail, mPass);
    }

    private void Create(String email, String password) {

        firebase.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                Log.i("validacao", "onSuccess: Autenticação realizada com sucesso");
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Log.e("validacao", "onError: Autenticação falhou");
            }
        });


    }

}
