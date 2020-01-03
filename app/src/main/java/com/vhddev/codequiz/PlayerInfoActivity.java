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

public class PlayerInfoActivity extends AppCompatActivity {

    String name,t_score,age;
    int score;

    TextView tv_name,tv_age,tv_score;
    Button btn_d;

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

        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                name = sharedPreferences.getString("UserName",null);
                score = sharedPreferences.getInt("score",0);
                age = sharedPreferences.getString("age",null);

                Intent loginIntent = new Intent(PlayerInfoActivity.this,loginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

    }
}
