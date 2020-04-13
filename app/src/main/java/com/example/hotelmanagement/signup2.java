package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup2 extends AppCompatActivity {
    EditText pass11,confrmpass,email33;
    databasehelper db;
    Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        db = new databasehelper(this);
        final EditText pass11 = findViewById(R.id.passw);
        final EditText confrmpass = findViewById(R.id.conrf);
        final EditText email33 = findViewById(R.id.em3);
        Button btn5 = findViewById(R.id.btn9);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pasy6 = pass11.getText().toString().trim();
                String confer = confrmpass.getText().toString().trim();
                String mail = email33.getText().toString().trim();
                if (pasy6.equals(confer)) {
                    long val = db.adduser(mail, pasy6);
                    if (val > 0) {
                        Toast.makeText(signup2.this, "passor match", Toast.LENGTH_SHORT).show();

                        Intent logint = new Intent(signup2.this, MainActivity.class);
                        startActivity(logint);
                    } else {
                        Toast.makeText(signup2.this, "registration error", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(signup2.this, "not match", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }}





