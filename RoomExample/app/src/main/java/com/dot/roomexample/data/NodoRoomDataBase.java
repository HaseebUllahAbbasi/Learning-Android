package com.dot.roomexample.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dot.roomexample.model.Nodo;

@Database(entities = {Nodo.class},version = 1)
public abstract class  NodoRoomDataBase extends RoomDatabase
{
//    @Database(entities = {Nodo.class,})

    private static volatile NodoRoomDataBase INSTANCE;
    public abstract NoDo_DAO dao();

    public static NodoRoomDataBase getDatabase(final Context context)
    {
        if(INSTANCE == null)
        {
            synchronized (NodoRoomDataBase.class)
            {
                if(INSTANCE  == null)
                {
                    INSTANCE  = Room.databaseBuilder(context.getApplicationContext(),NodoRoomDataBase.class,"nodo_database").build();


                }

            }
        }
        return INSTANCE;
    }


}
