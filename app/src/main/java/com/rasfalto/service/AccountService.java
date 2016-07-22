package com.rasfalto.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.rasfalto.controller.AccountController;

/**
 * Classe que comunica com o Firebase para criar uma nova conta.
 *
 * @author gustavosotnas
 */
public class AccountService implements OnCompleteListener<AuthResult> {

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        Log.d("sucesso", "createUserWithEmail:onComplete:" + task.isSuccessful());

        AccountController.setResultCreate(task.isSuccessful()); // retorna true se a conta foi criada com sucesso, false caso contrário.
    }
}
