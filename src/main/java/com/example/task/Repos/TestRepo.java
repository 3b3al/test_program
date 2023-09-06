package com.example.task.Repos;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.task.Model.Test;

public interface TestRepo extends JpaRepository<Test,UUID> {

     @Query("from Test where isdeleted=false")
     public Collection<Test> getAllData();

    @Query("update Test set isdeleted =true where id =?1")
     public void deleteTestById(UUID id);

    //FROM test WHERE manager->>'mid' =?
    @Query(value = "SELECT * FROM Test WHERE manager->>'mid' = ?1 and is_deleted='false'", nativeQuery = true)  
     public  Collection<Test> getDataByManagerId(String id);

     
    
}
