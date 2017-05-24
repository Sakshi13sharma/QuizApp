package com.example.sakshiquiz.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FrontActivity extends AppCompatActivity {
    EditText ed1;
    Button bt1,bt2,bt3;
    SharedPreferences shrd;
    SharedPreferences.Editor edt;
    public static final String Name = "nameKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        shrd=getSharedPreferences("com.example.sakshiquiz.quiz",MODE_PRIVATE);
        ed1=(EditText) findViewById(R.id.ed1);
        bt1=(Button) findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt3=(Button) findViewById(R.id.btdel);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=ed1.getText().toString();
                edt=shrd.edit();
                edt.putString("name",text);
                edt.commit();
                Toast.makeText(FrontActivity.this,"Welcome"  +"  "+text,Toast.LENGTH_SHORT).show();
                Intent in= new Intent(FrontActivity.this,MainActivity.class);
                startActivity(in);

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FrontActivity.this,"Welcome"  +"  ",Toast.LENGTH_SHORT).show();
                Intent in= new Intent(FrontActivity.this,AddActivity.class);
                startActivity(in);

            }
        });bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FrontActivity.this,"Welcome"  +"  ",Toast.LENGTH_SHORT).show();
                Intent in= new Intent(FrontActivity.this,DeleteActivity.class);
                startActivity(in);

            }
        });
    }
}
