package com.example.churchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    //You are working on the Forgot Password page. And Main activity. Then work on firebase

    @Override
    public void onBackPressed() {
        // empty so nothing happens
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button logoutBtn = (Button) findViewById(R.id.logout);

        //Try method removes the top bar from activity
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

    logoutBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             FirebaseAuth.getInstance().signOut();
             Intent login_intent = new Intent(MainActivity.this, LoginActivity.class);
             startActivity(login_intent );
         }
     });
    }




}