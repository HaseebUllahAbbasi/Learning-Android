package com.example.arslan_3_dec;

public class Persons {

    public Persons(String name, String phone, String email,int img) {
        Name = name;
        Phone = phone;
        Email = email;
        this.img = img;
    }

    String Name;
    String Phone;
    String Email;
    int img;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
