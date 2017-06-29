package com.fatchao.gangedrecyclerview;


import java.io.Serializable;

public class SortBean implements Serializable {
    private String name;
    private String tag;
    private boolean isTitle;

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    public SortBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }







}
