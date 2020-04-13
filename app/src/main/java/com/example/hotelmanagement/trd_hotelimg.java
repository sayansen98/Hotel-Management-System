package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class trd_hotelimg extends AppCompatActivity {
    private TextView nm,rt,ds;
    private ImageView img1;
    private EditText ed2;
    private Button btn0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trd_hotelimg);
        TextView nm=(TextView)findViewById(R.id.tt1);
        TextView rt=(TextView)findViewById(R.id.tt2);
        TextView ds=(TextView)findViewById(R.id.tt3);
        ImageView img1=(ImageView)findViewById(R.id.image3);
        final EditText ed2=(EditText) findViewById(R.id.numperson);
        Button btn0=(Button)findViewById(R.id.btn9);

        final Intent intent=getIntent();
        final String name=intent.getExtras().getString("name");

        final float rate=intent.getExtras().getFloat("rate");
        final String description=intent.getExtras().getString("description");
        final int image=intent.getExtras().getInt("thumbnile");
        final String email=intent.getExtras().getString("email");
        nm.setText(name);
        rt.setText(Float.toString(rate));
        ds.setText(description);
        img1.setImageResource(image);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nper=ed2.getText().toString().trim();
                float price=Integer.parseInt(nper)*rate;
                Intent intent=new Intent(trd_hotelimg.this,finalActivity1.class);
                intent.putExtra("name",name);
                intent.putExtra("thumbnile",image);
                intent.putExtra("description",description);
                intent.putExtra("quantity",nper);
                intent.putExtra("amount",price);
                intent.putExtra("email",email);
                startActivity(intent);

            }
        });
    }

    }


