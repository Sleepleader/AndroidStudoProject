package com.example.zuoye;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public String ut="";
    private Spinner userSpinner=null;
    private Handler handler;

    private Button button,button1;
    private EditText musername,mpassword;
    private MySQLiteOpenHelper mySQLiteOpenHelper6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySQLiteOpenHelper6 = new MySQLiteOpenHelper(this);
        findViews();
        intevent();
    }

    private void intevent() {
        Intent intent1=new Intent(this,yonghu.class);
        Intent intent2=new Intent(this,guanliyuan.class);
        //给注册绑定一个点击事件
        button1.setOnClickListener(this);
        button.setOnClickListener(this);

    }

    private void findViews() {
        //button
        button=findViewById(R.id.button_1);
        button1=findViewById(R.id.button_2);
        //Spinner
        userSpinner=(Spinner)findViewById(R.id.spin_1);
        String[] usertype={"学生登录","管理员登录"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,usertype);
        userSpinner.setAdapter(adapter);

        //输入框
         musername=(EditText) findViewById(R.id.edit_text_1);
         mpassword=(EditText) findViewById(R.id.edit_text_2);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent1 = new Intent(this, yonghu.class); // 用户Intent
        Intent intent2 = new Intent(this, guanliyuan.class); // 管理员Intent
        switch (id){
            case R.id.button_2:
                Intent i3 = new Intent(this, zhuche.class);
                startActivity(i3);
                break;
            case R.id.button_1:
                String s = musername.getText().toString();
                String s1 = mpassword.getText().toString();

                // 检查是否为管理员账户
                if ("1".equals(s) && "ad".equals(s1)){
                    System.out.println("走到这里了，管理员登录");
                    startActivity(intent2);
                }
                // 如果不是管理员，则检查普通用户（根据你之前的逻辑）
                else {
                    boolean b = mySQLiteOpenHelper6.queryFromusers(s, s1);
                    if (b && s != "" && s1 != ""){
                        System.out.println("走到这里了，学生登录");
                        startActivity(intent1);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }


}



