package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zuoye.bean.Newssss;

public class xinwenluru extends AppCompatActivity {
    private EditText biaoti,neirong;
    private Button xinwenluru;
    private MySQLiteOpenHelper mySQLiteOpenHelper2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xinwenluru);
        mySQLiteOpenHelper2 = new MySQLiteOpenHelper(this);
        findViews();
    }

    private void findViews() {
        biaoti = findViewById(R.id.lurubiaoti);
        neirong = findViewById(R.id.luruneirong);
        xinwenluru = findViewById(R.id.lu2);
    }

    public void luruxinwen(View view) {
        String s = biaoti.getText().toString();
        String s1 = neirong.getText().toString();
        Newssss new1= new Newssss(s,s1);
        //插入数据库中
        long jieguo1 = mySQLiteOpenHelper2.insertDatatonews(new1);
        if (jieguo1 != -1){
            Toast.makeText(this, "新闻录入成功！", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "新闻录入失败！", Toast.LENGTH_SHORT).show();
        }
    }
}