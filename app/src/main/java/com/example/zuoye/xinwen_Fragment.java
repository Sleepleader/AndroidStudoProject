package com.example.zuoye;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class xinwen_Fragment extends Fragment implements View.OnClickListener {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private TextView t1;
    //5个新闻框
    private LinearLayout xinwenkuang1,xinwenkuang2,xinwenkuang3,xinwenkuang4,xinwenkuang5;


    public xinwen_Fragment() {
        // Required empty public constructor
    }



    public static xinwen_Fragment newInstance(String param1, String param2) {
        xinwen_Fragment fragment = new xinwen_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    /*在fragment中布局的引入在oncreateview中，相当于activity里的oncreate方法*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xinwen_, container, false);

    }



    @Override
    /*在fragment中的其他控件的绑定在onviewcreated进行*/
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initdata();
        /*然后控件的绑定和实例化不能像在acticity里一样用findViewById的方法绑定，要向下面这样*/
        xinwenkuang1 = view.findViewById(R.id.xinwendantiaokuang1);
        xinwenkuang2= view.findViewById(R.id.xinwendantiaokuang2);
        xinwenkuang3=view.findViewById(R.id.xinwendantiaokuang3);
        xinwenkuang4=view.findViewById(R.id.xinwendantiaokuang4);
        xinwenkuang5=view.findViewById(R.id.xinwendantiaokuang5);
        /*对这些linearlayout都添加一些点击事件*/
        xinwenkuang1.setOnClickListener(this);
        xinwenkuang2.setOnClickListener(this);
        xinwenkuang3.setOnClickListener(this);
        xinwenkuang4.setOnClickListener(this);
        xinwenkuang5.setOnClickListener(this);






    }

    private void initdata() {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.xinwendantiaokuang1:
                Intent i1=new Intent(getActivity(),xinwenyemian1.class);
                startActivity(i1);
                break;
            case R.id.xinwendantiaokuang2:
                Intent i2=new Intent(getActivity(),xinwenyemian2.class);
                startActivity(i2);
                break;
            case R.id.xinwendantiaokuang3:
                Intent i3=new Intent(getActivity(),xinwenyemian3.class);
                startActivity(i3);
                break;
            default:
                Intent i4=new Intent(getActivity(),xinwenyemian4.class);
                startActivity(i4);
                break;




        }
    }
}