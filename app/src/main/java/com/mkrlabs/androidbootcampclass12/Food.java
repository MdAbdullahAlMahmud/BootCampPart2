package com.mkrlabs.androidbootcampclass12;

public class Food {
    private String id;
    private String name;
    private String url;
    private String desc;

    public Food(String id, String name, String url, String desc) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
