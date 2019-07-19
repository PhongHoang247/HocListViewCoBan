package com.phong.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private int id;
    private String ten;
    private String phone;

    public Contact() {
    }

    public Contact(int id, String ten, String phone) {
        this.id = id;
        this.ten = ten;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.ten + " - " + this.phone;
        //Khi đẩy vào adapter thì tự động hàm toString đc thực thi
    }
}
