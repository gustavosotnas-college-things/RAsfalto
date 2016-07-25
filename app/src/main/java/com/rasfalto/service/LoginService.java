package com.rasfalto.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.rasfalto.controller.AccountController;

/**
 * Created by Renan O on 25/07/2016.
 */
public class LoginService implements OnCompleteListener<AuthResult> {

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        Log.d("sucesso", "signInWithEmail:onComplete:" + task.isSuccessful());

        AccountController.setResultLogin(task.isSuccessful());
    }
}
