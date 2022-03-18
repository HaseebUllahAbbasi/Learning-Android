package com.dot.roomexample.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dot.roomexample.util.NodoRepo;

import java.util.List;

public class NoDoViewModel extends AndroidViewModel {
    private NodoRepo noDoRepository;
    private LiveData<List<Nodo>> allNoDos;

    public NoDoViewModel(@NonNull Application application) {
        super(application);
        noDoRepository = new NodoRepo(application);
        allNoDos = noDoRepository.getAllNoDos();
    }

    public LiveData<List<Nodo>> getAllNoDos() {
        return allNoDos;
    }

    public void insert(Nodo noDo) {
        noDoRepository.insert(noDo);
    }
}
