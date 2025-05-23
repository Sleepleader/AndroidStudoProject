package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class gouwucheyemian extends AppCompatActivity implements View.OnClickListener {
private ImageView quxiao,fanhui2;
private Button jiesuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gouwucheyemian);
        findview();
        initview();
    }



    private void findview() {
        quxiao = findViewById(R.id.quxiao);
        jiesuan = findViewById(R.id.jiesuan);
        fanhui2 = findViewById(R.id.fanhui2);
    }
    private void initview() {
    quxiao.setOnClickListener(this);
    jiesuan.setOnClickListener(this);
    fanhui2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.quxiao:
                setContentView(R.layout.activity_gouwucheyemian);
                break;
            case R.id.jiesuan:
                Toast.makeText(gouwucheyemian.this, "您的余额不足！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fanhui2:
                Intent i2 =new Intent(this,shangpinxiangxiyemian.class);
                startActivity(i2);
                break;

        }
    }
}