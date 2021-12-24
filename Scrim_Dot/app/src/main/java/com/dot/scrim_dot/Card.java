package com.dot.scrim_dot;

import android.os.Parcel;
import android.os.Parcelable;

public class Card  implements Parcelable {

    String name;
    int value;
    int picture;

    public Card() {

    }

    public Card(String name, int value, int picture) {
        this.name = name;
        this.value = value;
        this.picture = picture;
    }

    protected Card(Parcel in) {
        name = in.readString();
        value = in.readInt();
        picture = in.readInt();
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", picture=" + picture +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(value);
        dest.writeInt(picture);
    }
}
