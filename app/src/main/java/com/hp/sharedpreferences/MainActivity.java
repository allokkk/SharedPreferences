package com.hp.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declare java objects for xml widgets
    Button btnsave, btnfetch;
    EditText etname, etmobile, etemail;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //typecast connect xml widgets into java objects
        btnsave = findViewById(R.id.btnsave);
        btnfetch = findViewById(R.id.btnfetch);
        etemail = findViewById(R.id.etemail);
        etmobile = findViewById(R.id.etmobile);
        etname = findViewById(R.id.etname);

        //to create or open the sharepreferences file
        sp=getSharedPreferences("spfile", 0);
        //to edit the sharedpreferences spfile
        ed=sp.edit();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to insert the data in spfile
                ed.putString("namekey", etname.getText().toString());
                ed.putString("emailkey", etemail.getText().toString());
                ed.putString("mobilekey", etmobile.getText().toString());

                ed.commit();
            }
        });

        btnfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to fetch the data from spfile
                String sname=sp.getString("namekey", null);
                String semail=sp.getString("emailkey", null);
                String smobile=sp.getString("mobilekey", null);

                Toast.makeText(MainActivity.this,
                        sname+semail+smobile,
                        Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);


            }
        });


    }
}
