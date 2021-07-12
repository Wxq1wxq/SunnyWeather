package com.example.sunnyweather.db;

public class DataBaseBean {
    private int _id;
    private String city;

    private String content;

    public DataBaseBean() {
    }

    public DataBaseBean(String city, int _id, String content) {
        this.city = city;
        this._id = _id;
        this.content = content;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
