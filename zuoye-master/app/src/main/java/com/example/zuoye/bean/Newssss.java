package com.example.zuoye.bean;

public class Newssss {
    private String title;
    private String context;

    public Newssss() {
    }

    public Newssss(String title, String context) {
        this.title = title;
        this.context = context;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return context
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置
     * @param context
     */
    public void setContext(String context) {
        this.context = context;
    }

    public String toString() {
        return "New{title = " + title + ", context = " + context + "}";
    }
}
