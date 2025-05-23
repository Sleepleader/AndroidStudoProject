package com.example.zuoye.bean;

public class User {
    private String zhanghao;
    private String mima;


    public User() {
    }

    public User(String zhanghao, String mima) {
        this.zhanghao = zhanghao;
        this.mima = mima;

    }

    /**
     * 获取
     * @return zhanghao
     */
    public String getZhanghao() {
        return zhanghao;
    }

    /**
     * 设置
     * @param zhanghao
     */
    public void setZhanghao(String zhanghao) {
        this.zhanghao = zhanghao;
    }

    /**
     * 获取
     * @return mima
     */
    public String getMima() {
        return mima;
    }

    /**
     * 设置
     * @param mima
     */
    public void setMima(String mima) {
        this.mima = mima;
    }



    public String toString() {
        return "User{zhanghao = " + zhanghao + ", mima = " + mima + "}";
    }
}
