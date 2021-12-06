package com.example.numberslab7_3;

public class Numbers {
    String counting;
    String numbering;
    int img;

    public Numbers(String counting, String numbering, int img) {
        this.counting = counting;
        this.numbering = numbering;
        this.img = img;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    public String getCounting() {
        return counting;
    }

    public void setCounting(String counting) {
        this.counting = counting;
    }

    public String getNumbering() {
        return numbering;
    }

    public void setNumbering(String numbering) {
        this.numbering = numbering;
    }
}
