package com.dot.dictionarydot;

public class WordData
{
    int id;
    String word;
    String description;

    public WordData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WordData(int id, String word, String description) {
        this.id = id;
        this.word = word;
        this.description = description;
    }

    @Override
    public String toString() {
        return word;
    }
}
