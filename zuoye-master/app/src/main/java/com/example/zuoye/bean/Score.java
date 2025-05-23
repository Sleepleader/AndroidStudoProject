package com.example.zuoye.bean;

public class Score {
    private String name;
    private String subject;
    private String score;

    public Score() {
    }

    public Score(String name, String subject, String score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 获取
     * @return score
     */
    public String getScore() {
        return score;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(String score) {
        this.score = score;
    }

    public String toString() {
        return "Score{name = " + name + ", subject = " + subject + ", score = " + score + "}";
    }
}
