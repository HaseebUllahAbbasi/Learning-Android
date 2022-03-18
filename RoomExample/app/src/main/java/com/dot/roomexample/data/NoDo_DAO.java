package com.dot.roomexample.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.dot.roomexample.model.Nodo;

import org.w3c.dom.Node;

import java.util.List;

@Dao
public interface NoDo_DAO
{
    @Insert
    void insert(Nodo nodo);

    @Query("DELETE FROM NoDo_Table")
    void deleteAll();

    @Query("DELETE FROM NoDo_Table WHERE id = :id")
    void deleteNodo(int id);

    @Query("UPDATE  NoDo_Table SET nodo_col = :nodoText   WHERE  id = :id")
    int updateNodoItem(int id, String nodoText);

//    @Query("SELECT * FROM NoDo_Table ORDER BY nodo_col DESC")
//    List<Nodo> getAllNodos();

    @Query("SELECT * FROM NoDo_Table ORDER BY nodo_col DESC")
    LiveData<List<Nodo>> getAllNodos();
}
