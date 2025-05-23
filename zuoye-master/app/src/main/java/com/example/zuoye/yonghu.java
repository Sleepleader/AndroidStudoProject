package com.example.zuoye;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class yonghu extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout xinwen,gouwu,geren;
    private ImageView xinwentu,gouwutu,gerentu;
    private TextView xinwenzi,gouwuzi,gerenzi;
    FragmentManager fram;
    FragmentManager fram1;
    FragmentManager fram2;
    FragmentTransaction fragmentTransaction;
    FragmentTransaction fragmentTransaction1;
    FragmentTransaction fragmentTransaction2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yonghu);
        Intent intent=this.getIntent();
        intView();
        intevent();

    }
    private void bianhuise(){
        xinwentu.setSelected(false);
        gouwutu.setSelected(false);
        gerentu.setSelected(false);

    }

    private void intevent() {
        /*       默认首页是新闻页面*/
        //添加fragment到这里来实现页面的切换
        fram = getSupportFragmentManager();
        fragmentTransaction = fram.beginTransaction();
        //创建一个新闻页面fragment的实例
        xinwen_Fragment xinwenf= xinwen_Fragment.newInstance("这是新闻页面","");
        //替换成新闻页面
        fragmentTransaction.replace(R.id.f1,xinwenf).commit();
        xinwentu.setSelected(true);

        //这里我为整个界面设置了监听，点击了我这个layout后，会跳到onclick方法去处理
        xinwen.setOnClickListener(this);
        gouwu.setOnClickListener(this);
        geren.setOnClickListener(this);


    }

    private void intView() {
        /*这这里对用户界面的一些控件进行实例化*/
        xinwen = findViewById(R.id.xinwenlayout);
        gouwu = findViewById(R.id.gouwulayout);
        geren = findViewById(R.id.gerenlayout);

        xinwentu = findViewById(R.id.xinwentu);
        gouwutu = findViewById(R.id.gouwutu);
        gerentu = findViewById(R.id.gerentu);

        xinwenzi =findViewById(R.id.xinwenzi);
        gouwuzi = findViewById(R.id.gouwuzi);
        gerenzi = findViewById(R.id.gerenzi);



    }

    @Override
    public void onClick(View view) {
        /*在这里区分，点击的是哪一个按钮*/
        int id = view.getId();
        bianhuise();
        switch (id){
            case R.id.xinwenlayout:
                fram = getSupportFragmentManager();
                fragmentTransaction = fram.beginTransaction();
                //创建一个新闻页面fragment的实例
                xinwen_Fragment xinwenf= xinwen_Fragment.newInstance("这是新闻页面","");
                //替换成新闻页面
                fragmentTransaction.replace(R.id.f1,xinwenf).commit();
                xinwentu.setSelected(true);
                break;
            case R.id.gouwulayout:
                //创建一个购物页面fragment的实例
                fram = getSupportFragmentManager();
                fragmentTransaction = fram.beginTransaction();
                //创建一个新闻页面fragment的实例
                gouwu_Fragment gouwuf = gouwu_Fragment.newInstance("", "");
                //替换成新闻页面
                fragmentTransaction.replace(R.id.f1,gouwuf).commit();
                gouwutu.setSelected(true);
                break;
            case R.id.gerenlayout:
                fram = getSupportFragmentManager();
                fragmentTransaction = fram.beginTransaction();
                //创建一个新闻页面fragment的实例
                /*geren_Fragment gerenf= xinwen_Fragment.newInstance("这是个人页面","");*/
                geren_Fragment gerenf = geren_Fragment.newInstance("","");
                //替换成新闻页面
                fragmentTransaction.replace(R.id.f1,gerenf).commit();
                gerentu.setSelected(true);
                break;
            default:
                break;


        }
    }
}
