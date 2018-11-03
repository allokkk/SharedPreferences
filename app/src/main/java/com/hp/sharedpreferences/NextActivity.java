package com.hp.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    tv=findViewById(R.id.tv);

    //fetch the data from spfile
        SharedPreferences sp=getSharedPreferences("spfile", 0);

        //to show the data
        String name=sp.getString("namekey",null);
        String email=sp.getString("emailkey", null);
        String mobile=sp.getString("mobilekey", null);

        tv.setText(name+"\n"+email+"\n"+mobile);

    }
}
