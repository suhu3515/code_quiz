package com.vhddev.codequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    String name;
    int score,age;
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

        name = et_n.getText().toString();
        //age = Integer.parseInt(et_a.getText().toString());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ins_intent = new Intent(loginActivity.this,InstructionActivity.class);
                ins_intent.putExtra("p_name",name);
                ins_intent.putExtra("p_score",score);
                startActivity(ins_intent);
                }
            });
        }



    }
