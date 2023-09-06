package com.example.task.DAOs.DaoImpl;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.task.DAOs.Dao;
import com.example.task.Model.Test;
import com.example.task.Repos.TestRepo;

@Component
public class TestDao implements Dao<Test>{
    


    @Autowired
    private TestRepo testRepo ;
    @Override
    public void delete(Test t) {
        t.setIsdeleted(true);
        System.out.println("Deleted  .....");
        
    }
    
    @Override
    public void deleteById(UUID id) {
         testRepo.deleteTestById(id);
        // testRepo.deleteById(id);
    }

    @Override
    public Optional<Test> get(UUID id) {
        
        return testRepo.findById(id);
    }

    @Override
    public Collection<Test> getAll() {
        
         return testRepo.getAllData();
        //  return testRepo.findAll();
    }

    @Override
    public String save(Test t) {
        testRepo.save(t);
        return t.getId().toString();
    }

    @Override
    public Test update(Test t) {
        testRepo.save(t);
        return t;
    }

     @Override
     public Collection<Test> getDataByManagerId(String id) {
        
         return testRepo.getDataByManagerId(id);
    }

    @Override
    public void remove(UUID id)
    {
        testRepo.deleteById(id);
    }
    
 
}
