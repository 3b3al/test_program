package com.example.task.Controllers;


import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.Model.Test;
import com.example.task.Services.TestService;

@RestController
public class TestController {
    @Autowired
    TestService testService;
    // ---------- api to get all programs without specific name ------------
    @GetMapping("/")
    public Collection<Test> getAllData()
    {
        System.out.println ("test get all data " +  testService.getAllData() );
        return testService.getAllData();
       
    }

    //---------api to get all programs with specific manager id ------------
      @GetMapping("/manager/{id}")
     public Collection<Test> getByMangerId(@PathVariable String id)
    {
         return testService.getDataByManagerId(id);
    }
    
    //---------api to soft delete specific program -------------------------
    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable UUID id)
    {
        testService.remove(id);
    }
    
    //--------- Additional Options -------------------------------------------------------------------------------------
    @PostMapping("/add")
    public Test addRecord(@RequestBody Test t)
    {
        System.out.println ("Post data ...");
        testService.addRecord(t);
        return t;
    }

    @GetMapping("/test/{id}")
    public Optional<Test> getTest(@PathVariable UUID id)
    {
        return testService.getOneRecord(id);
    }
   
    @PutMapping("/deleteById/{id}")
    void deleteById(@PathVariable UUID id)
    {
        testService.deleteRecordById(id);
    }
    
    @DeleteMapping("/delete")
    void delete(@RequestBody Test t)
    {
        testService.deleteRecord(t);

    }



}
