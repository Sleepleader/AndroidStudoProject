package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class gouwucheyemiankong extends AppCompatActivity implements View.OnClickListener {
private Button kong;
private ImageView fanhui1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gouwucheyemiankong);
        findview();
        initview();

    }



    private void findview() {
    kong =findViewById(R.id.jiesuan1);
    fanhui1 = findViewById(R.id.fanhui1);
    }
    private void initview() {
    kong.setOnClickListener(this);
    fanhui1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.jiesuan1:
                Toast.makeText(gouwucheyemiankong.this, "当前购物车为空", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fanhui1:
                Intent i1 =new Intent(this,yonghu.class);
                startActivity(i1);
                break;
        }
    }
}