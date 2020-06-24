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

public class Ques3Activity extends AppCompatActivity implements Answers{

    String t_score;
    int score;
    TextView tv_score;
    Button btn_nxt,btn_a,btn_b,btn_c;

    @Override
    public void onBackPressed() {

        exit_prompt();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques3);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        tv_score = findViewById(R.id.top_score_q3);
        btn_nxt = findViewById(R.id.btn_q4);
        btn_a = findViewById(R.id.btn_q3a);
        btn_b = findViewById(R.id.btn_q3b);
        btn_c = findViewById(R.id.btn_q3c);

        score = sharedPreferences.getInt("score",0);

        t_score = String.valueOf(score);
        tv_score.setText(t_score);

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                right_ans(btn_b);
                wrong_ans(btn_a,btn_c);
                buttonDisable(btn_a,btn_b,btn_c);
                show_score();

            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                right_ans(btn_b);
                wrong_ans(btn_a,btn_c);
                buttonDisable(btn_a,btn_b,btn_c);
                show_score();

            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                right_ans(btn_b);
                wrong_ans(btn_a,btn_c);
                buttonDisable(btn_a,btn_b,btn_c);
                increase_score();

            }
        });

        btn_nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                next_question();

            }
        });
    }

    @Override
    public void enableNext() {

        btn_nxt.setEnabled(true);

    }

    @Override
    public void right_ans(Button button)
    {
        button.setBackgroundColor(getResources().getColor(R.color.green));
    }

    @Override
    public void wrong_ans(Button button1, Button button2)
    {
        button1.setBackgroundColor(getResources().getColor(R.color.red));
        button2.setBackgroundColor(getResources().getColor(R.color.red));
    }

    @Override
    public void buttonDisable(Button button1, Button button2, Button button3)
    {
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
    }

    @Override
    public void increase_score()
    {
        score = score + 10;
        t_score = String.valueOf(score);
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score",score);
        editor.apply();

        tv_score.setText(t_score);

    }

    @Override
    public void show_score()
    {
        t_score = String.valueOf(score);
        tv_score.setText(t_score);
    }

    @Override
    public void next_question()
    {
        Intent nextques_intent = new Intent(Ques3Activity.this,Ques4Activity.class);
        startActivity(nextques_intent);
    }

    @Override
    public void exit_prompt()
    {
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
}
