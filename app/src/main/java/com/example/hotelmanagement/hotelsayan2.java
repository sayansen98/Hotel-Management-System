package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class hotelsayan2 extends AppCompatActivity {
    List<hoteli> hotelr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelsayan2);
        Button bt1=findViewById(R.id.button);

        hotelr =new ArrayList<>();
        hotelr.add(new hoteli(1,"jala_hotel","100","DESCRIPTION",R.drawable.imgrrr));
        hotelr.add(new hoteli(2,"poit_jjol","234","DESCRIPTION",R.drawable.sayan1));
        hotelr.add(new hoteli(3,"jala_hotel","4942","DESCRIPTION",R.drawable.sayan2));
        hotelr.add(new hoteli(4,"jala_hotel","562","DESCRIPTION",R.drawable.sayan3));
        hotelr.add(new hoteli(5,"jala_hotel","772","DESCRIPTION",R.drawable.sayan4));
        hotelr.add(new hoteli(6,"jala_hotel","882","DESCRIPTION",R.drawable.sayan5));
        hotelr.add(new hoteli(7,"jala_hotel","9992","DESCRIPTION",R.drawable.sayan1));
        hotelr.add(new hoteli(8,"jala_hotel","755","DESCRIPTION",R.drawable.sayan5));
        hotelr.add(new hoteli(9,"jala_hotel","1012","DESCRIPTION",R.drawable.sayan4));
        Intent i=getIntent();
        final String em=i.getExtras().getString("email");
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(hotelsayan2.this,userhotelview.class);
                it.putExtra("email",em);
                startActivity(it);
            }
        });
        RecyclerView myrv=(RecyclerView)findViewById(R.id.recyclerview_id);
        recycleviewq myadapter=new recycleviewq(this,hotelr,em);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myadapter);
    }
}

