package com.example.user.dvectn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.dvectn.Fragment.Fragment_login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.content,new Fragment_login(),"login").commit();
    }
}
