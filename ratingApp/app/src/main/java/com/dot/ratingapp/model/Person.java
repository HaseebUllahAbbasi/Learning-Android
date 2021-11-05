package com.dot.ratingapp.model;

public class Person
{
    String name;
    Double ratings;
    String detail;
    Integer img;

    public Person()
    {

    }

    public Person(String name, Double ratings, String detail, Integer img) {
        this.name = name;
        this.ratings = ratings;
        this.detail = detail;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ratings=" + ratings +
                ", detail='" + detail + '\'' +
                ", img=" + img +
                '}';
    }
}
