package com.rasfalto.service;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rasfalto.CreateAccountActivity;
import com.rasfalto.R;
import com.rasfalto.RAsfaltoActivity;

public class AccountService {

    public static void createAccount(final String email, String password, FirebaseAuth mAuth, final CreateAccountActivity activity) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("sucesso", "createUserWithEmail:onComplete:" + task.isSuccessful());

                if (task.isSuccessful()) {
                    Toast.makeText(activity, R.string.toast_new_account_success, Toast.LENGTH_SHORT).show();// retorna true se a conta foi criada com sucesso, false caso contrário.
                    Intent entrar = new Intent(activity, RAsfaltoActivity.class);
                    activity.startActivity(entrar);
                } else {
                    Toast.makeText(activity, R.string.toast_new_account_failure, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
