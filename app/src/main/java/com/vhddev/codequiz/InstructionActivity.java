package com.vhddev.codequiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InstructionActivity extends AppCompatActivity {

    Button btn_play,btn_info;


    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure to exit?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);


        btn_play = findViewById(R.id.btn_play);
        btn_info = findViewById(R.id.btn_p_info);

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoIntent = new Intent(InstructionActivity.this,PlayerInfoActivity.class);
                startActivity(infoIntent);
            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quesIntent = new Intent(InstructionActivity.this,Ques1Activity.class);
                startActivity(quesIntent);
            }
        });

    }
}
