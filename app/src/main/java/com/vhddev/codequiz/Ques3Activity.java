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

public class Ques3Activity extends AppCompatActivity {

    String name,t_score;
    int score;
    TextView tv_name,tv_score;
    Button btn_nxt,btn_a,btn_b,btn_c;

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
        setContentView(R.layout.activity_ques3);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        tv_name = findViewById(R.id.top_name_q3);
        tv_score = findViewById(R.id.top_score_q3);
        btn_nxt = findViewById(R.id.btn_q4);
        btn_a = findViewById(R.id.btn_q3a);
        btn_b = findViewById(R.id.btn_q3b);
        btn_c = findViewById(R.id.btn_q3c);

        name = sharedPreferences.getString("UserName",null);
        score = sharedPreferences.getInt("score",0);

        tv_name.setText(name);
        t_score = String.valueOf(score);
        tv_score.setText(t_score);

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_b.setBackgroundColor(getResources().getColor(R.color.green));
                btn_a.setBackgroundColor(getResources().getColor(R.color.red));
                btn_c.setBackgroundColor(getResources().getColor(R.color.red));
                btn_a.setEnabled(false);
                btn_b.setEnabled(false);
                btn_c.setEnabled(false);

                t_score = String.valueOf(score);

                tv_name.setText(name);
                tv_score.setText(t_score);

            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_b.setBackgroundColor(getResources().getColor(R.color.green));
                btn_a.setBackgroundColor(getResources().getColor(R.color.red));
                btn_c.setBackgroundColor(getResources().getColor(R.color.red));
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

                btn_b.setBackgroundColor(getResources().getColor(R.color.green));
                btn_a.setBackgroundColor(getResources().getColor(R.color.red));
                btn_c.setBackgroundColor(getResources().getColor(R.color.red));
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

        btn_nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextques_intent = new Intent(Ques3Activity.this,Ques4Activity.class);
                startActivity(nextques_intent);

            }
        });
    }
}
