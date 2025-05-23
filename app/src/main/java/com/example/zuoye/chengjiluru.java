package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zuoye.bean.Score;

public class chengjiluru extends AppCompatActivity {
    private EditText name,subject,score;
    private Button chengjiluru;
    private MySQLiteOpenHelper mySQLiteOpenHelper1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengjiluru);
        mySQLiteOpenHelper1 = new MySQLiteOpenHelper(this);
        findviews();
    }

    private void findviews() {
        name = findViewById(R.id.luruxueshengxingming);
        subject = findViewById(R.id.lurukecheng);
        score = findViewById(R.id.luruchengji);
        chengjiluru = findViewById(R.id.lu1);
    }

    public void luruchengji(View view) {
        String s = name.getText().toString();
        String s1 = subject.getText().toString();
        String s2 = score.getText().toString();
        Score score =new Score(s,s1,s2);
        //插入score数据库中
        long l = mySQLiteOpenHelper1.insertDatatoscore(score);
        if (l !=-1){
            Toast.makeText(this,"成绩录入成功！",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"成绩录入失败！",Toast.LENGTH_SHORT).show();
        }
    }
}