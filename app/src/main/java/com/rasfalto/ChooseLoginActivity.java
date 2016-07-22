package com.rasfalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.client.core.Tag;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class ChooseLoginActivity extends AppCompatActivity {

    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private static final int RC_SIGN_IN = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_login);

        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        /*mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, (GoogleApiClient.OnConnectionFailedListener) this )
                .addApi(Auth.GOOGLE_SIGN_IN_API, options)
                .build();

        setAuth(FirebaseAuth.getInstance());

        authListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {

                    Log.d("autenticacao", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    Log.d("autenticacao", "onAuthStateChanged:signed_out");
                }
            }
        };*/
    }

    public void onClick$newAccount(View view) {

        Intent criarConta = new Intent(this, CreateAccountActivity.class);
        startActivity(criarConta);
    }

   /* @Override
    public void onStart() {
        super.onStart();
        getAuth().addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(authListener != null){
            getAuth().removeAuthStateListener(authListener);
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("autenticacao", "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        getAuth().signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("autenticacao", "signInWithCredential:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {

                            Log.w("autenticacao", "signInWithCredential", task.getException());
                            Toast.makeText(ChooseLoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut(){
        FirebaseAuth.getInstance().signOut();
    }

    public void setAuth(FirebaseAuth auth) {
        this.auth = auth;
    }

    public FirebaseAuth getAuth(){
        return auth;
    }*/
}
