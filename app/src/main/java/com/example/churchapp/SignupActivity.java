package com.example.churchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        TextView regView=(TextView) findViewById(R.id.loginView);
        regView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //perform your action  here
                switchAct();
            }
        });
    }

    private void switchAct(){
        Intent switchActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(switchActivityIntent);
    }
}