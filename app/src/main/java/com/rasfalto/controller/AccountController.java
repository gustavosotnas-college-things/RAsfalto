package com.rasfalto.controller;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rasfalto.CreateAccountActivity;
import com.rasfalto.LoginActivity;
import com.rasfalto.service.AccountService;

/**
 * Classe que reúne todas as operações de baixo nível relacionadas à gerência
 * de contas de usuário no RAsfalto.
 *
 * @author gustavosotnas
 * @author RenanOfugi
 */
public final class AccountController {

    private static boolean resultCreate = false;
    private static boolean resultLogin = false;

    public static void setResultCreate(boolean resultCreate) {
        AccountController.resultCreate = resultCreate;
    }

    /**
     * Função que uma nova conta de usuário no RAsfalto, se comunicando com o
     * Firebase para isso.
     *
     * @param email          endereço de email do novo usuário.
     * @param password       a senha do novo usuário.
     * @param mAuth          o objeto de autenticação e manipulação do repositório no Firebase.
     * @param targetActivity a Activity-alvo da operação.
     * @return {@code true} caso a conta tenha sido criada com sucesso,
     * {@code false} caso contrário.
     */
    public static boolean createAccount(String email, String password, FirebaseAuth mAuth, final CreateAccountActivity targetActivity) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(targetActivity, new AccountService());
        return resultCreate;
    }

    public static boolean loginAccount(String email, String password, FirebaseAuth mAuth, final LoginActivity targetActivity) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(targetActivity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Log.d("sucesso", "signInWithEmail:onComplete:" + task.isSuccessful());

                        resultLogin = task.isSuccessful();
                    }
                });

        return resultLogin;
    }
}
