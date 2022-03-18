package com.dot.roomexample.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "NoDo_Table")
public class Nodo
{
    @PrimaryKey(autoGenerate = true)
    int id;

    @NonNull
    @ColumnInfo(name = "nodo_col")
    String nodo;

    public Nodo(String nodo) {
        this.nodo = nodo;
    }

    public String getNodo() {
        return nodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNodo(@NonNull String nodo) {
        this.nodo = nodo;
    }

}
