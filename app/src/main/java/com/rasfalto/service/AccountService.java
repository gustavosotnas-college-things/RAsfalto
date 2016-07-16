package com.rasfalto.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rasfalto.CreateAccountActivity;

/**
 * Classe que reúne todas as operações de baixo nível relacionadas à gerência
 * de contas de usuário no RAsfalto.
 *
 * @author gustavosotnas
 * @author RenanOfugi
 */
public final class AccountService {

    private static boolean result;

    /**
     * Função que uma nova conta de usuário no RAsfalto, se comunicando com o
     * Firebase para isso.
     *
     * @param email endereço de email do novo usuário.
     * @param password a senha do novo usuário.
     * @param mAuth o objeto de autenticação e manipulação do repositório no Firebase.
     * @param targetActivity a Activity-alvo da operação.
     * @return {@code true} caso a conta tenha sido criada com sucesso,
     *         {@code false} caso contrário.
     */
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
