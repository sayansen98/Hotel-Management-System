package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class finalActivity1 extends AppCompatActivity {

    ImageView imageView;
    Button btn11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final1);
        setContentView(R.layout.activity_final1);
        TextView tx1=(TextView)findViewById(R.id.textView1);
        ImageView imageView=(ImageView)findViewById(R.id.img46);
        TextView tx3=(TextView)findViewById(R.id.textView2);
        TextView tx4=(TextView)findViewById(R.id.textView3);
        TextView tx5=(TextView)findViewById(R.id.textView4);
         Button btn11=(Button)findViewById(R.id.btn8);
        Intent lt=getIntent();
        final String em=lt.getExtras().getString("email");
         btn11.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent f = new Intent(finalActivity1.this,hotelsayan2.class);
                 f.putExtra("email",em);
                 startActivity(f);
             }
         });
        final Intent i =getIntent();
        String email=i.getExtras().getString("email");
        String name=i.getExtras().getString("name");
        String deac=i.getExtras().getString("description");
        String quan=i.getExtras().getString("quantity");
        String amt=Float.toString(i.getExtras().getFloat("amount"));
        tx1.setText("Name: "+name);
        imageView.setImageResource(i.getExtras().getInt("thumbnile"));
        tx3.setText("Desc: "+deac);
        tx4.setText("qty:"+quan);
        tx5.setText("amount:"+amt);
        databasehelper dt=new databasehelper(this);
        dt.addhotel(email,name,quan,amt);

    }

}
