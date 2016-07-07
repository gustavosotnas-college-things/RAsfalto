package com.rasfalto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Map;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText emailinsert;
    private EditText passwordinsert;

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        Firebase.setAndroidContext(this);

        mAuth = FirebaseAuth.getInstance();
    }

    public void RealizarCadastro(View view) {

        setEmailinsert((EditText) findViewById(R.id.emailcadastro));
        setPasswordinsert((EditText) findViewById(R.id.senhacadastro));

        System.out.println(getEmailinsert());
        System.out.println(getPasswordinsert());

        String email = getEmailinsert().getText().toString();
        String password = getPasswordinsert().getText().toString();

        Create(email, password);
    }

    private void Create(String email, String password) {

        Firebase ref = new Firebase("https://Rasfalto.firebaseio.com");
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("login","Autenticação realizada com sucesso");

                if(!task.isSuccessful()){
                    Log.w("login", "onComplete: ", task.getException());
                }
            }
        });
    }

    public EditText getEmailinsert() {
        return emailinsert;
    }

    public void setEmailinsert(EditText emailinsert) {
        this.emailinsert = emailinsert;
    }

    public EditText getPasswordinsert() {
        return passwordinsert;
    }

    public void setPasswordinsert(EditText passwordinsert) {
        this.passwordinsert = passwordinsert;
    }
}
