package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class userhotelview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhotelview);
        Button bt1=findViewById(R.id.bt1);
        Button bt5=findViewById(R.id.bt5);
        TextView lv=findViewById(R.id.lv1);
        Intent it=getIntent();
        final String em=it.getExtras().getString("email");
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(userhotelview.this,MainActivity.class);
                startActivity(intent1);
            }
        });


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(userhotelview.this,hotelsayan2.class);
                i.putExtra("email",em);
                startActivity(i);
            }
        });
        databasehelper dt=new databasehelper(this);
        String s=dt.gethotels(em);
        lv.setText(s);


    }
}
