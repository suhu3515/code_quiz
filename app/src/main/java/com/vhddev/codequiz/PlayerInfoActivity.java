package com.vhddev.codequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PlayerInfoActivity extends AppCompatActivity {

    String name,t_score,age;
    int score;

    TextView tv_name,tv_age,tv_score;
    Button btn_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        tv_name = findViewById(R.id.tv_p_name);
        tv_age = findViewById(R.id.tv_p_age);
        tv_score = findViewById(R.id.tv_p_score);

        btn_d = findViewById(R.id.btn_del);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        name = sharedPreferences.getString("UserName",null);
        score = sharedPreferences.getInt("score",0);
        age = sharedPreferences.getString("age",null);

        tv_name.setText(name);
        t_score = String.valueOf(score);
        tv_score.setText(t_score);
        tv_age.setText(age);

    }
}
