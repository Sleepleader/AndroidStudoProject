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
import android.widget.ImageView;
import android.widget.TextView;


public class gouwu_Fragment extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView t2;

    private String mParam1;
    private String mParam2;

    private ImageView gouwuche,shangpin1,shangpin2,shangpin3,shangpin4,shangpin5,shangpin6,shangpin7,shangpin8;

    public gouwu_Fragment() {
        // Required empty public constructor
    }



    public static gouwu_Fragment newInstance(String param1, String param2) {
        gouwu_Fragment fragment = new gouwu_Fragment();
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
        return inflater.inflate(R.layout.fragment_gouwu_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gouwuche = view.findViewById(R.id.gouwucheyemiankong);
        shangpin1 = view.findViewById(R.id.shangpin1);
        shangpin2 = view.findViewById(R.id.shangpin2);
        shangpin3 = view.findViewById(R.id.shangpin3);
        shangpin4 = view.findViewById(R.id.shangpin4);
        shangpin5 = view.findViewById(R.id.shangpin5);
        shangpin6 = view.findViewById(R.id.shangpin6);
        shangpin7 = view.findViewById(R.id.shangpin7);
        shangpin8 = view.findViewById(R.id.shangpin8);
        gouwuche.setOnClickListener(this);
        shangpin8.setOnClickListener(this);
        shangpin7.setOnClickListener(this);
        shangpin6.setOnClickListener(this);
        shangpin5.setOnClickListener(this);
        shangpin4.setOnClickListener(this);
        shangpin2.setOnClickListener(this);
        shangpin1.setOnClickListener(this);
        shangpin3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.gouwucheyemiankong:
                Intent i1 =new Intent(getActivity(),gouwucheyemiankong.class);
                startActivity(i1);
                break;
            case R.id.shangpin1:
                Intent i2=new Intent(getActivity(),shangpinxiangxiyemian.class);
                startActivity(i2);
                break;
            default:
                Intent i4 =new Intent(getActivity(),xinwenyemian4.class);
                startActivity(i4);
                break;


        }

    }
}