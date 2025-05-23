package com.example.zuoye;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zuoye.MainActivity;
import com.example.zuoye.R;

import com.example.zuoye.bean.User;
import com.example.zuoye.guanliyuan;
import com.example.zuoye.yonghu;

public class zhuche extends AppCompatActivity /*implements View.OnClickListener*/ {
    private EditText zhuanghao,mima;
    private Button zhuche;
    String zhanghao1,mima1;
    private MySQLiteOpenHelper mySQLiteOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuche);
        mySQLiteOpenHelper = new MySQLiteOpenHelper(this);
        findViews();
    }
    private void findViews() {
        zhuanghao = findViewById(R.id.zhuchezhuanghao);
        mima = findViewById(R.id.zhuchemima);
        zhuche = findViewById(R.id.button_zhuche);

    }


    public void insert(View view) {
        zhanghao1 = zhuanghao.getText().toString();
        mima1 = mima.getText().toString();
        User u =new User(zhanghao1,mima1);
        //插入数据库中
        long jieguo = mySQLiteOpenHelper.insertDatatousers(u);
        if (jieguo !=-1 ){
            Toast.makeText(this,"注册成功！",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"注册失败！",Toast.LENGTH_SHORT).show();
        }
        Intent i1 =new Intent(this,MainActivity.class);
        startActivity(i1);


    }
}
