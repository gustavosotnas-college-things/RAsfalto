package com.rasfalto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText emailinsert;
    private EditText passwordinsert;

    Firebase ref = new Firebase("https://rasfalto-d70cd.firebaseio.com/");

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        emailinsert = (EditText) findViewById(R.id.emailcadastro);
        passwordinsert = (EditText) findViewById(R.id.senhacadastro);

        Firebase.setAndroidContext(this);
    }

    public void RealizarCadastro(View view){

        String email = emailinsert.getText().toString();
        String password = passwordinsert.getText().toString();

        Create(email,password);
    }

    private void Create(String email, String password){

        ref.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>(){

            @Override
            public void onSuccess(Map<String, Object> result) {
                System.out.println("Conta criada com Sucesso");
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                System.out.println("Erro ao criar a conta");
            }
        });
    }
}
