package com.example.task.DAOs;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import com.example.task.Model.Test;

public interface Dao<T>{
    Optional<T> get(UUID id);
    Collection<T> getAll();
    String save(T t);
    T update(T t);
    void delete(T t);
    void deleteById(UUID id);
    Collection<Test> getDataByManagerId(String id);
    public void remove(UUID id);
       
}


    

