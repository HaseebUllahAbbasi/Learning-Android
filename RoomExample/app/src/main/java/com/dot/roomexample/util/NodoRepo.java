package com.dot.roomexample.util;

import android.app.Application;
import android.media.ApplicationMediaCapabilities;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.dot.roomexample.data.NoDo_DAO;
import com.dot.roomexample.data.NodoRoomDataBase;
import com.dot.roomexample.model.Nodo;

import java.util.List;

public class NodoRepo
{
    private NoDo_DAO dao;
    LiveData<List<Nodo>> allNodos;
    public NodoRepo(Application application)
    {
        NodoRoomDataBase db = NodoRoomDataBase.getDatabase(application);
        dao = db.dao();
        allNodos = dao.getAllNodos();


    }
    public LiveData<List<Nodo>> getAllNoDos() {
        return allNodos;
    }
    public void insert(Nodo noDo){
//        new insertAsyncTask(noDoDao).execute(noDo);

    }
    private class insertAsyncTask extends AsyncTask<Nodo, Void, Void>
    {
        private NoDo_DAO asyncTaskDao;
        public insertAsyncTask(NoDo_DAO dao)
        {
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(Nodo... params) {
            //[obj1, obj2....]
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}

