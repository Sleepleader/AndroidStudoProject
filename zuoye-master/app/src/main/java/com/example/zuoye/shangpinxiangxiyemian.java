package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class shangpinxiangxiyemian extends AppCompatActivity implements View.OnClickListener {
private Button goumai,jiagou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangpinxiangxiyemian);
        findtview();
        eventview();
    }

    private void eventview() {
        goumai.setOnClickListener(this);
        jiagou.setOnClickListener(this);

    }

    private void findtview() {
        goumai = findViewById(R.id.goumai);
        jiagou = findViewById(R.id.jiagou);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.goumai:
                Toast.makeText(shangpinxiangxiyemian.this, "抱歉，您的余额不足", Toast.LENGTH_SHORT).show();
                break;
            case R.id.jiagou:
                Intent i1 =new Intent(this,gouwucheyemian.class);
                Toast.makeText(shangpinxiangxiyemian.this, "加购成功！", Toast.LENGTH_SHORT).show();
                startActivity(i1);
        }
    }
}