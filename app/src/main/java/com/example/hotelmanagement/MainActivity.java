package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password1;
    Button signin,signup;
    databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new databasehelper(this);
        final EditText email = findViewById(R.id.editText1);
        final EditText password1 = findViewById(R.id.editText2);
        Button signin = findViewById(R.id.btn);
        Button signup = findViewById(R.id.btn2);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, signup2.class);
                startActivity(registerIntent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString().trim();
                String pass1 = password1.getText().toString().trim();
                boolean res = db.chkuser(email1, pass1);
                if (res == true) {
                    Toast.makeText(MainActivity.this, "successfully logedin", Toast.LENGTH_SHORT).show();
                    Intent hotelimg=new Intent(MainActivity.this,hotelsayan2.class);
                    hotelimg.putExtra("email",email1);
                     startActivity(hotelimg);
                }
                else

                {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();


                }
                }



        });

    }}

