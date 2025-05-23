package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class paiming extends AppCompatActivity implements View.OnClickListener {
    private ImageView fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiming);
        findview();
        intview();
    }

    private void findview() {
    fanhui=findViewById(R.id.paimingfanhui);

    }

    private void intview() {
        fanhui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.paimingfanhui:
                Intent i6=new Intent(this,yonghu.class);
                startActivity(i6);
        }
    }
}