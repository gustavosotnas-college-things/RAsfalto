package com.rasfalto.service;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rasfalto.CreateAccountActivity;
import com.rasfalto.LoginActivity;
import com.rasfalto.R;
import com.rasfalto.RAsfaltoActivity;
import com.rasfalto.StartActivity;

/**
 * Created by Renan O on 25/07/2016.
 */
public class LoginService {

    public static void loginAccount(String email, String password, FirebaseAuth mAuth, final LoginActivity activity) {

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("sucesso", "createUserWithEmail:onComplete:" + task.isSuccessful());

                if (task.isSuccessful()) {

                    Toast.makeText(activity, R.string.account_login_success, Toast.LENGTH_SHORT).show();
                    Intent entrar = new Intent(activity,RAsfaltoActivity.class);
                    activity.startActivity(entrar);

                } else {
                    Toast.makeText(activity, R.string.account_login_failure, Toast.LENGTH_SHORT).show();
                    Intent retorna = new Intent(activity, StartActivity.class);
                    activity.startActivity(retorna);
                }
            }
        });

    }

}
