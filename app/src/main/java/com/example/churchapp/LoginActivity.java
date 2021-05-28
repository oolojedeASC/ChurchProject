package com.example.churchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Authetication
        private FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

        mAuth.signInWithCustomToken(mCustomToken)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCustomToken:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d(TAG, "signInWithCustomToken:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });




        //Try method removes the top bar from activity
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        TextView regView=(TextView) findViewById(R.id.registerView);
        regView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                switchSignUp();
            }
        });



        Button logBut = (Button) findViewById(R.id.loginButton);
        logBut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                switchMain();
            }
        });

        TextView forgotPassView=(TextView) findViewById(R.id.forgotPassView);
        forgotPassView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                switchForgotPass();
            }
        });






    }





    private void switchSignUp(){
        Intent switchActivityIntent = new Intent(this, SignupActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchMain(){
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchForgotPass(){
        Intent switchActivityIntent = new Intent(this, ForgotPassword.class);
        startActivity(switchActivityIntent);
    }

    //Change UI according to user data.
    public void updateUI(FirebaseUser account){

        if(account != null){
            Toast.makeText(this,"U Signed In successfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));

        }else {
            Toast.makeText(this,"U Didnt signed in", Toast.LENGTH_LONG).show();
        }

    }
}