package com.vhddev.codequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class InstructionActivity extends AppCompatActivity {

    String name,t_score;
    int score;
    TextView tv_name,tv_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        tv_name = findViewById(R.id.top_name);
        tv_score = findViewById(R.id.top_score);

        name = sharedPreferences.getString("UserName",null);
        score = sharedPreferences.getInt("score",0);
        t_score = String.valueOf(score);

        tv_name.setText(name);
        tv_score.setText(t_score);

    }
}
