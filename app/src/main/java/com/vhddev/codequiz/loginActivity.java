package com.vhddev.codequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    String name,age;
    int score;
    EditText et_n,et_a;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_n = findViewById(R.id.et_name);
        et_a = findViewById(R.id.et_age);
        btn = findViewById(R.id.btn_save);
        score=0;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_n.getText().toString();
                age = et_a.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("UserName",name);
                editor.putInt("score",score);
                editor.putString("age",age);
                editor.apply();

                Intent ins_intent = new Intent(loginActivity.this,InstructionActivity.class);
                startActivity(ins_intent);
            }
        });

    }
}
