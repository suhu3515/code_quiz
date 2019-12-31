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

public class Ques1Activity extends AppCompatActivity {

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

                        Ques1Activity.this.finish();
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
        setContentView(R.layout.activity_ques1);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        tv_name = findViewById(R.id.top_name);
        tv_score = findViewById(R.id.top_score);
        btn_a = findViewById(R.id.btn_q1a);
        btn_b = findViewById(R.id.btn_q1b);
        btn_c = findViewById(R.id.btn_q1c);
        btn_nxt = findViewById(R.id.btn_q2);


        name = sharedPreferences.getString("UserName",null);
        score = sharedPreferences.getInt("score",0);

        tv_name.setText(name);
        t_score = String.valueOf(score);
        tv_score.setText(t_score);

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_a.setBackgroundColor(getResources().getColor(R.color.green));
                btn_b.setBackgroundColor(getResources().getColor(R.color.red));
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

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_a.setBackgroundColor(getResources().getColor(R.color.green));
                btn_b.setBackgroundColor(getResources().getColor(R.color.red));
                btn_c.setBackgroundColor(getResources().getColor(R.color.red));

                t_score = String.valueOf(score);

                tv_name.setText(name);
                tv_score.setText(t_score);

            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_a.setBackgroundColor(getResources().getColor(R.color.green));
                btn_b.setBackgroundColor(getResources().getColor(R.color.red));
                btn_c.setBackgroundColor(getResources().getColor(R.color.red));

                t_score = String.valueOf(score);

                tv_name.setText(name);
                tv_score.setText(t_score);

            }
        });

        btn_nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next_quesIntent = new Intent(Ques1Activity.this,Ques2Activity.class);
                startActivity(next_quesIntent);

            }
        });




    }
}
