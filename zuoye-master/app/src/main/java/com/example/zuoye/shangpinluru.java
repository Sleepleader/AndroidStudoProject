package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zuoye.bean.Good;

public class shangpinluru extends AppCompatActivity {
    private EditText shangpinming,jiage,xiangqing;
    private Button lurushangpin,backButton;
    private MySQLiteOpenHelper mySQLiteOpenHelper3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangpinluru);
        mySQLiteOpenHelper3 = new MySQLiteOpenHelper(this);
        findviews();
    }

    private void findviews() {
        shangpinming = findViewById(R.id.lurushangpinming);
        jiage = findViewById(R.id.lurujiage);
        xiangqing = findViewById(R.id.lurushangpinxinxi);
        lurushangpin = findViewById(R.id.lu3);

        backButton = findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 关闭当前Activity并返回到上一个页面
            }
        });
    }

    public void lurushangpin(View view) {
        String s = shangpinming.getText().toString();
        String s1 = jiage.getText().toString();
        String s2 = xiangqing.getText().toString();
        Good good=new Good(s1,s,s2);
        long fanhui = mySQLiteOpenHelper3.insertDatatogoods(good);
        if (fanhui != -1){
            Toast.makeText(this,"商品录入成功！",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"商品录入失败！",Toast.LENGTH_SHORT).show();
        }
    }
}