package com.dot.dot_db_android.model;

public class Contact
{
    int id;
    String phone;
    String name;

    public Contact(int id, String phone, String name) {
        this.id = id;
        this.phone = phone;
        this.name = name;
    }

    public Contact(String name, String phone) {
        this
                .phone = phone;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
