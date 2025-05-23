package com.example.zuoye.bean;

public class Good {
    private String price;
    private String name;
    private String intruduction;

    public Good() {
    }

    public Good(String price, String name, String intruduction) {
        this.price = price;
        this.name = name;
        this.intruduction = intruduction;
    }

    /**
     * 获取
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
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
     * @return intruduction
     */
    public String getIntruduction() {
        return intruduction;
    }

    /**
     * 设置
     * @param intruduction
     */
    public void setIntruduction(String intruduction) {
        this.intruduction = intruduction;
    }

    public String toString() {
        return "User{price = " + price + ", name = " + name + ", intruduction = " + intruduction + "}";
    }
}
