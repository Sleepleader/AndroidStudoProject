package com.example.zuoye;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.zuoye.bean.Good;
import com.example.zuoye.bean.Gouwu;
import com.example.zuoye.bean.Newssss;
import com.example.zuoye.bean.Score;
import com.example.zuoye.bean.User;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="mySQLite.db";

    private  static final String create_users ="create TABLE users (zhanghao varchar(32),mima varchar(32))";
    private  static final String create_goods ="create TABLE goods (name varchar(32),price int,introduction varchar(128))";
    private  static final String create_score ="create TABLE score (name varchar(32),subject varchar(32),score int)";
    private  static final String create_news ="create TABLE news (title varchar(32),context varchar(128))";
  //  private  static final String create_gouwu ="create TABLE gouwu (shangpinming varchar(32),goumairen varchar(32))";
  //  private static final String insert_gouwu ="insert into gouwu(shangpinming,goumairen) values('aj4','王五'),('iPhone 14Pro','kinroy'),('aj4','张三'),('playstation5','李四')";



    // 根据 name 和 subject 删除 score 表中的记录
    public int deleteScore(String name, String subject) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("score", "name=? AND subject=?", new String[]{name, subject});
    }

    // 更新 score 表中的 score 字段
    public int updateScore(String name, String subject, int newScore) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("score", newScore);
        return db.update("score", values, "name=? AND subject=?", new String[]{name, subject});
    }





    public MySQLiteOpenHelper(Context context){
        super(context,DB_NAME,null,1);

    }
    public boolean deleteUserInfo(String zhanghao) {
        SQLiteDatabase db = getWritableDatabase();
        int rowsDeleted = db.delete("users", "zhanghao=?", new String[]{zhanghao});
        return rowsDeleted > 0;
    }

    public boolean updateUserInfo(String oldZhanghao, String newZhanghao, String newMima) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("zhanghao", newZhanghao);
        values.put("mima", newMima);

        int rowsAffected = db.update("users", values, "zhanghao=?", new String[]{oldZhanghao});
        return rowsAffected > 0;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //在数据库被创建的时候，调用一次这个方法,则我们这这创建表
        db.execSQL(create_users);
        db.execSQL(create_goods);
        db.execSQL(create_score);
        db.execSQL(create_news);
//        db.execSQL(create_gouwu);
//        db.execSQL(insert_gouwu);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //注册功能的向user表中插入数据的方法
    public long insertDatatousers(User user){
        //向user表中加入数据
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("zhanghao",user.getZhanghao());
        values.put("mima",user.getMima());
        return db.insert("users",null,values);


    }

    //在管理员模块中可以录入商品信息
    public long insertDatatogoods(Good good){
        //向goods商品表添加数据
        SQLiteDatabase db1 = getWritableDatabase();
        ContentValues values1= new ContentValues();
        values1.put("name",good.getName());
        values1.put("price",good.getPrice());
        values1.put("introduction",good.getIntruduction());
        return db1.insert("goods",null,values1);


    }
    //在管理员模块中可以录入新闻信息
    public long insertDatatonews(Newssss New){
        SQLiteDatabase db2 = getWritableDatabase();
        ContentValues values2= new ContentValues();
        values2.put("title",New.getTitle());
        values2.put("context",New.getContext());
        return db2.insert("news",null,values2);
    }
    //在管理员模块中可以录入学生的各科成绩
    public long insertDatatoscore(Score score){
        SQLiteDatabase db3 = getWritableDatabase();
        ContentValues values3= new ContentValues();
        values3.put("name",score.getName());
        values3.put("subject",score.getSubject());
        values3.put("score",score.getScore());
        return db3.insert("score",null,values3);

    }
    //通过商品名可以查询到有那些人购买了这件商品
    public List<Gouwu> queryFromgouwu(String shangpinming){
        SQLiteDatabase db4 = getWritableDatabase();
        List<Gouwu>gouwuList = new ArrayList<>();
        Cursor gouwu = db4.query("gouwu", null, "shangpinming like ?", new String[]{shangpinming}, null, null, null);
        if (gouwu != null){
            while (gouwu.moveToNext()){
                String shangpin = gouwu.getString(0);
                String goumairen = gouwu.getString(1);
                Gouwu g =new Gouwu(shangpin,goumairen);
                gouwuList.add(g);


            }
            gouwu.close();
        }
        return gouwuList;

    }
    //通过对user表进行查询来实现登录功能
    public boolean queryFromusers(String zhanghao,String mima){
        SQLiteDatabase db5 = getWritableDatabase();
        List<User> userList =new ArrayList<>();
        boolean result=false;
        Cursor users = db5.query("users", null, "zhanghao like ?", new String[]{zhanghao}, null, null, null);
        if (users != null){
            while (users.moveToNext()){
                String mima1 = users.getString(1);
                 result = mima1.equals(mima);
                 return result;
            }
        }
        return false;
    }

}
