package com.example.churchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

    TextView logInView = (TextView) findViewById(R.id.forgotPassLogInText);
        logInView.setOnClickListener(new View.OnClickListener() {
        public void onClick (View v){
            switchLogin();
        }
        });
    }

    private void switchLogin(){
        Intent switchActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(switchActivityIntent);
    }
}