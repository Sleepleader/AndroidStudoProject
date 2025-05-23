package com.example.zuoye.bean;

public class Gouwu {
    private String shangpinming;
    private String goumairen;

    public Gouwu() {
    }

    public Gouwu(String shangpinming, String goumairen) {
        this.shangpinming = shangpinming;
        this.goumairen = goumairen;
    }

    /**
     * 获取
     * @return shangpinming
     */
    public String getShangpinming() {
        return shangpinming;
    }

    /**
     * 设置
     * @param shangpinming
     */
    public void setShangpinming(String shangpinming) {
        this.shangpinming = shangpinming;
    }

    /**
     * 获取
     * @return goumairen
     */
    public String getGoumairen() {
        return goumairen;
    }

    /**
     * 设置
     * @param goumairen
     */
    public void setGoumairen(String goumairen) {
        this.goumairen = goumairen;
    }

    public String toString() {
        return "Gouwu{shangpinming = " + shangpinming + ", goumairen = " + goumairen + "}";
    }
}
