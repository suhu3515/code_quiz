package com.vhddev.codequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int splash_time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        if(sharedPreferences.getString("UserName",null)==null)
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent logIntent;
                    logIntent= new Intent(MainActivity.this,loginActivity.class);
                    startActivity(logIntent);
                }
            },splash_time);
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent insIntent = new Intent(MainActivity.this,InstructionActivity.class);
                    startActivity(insIntent);
                }
            },splash_time);
        }

    }
}
