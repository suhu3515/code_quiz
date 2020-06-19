package com.vhddev.codequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    String name,t_score;
    int score;

    TextView tv_name,tv_score;
    Button btn_b;

    @Override
    public void onBackPressed() {

        saveData();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_name = findViewById(R.id.tv_r_name);
        tv_score = findViewById(R.id.tv_r_score);

        btn_b = findViewById(R.id.btn_back);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        name = sharedPreferences.getString("UserName",null);
        score = sharedPreferences.getInt("score",0);

        tv_name.setText(name);
        t_score = String.valueOf(score);
        tv_score.setText(t_score);

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();

            }
        });


    }

    private void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score",0);
        editor.apply();
        Intent loginIntent = new Intent(resultActivity.this,InstructionActivity.class);
        startActivity(loginIntent);
        finish();
    }

}
