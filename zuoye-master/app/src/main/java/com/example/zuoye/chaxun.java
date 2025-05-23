package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.zuoye.bean.Gouwu;

import java.util.List;

public class chaxun extends AppCompatActivity {
    private Button chaxun;
    private EditText shangpinming;
    private MySQLiteOpenHelper mySQLiteOpenHelper4;
    private TextView jieguoxianshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaxun);
        mySQLiteOpenHelper4 = new MySQLiteOpenHelper(this);
        findviews();
    }

    private void findviews() {
        chaxun = findViewById(R.id.chaxunb);
        shangpinming = findViewById(R.id.chaxunshangpinming);
        jieguoxianshi = findViewById(R.id.result);
    }

//    public void chaxun(View view) {
//        String s = shangpinming.getText().toString();
//        List<Gouwu> gouwuList = mySQLiteOpenHelper4.queryFromgouwu(s);
//        String result="";
//        if (gouwuList != null){
//            Toast.makeText(this,"查询成功！",Toast.LENGTH_SHORT).show();
//            for (int i = 0; i < gouwuList.size(); i++) {
//                String shangpinming = gouwuList.get(i).getShangpinming();
//                String goumairen = gouwuList.get(i).getGoumairen();
//                result +="商品名："+shangpinming+"  "+"购买人："+goumairen+"\n";
//            }
//            jieguoxianshi.setText(result);
//
//        }else {
//            Toast.makeText(this,"查询失败！",Toast.LENGTH_SHORT).show();
//        }
//
//
//    }
}