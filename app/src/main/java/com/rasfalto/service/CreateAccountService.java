package com.rasfalto.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rasfalto.CreateAccountActivity;

public final class CreateAccountService {

    private static boolean result;

    public static boolean createAccount(String email, String password, FirebaseAuth mAuth, final CreateAccountActivity targetActivity) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(targetActivity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("sucesso", "createUserWithEmail:onComplete:" + task.isSuccessful());

                result = task.isSuccessful(); // retorna true se a conta foi criada com sucesso, false caso contrário.
            }
        });
        return result;
    }
}
