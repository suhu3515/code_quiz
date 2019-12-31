package com.vhddev.codequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InstructionActivity extends AppCompatActivity {

    String name,t_score;
    int score;
    TextView tv_name,tv_score;
    Button btn_play,btn_info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        tv_name = findViewById(R.id.top_name);
        tv_score = findViewById(R.id.top_score);
        btn_play = findViewById(R.id.btn_play);
        btn_info = findViewById(R.id.btn_p_info);

        name = sharedPreferences.getString("UserName",null);
        score = sharedPreferences.getInt("score",0);
        t_score = String.valueOf(score);

        tv_name.setText(name);
        tv_score.setText(t_score);

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
