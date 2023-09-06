package com.example.task.Services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.task.DAOs.Dao;
import com.example.task.Model.Test;

@Service
public class TestService {
    @Autowired
    private Dao<Test> testDao ;

    public Collection<Test> getAllData()
    {
        return testDao.getAll();
    }
    
    public Optional<Test> getOneRecord(UUID id)
    {
        return testDao.get(id);
    }

    public void deleteRecord(Test t)
    {
        testDao.delete(t);
    }
    public void deleteRecordById(UUID id)
    {
        testDao.deleteById(id);
        System.out.println("The test id : "+ id +" is deleted now");
    }

    public Collection<Test> getDataByManagerId(String id)
    {
        return testDao.getDataByManagerId(id);
    }

    public Test addRecord(Test t)
    {
        // t.setName("test2");
        //     // t.setManager(new HashMap<String,String>(){{
        //     // put("mid", "2");
        //     // put("name", "manager2");
        //     // put("email", "test2@gmail.com");
        //     //  }});
        //  t.addManager("mid", "2");
        // t.addManager("name", "manager2");
        // t.addManager("email", "test2@gmail.com");
        // t.setIsdeleted(false);
        testDao.save(t);
        return t;

    }

    public void remove(UUID id)
    {
        testDao.remove(id);
    }



    
}
