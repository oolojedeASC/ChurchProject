package com.example.churchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;



//Need to make sure you cant go back from main activity using the back button on a phone.
public class LoginActivity extends AppCompatActivity {

    private Button logBtn;
    private TextView forgotPassView;
    private TextView regView;
    private EditText emailView;
    private EditText passwordView;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Try method removes the top bar from activity
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        regView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                switchSignUp();
            }
        });

        forgotPassView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                switchForgotPass();
            }
        });

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });


    }

    @Override
    public void onBackPressed() {
    // empty so nothing happens
    }

    private void loginUserAccount() {
        //progressBar.setVisibility(View.VISIBLE);

        String email, password;
        email = emailView.getText().toString();
        password = passwordView.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                            //progressBar.setVisibility(View.GONE);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                            //progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }





    private void switchSignUp(){
        Intent switchActivityIntent = new Intent(this, SignupActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchForgotPass(){
        Intent switchActivityIntent = new Intent(this, ForgotPassword.class);
        startActivity(switchActivityIntent);
    }

    private void initializeUI() {
        logBtn = findViewById(R.id.loginButton);
        forgotPassView = findViewById(R.id.forgotPassView);
        regView = findViewById(R.id.registerView);
        emailView = findViewById(R.id.editTextEmail);
        passwordView = findViewById(R.id.editTextPassword);

        //Add progress bars if you have time
        // progressBar = findViewById(R.id.progressBar);
    }

}