package com.example.zuoye;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class geren_Fragment extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private TextView t3;

    private LinearLayout jidian,kecheng,paiming,zhuxiao;


    public geren_Fragment() {
        // Required empty public constructor
    }

    public static geren_Fragment newInstance(String param1, String param2) {
        geren_Fragment fragment = new geren_Fragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_geren_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        jidian = view.findViewById(R.id.jidian);
        kecheng = view.findViewById(R.id.kecheng);
        paiming = view.findViewById(R.id.paiming);
        zhuxiao = view.findViewById(R.id.zhuxiao);
        jidian.setOnClickListener(this);
        kecheng.setOnClickListener(this);
        paiming.setOnClickListener(this);
        zhuxiao.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.paiming:
                Intent i1=new Intent(getActivity(), paiming.class);
                startActivity(i1);
                break;
            case R.id.zhuxiao:
                Intent i2= new Intent(getActivity(),MainActivity.class);
                startActivity(i2);
                break;
            case R.id.kecheng:
                Intent i3 = new Intent(getActivity(),kecheng.class);
                startActivity(i3);
                break;
        }

    }
}