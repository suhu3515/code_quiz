package com.vhddev.codequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ques5Activity extends AppCompatActivity {

    String name,t_score;
    int score;
    TextView tv_name,tv_score;
    Button btn_res,btn_a,btn_b,btn_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques5);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        tv_name = findViewById(R.id.top_name_q5);
        tv_score = findViewById(R.id.top_score_q5);
        btn_res = findViewById(R.id.btn_res);
        btn_a = findViewById(R.id.btn_q5a);
        btn_b = findViewById(R.id.btn_q5b);
        btn_c = findViewById(R.id.btn_q5c);

        name = sharedPreferences.getString("UserName",null);
        score = sharedPreferences.getInt("score",0);

        tv_name.setText(name);
        t_score = String.valueOf(score);
        tv_score.setText(t_score);

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_c.setBackgroundColor(getResources().getColor(R.color.green));
                btn_a.setBackgroundColor(getResources().getColor(R.color.red));
                btn_b.setBackgroundColor(getResources().getColor(R.color.red));
                btn_a.setEnabled(false);
                btn_b.setEnabled(false);
                btn_c.setEnabled(false);

                score = score + 10;
                t_score = String.valueOf(score);

                SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score",score);
                editor.apply();

                tv_name.setText(name);
                tv_score.setText(t_score);
            }
        });

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_c.setBackgroundColor(getResources().getColor(R.color.green));
                btn_a.setBackgroundColor(getResources().getColor(R.color.red));
                btn_b.setBackgroundColor(getResources().getColor(R.color.red));
                btn_a.setEnabled(false);
                btn_b.setEnabled(false);
                btn_c.setEnabled(false);

                t_score = String.valueOf(score);

                tv_name.setText(name);
                tv_score.setText(t_score);

            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_c.setBackgroundColor(getResources().getColor(R.color.green));
                btn_a.setBackgroundColor(getResources().getColor(R.color.red));
                btn_b.setBackgroundColor(getResources().getColor(R.color.red));
                btn_a.setEnabled(false);
                btn_b.setEnabled(false);
                btn_c.setEnabled(false);

                t_score = String.valueOf(score);

                tv_name.setText(name);
                tv_score.setText(t_score);

            }
        });

        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent res_intent = new Intent(Ques5Activity.this,resultActivity.class);
                startActivity(res_intent);

            }
        });
    }
}